import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class PNGToWebPDonusturucu {

    /**
     * Bir goruntuyu yeniden boyutlandirir. 
     * Genislik orantisina gore yeni bir yukseklik hesaplar ve goruntuyu bu boyutlara donusturur.
     *
     * @param orijinalGorsel Orijinal goruntu
     * @param hedefGenislik Yeniden boyutlandirma sonrasi hedef genislik
     * @return Yeniden boyutlandirilmis goruntu
     */
    public static BufferedImage yenidenBoyutlandir(BufferedImage orijinalGorsel, int hedefGenislik) {
        // Orijinal goruntunun genislik ve yukseklik degerlerini al
        int orijinalGenislik = orijinalGorsel.getWidth();
        int orijinalYukseklik = orijinalGorsel.getHeight();
        
        // Hedef yuksekligi, genislik-yukseklik oranini koruyarak hesapla
        int hedefYukseklik = (int) ((double) hedefGenislik / orijinalGenislik * orijinalYukseklik);

        // Yeni boyutlara uygun bir BufferedImage olustur
        BufferedImage yenidenBoyutlandirilmisGorsel = new BufferedImage(hedefGenislik, hedefYukseklik, orijinalGorsel.getType());
        Graphics2D g = yenidenBoyutlandirilmisGorsel.createGraphics();
        
        // Goruntuyu yeni boyutlara cizer
        g.drawImage(orijinalGorsel, 0, 0, hedefGenislik, hedefYukseklik, null);
        g.dispose(); // Grafik kaynaklarini serbest birak

        return yenidenBoyutlandirilmisGorsel;
    }

    /**
     * Bir PNG veya JPG dosyasini WebP formatina donusturur.
     *
     * @param girdiDosyaYolu Donusturulecek dosyanin tam dosya yolu
     * @param ciktiDosyaYolu Cikis WebP dosyasinin tam dosya yolu
     * @throws IOException Giris veya cikis sirasinda olusabilecek hatalar
     */
    public static void webpyeDonustur(String girdiDosyaYolu, String ciktiDosyaYolu) throws IOException {
        // Giris dosyasini bir BufferedImage nesnesine yukle
        BufferedImage gorsel = ImageIO.read(new File(girdiDosyaYolu));

        // Goruntuyu 300 piksel genislige yeniden boyutlandir
        gorsel = yenidenBoyutlandir(gorsel, 300);

        // Cikis dizininin var oldugundan emin ol, yoksa olustur
        File cikisDizin = new File(ciktiDosyaYolu).getParentFile();
        if (cikisDizin != null && !cikisDizin.exists()) {
            Files.createDirectories(cikisDizin.toPath());
        }

        // Goruntuyu WebP formatinda dosyaya yaz
        if (!ImageIO.write(gorsel, "webp", new File(ciktiDosyaYolu))) {
            throw new IOException("Gorsel WebP formatina donusturulemedi. WebP eklentisinin yuklu oldugundan emin olun.");
        }
    }

    /**
     * Programin ana metodu. Kullanicidan dizin yolunu alir ve bu dizindeki tum PNG/JPG dosyalarini WebP formatina donusturur.
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        
        // Kullanicidan gorsel dosyalarinin bulundugu dizin yolunu al
        System.out.println("Gorsel dosyalarinin bulundugu dizin yolunu girin (PNG/JPG):");
        String dizinYolu = tarayici.nextLine();

        // Kullanicinin verdigi dizin yolunu kontrol et
        File dizin = new File(dizinYolu);
        if (!dizin.exists() || !dizin.isDirectory()) {
            System.err.println("Gecersiz dizin yolu."); // Gecersiz yol uyarisi
            return;
        }

        // Dizin icindeki PNG ve JPG dosyalarini filtrele
        File[] dosyalar = dizin.listFiles((dizinAdi, dosyaAdi) -> dosyaAdi.toLowerCase().endsWith(".png") || dosyaAdi.toLowerCase().endsWith(".jpg"));
        if (dosyalar == null || dosyalar.length == 0) {
            System.out.println("Dizinde PNG veya JPG dosyasi bulunamadi."); // Dosya yok uyarisi
            return;
        }

        // Her bir dosya icin islemleri gerceklestirme
        for (File dosya : dosyalar) {
            try {
                // Goruntuyu BufferedImage olarak yukle
                BufferedImage gorsel = ImageIO.read(dosya);
                if (gorsel == null) {
                    System.out.println("Gorsel okunamadi: " + dosya.getName()); // Okunamayan dosya uyarisi
                    continue;
                }
                
                // Gorsel boyutlarini ekrana yazdir
                int genislik = gorsel.getWidth();
                int yukseklik = gorsel.getHeight();
                System.out.println("Dosya: " + dosya.getName() + " | Boyutlar: " + genislik + "x" + yukseklik);

                // Cikis dosyasinin yolunu belirle
                String ciktiDosyaYolu = dosya.getParent() + File.separator + dosya.getName().replaceAll("\\.(png|jpg)$", ".webp");
                
                // Dosyayi WebP formatina donustur
                webpyeDonustur(dosya.getAbsolutePath(), ciktiDosyaYolu);
                System.out.println("Donusturuldu: " + ciktiDosyaYolu);
            } catch (IOException e) {
                // Islenemeyen dosyalar icin hata mesaji
                System.err.println("Dosya islenirken hata olustu: " + dosya.getName() + " - " + e.getMessage());
            }
        }

        // Kaynaklari serbest birak
        tarayici.close();
    }
}
