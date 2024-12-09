package checked;
import java.io.*;

public class DosyaOkumaHatasi {

    public static void main(String[] args) {

        try {
            // Dosyayi okumak icin ac
            FileInputStream fis = new FileInputStream("test.txt");

            // Dosyadan veri oku ve ekrana yazdir
            int veri = fis.read();
            System.out.println("Dosya icerigi:");
            while (veri != -1) {
                System.out.print((char) veri); // Okunan veriyi karakter olarak yazdir
                veri = fis.read(); // Sonraki veriyi oku
            }

            // Dosyayi kapat
            fis.close();
            System.out.println("\nDosya basariyla okundu.");

        } catch (FileNotFoundException e) {
            // Eger dosya bulunamazsa bu hata yakalanir
            System.out.println("Dosya bulunamadi: " + e.getMessage());
            System.out.println("Lutfen dosyanin adini veya yolunu kontrol edin.");
        } catch (IOException e) {
            // Dosya okunurken genel bir hata meydana gelirse yakalanir
            System.out.println("Dosya okunurken bir hata olustu: " + e.getMessage());
        } finally {
            // Kaynaklarin serbest birakilmasi veya islemlerin tamamlanmasi icin kullanilir
            System.out.println("Islem tamamlandi.");
        }

        // Dosyaya veri yazma islemi icin ayri bir metot cagir
        dosyayaYaz("test.txt", "Bu dosyaya yazilan yeni bir satirdir.");
    }

    /**
     * Dosyaya yazmak icin bir metot
     * @param dosyaAdi Yazilacak dosyanin adi
     * @param veri Dosyaya yazilacak veri
     */
    public static void dosyayaYaz(String dosyaAdi, String veri) {
        try {
            // Dosyayi yazma modunda ac
            FileWriter fw = new FileWriter(dosyaAdi, true); // true append modunda acar
            fw.write("\n" + veri); // Veriyi yaz ve yeni satir ekle
            fw.close(); // Dosyayi kapat
            System.out.println("Dosyaya veri basariyla yazildi.");
        } catch (IOException e) {
            // Yazma islemi sirasinda hata meydana gelirse yakalanir
            System.out.println("Dosyaya yazilirken bir hata olustu: " + e.getMessage());
        }
    }
}
