import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosyaOkumaYazma {

    public static void main(String[] args) {
        // Okuma yapilacak dosyanin adi
        String girisDosyaAdi = "girdi.txt";
        // Yazma yapilacak dosyanin adi
        String cikisDosyaAdi = "cikti.txt";

        try {
            // Okuma islemini gerceklestir
            byte[] veri = dosyaOku(girisDosyaAdi);

            // Yazma islemini gerceklestir
            dosyaYaz(cikisDosyaAdi, veri);

            System.out.println("Dosya basariyla '" + cikisDosyaAdi + "' dosyasina kopyalandi!");

        } catch (IOException e) {
            // Hata olusursa konsola hata mesajini yaz
            System.out.println("Dosya isleminde bir hata olustu: " + e.getMessage());
        } catch (Exception e) {
            // Beklenmeyen bir hata olusursa yakala
            System.out.println("Beklenmeyen bir hata olustu: " + e.getMessage());
        }
    }

    /**
     * Bir dosyadan veriyi byte dizisi olarak okur.
     * @param dosyaAdi Okuma yapilacak dosyanin adi
     * @return Dosyadan okunan veri
     * @throws IOException Dosya bulunamazsa veya okuma hatasi olusursa
     */
    public static byte[] dosyaOku(String dosyaAdi) throws IOException {
        File girisDosyasi = new File(dosyaAdi);

        if (!girisDosyasi.exists()) {
            throw new IOException("Giris dosyasi bulunamadi: " + dosyaAdi);
        }

        FileInputStream girisAkimi = new FileInputStream(girisDosyasi);
        byte[] veri = new byte[(int) girisDosyasi.length()];

        int okunanByteSayisi = girisAkimi.read(veri);
        System.out.println("Okunan byte sayisi: " + okunanByteSayisi);

        girisAkimi.close();
        return veri;
    }

    /**
     * Bir byte dizisini dosyaya yazar.
     * @param dosyaAdi Yazma yapilacak dosyanin adi
     * @param veri Yazilacak veri
     * @throws IOException Dosya olusturulamazsa veya yazma hatasi olusursa
     */
    public static void dosyaYaz(String dosyaAdi, byte[] veri) throws IOException {
        File cikisDosyasi = new File(dosyaAdi);

        // Dosyanin mevcut olup olmadigini kontrol et
        if (cikisDosyasi.exists()) {
            System.out.println("Uyari: Cikis dosyasi zaten mevcut, uzerine yaziliyor.");
        }

        FileOutputStream cikisAkimi = new FileOutputStream(cikisDosyasi);
        cikisAkimi.write(veri);
        System.out.println("Cikis dosyasina yazma islemi tamamlandi.");

        cikisAkimi.close();
    }
}
