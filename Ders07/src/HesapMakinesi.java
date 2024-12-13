import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;

/*
 * Bu kod, "islemler.txt" dosyasindan satir satir okur, satiri bosluklarla ayirarak
 * her bir degeri alir ve islece gore islemi gerceklestirir. Sonuc, ekrana yazdirilir.
 */

public class HesapMakinesi {

    public static void main(String[] args) {

        try {
            // islemler.txt dosyasini okuma icin BufferedReader kullan
            BufferedReader okuyucu = new BufferedReader(new FileReader("islemler.txt"));
            String satir;
            while ((satir = okuyucu.readLine()) != null) {
                // Satiri bosluklarla ayir ve her bir parcayi ilgili degiskene at
                String[] parcalar = satir.split(" ");
                int sayi1 = Integer.parseInt(parcalar[0]);
                int sayi2 = Integer.parseInt(parcalar[2]);
                char islec = parcalar[1].charAt(0);
                int sonuc = 0;

                // islec'e gore islemi yap
                switch (islec) {
                case '+':
                    sonuc = sayi1 + sayi2; // Toplama islemi
                    break;
                case '-':
                    sonuc = sayi1 - sayi2; // Cikarma islemi
                    break;
                case '*':
                    sonuc = sayi1 * sayi2; // Carpma islemi
                    break;
                case '/':
                    // Bolme islemi
                    if (sayi2 != 0) {
                        sonuc = sayi1 / sayi2;
                    } else {
                        // Sifira bolme hatasi
                        System.out.println("Hata: Sifira bolme yapilamaz!");
                        continue; // Bu durumda sonraki islemi yap
                    }
                    break;
                default:
                    // Gecersiz islec durumunda sonuc 0 olarak atanir
                    sonuc = 0;
                    break;
                }
                // Hesaplanan sonucu ekrana yazdir
                System.out.println(sayi1 + " " + islec + " " + sayi2 + " = " + sonuc);
            }
            // Dosya okuma islemi bitince dosyayi kapat
            okuyucu.close();
        } catch (IOException e) {
            // Dosya okuma hatasi durumunda mesaj yazdir
            System.out.println("Dosya okunurken bir hata olustu: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Sayilarin parse edilmesinde hata durumunda mesaj yazdir
            System.out.println("Sayilari parse ederken bir hata olustu: " + e.getMessage());
        }
    }
}
