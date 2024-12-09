import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HesapMakinesiScanner {

    public static void main(String[] args) {
        
        // Dosya yolu
        File dosya = new File("islemler.txt");
        
        try {
            // Dosyayi okuyacak Scanner nesnesi
            Scanner scanner = new Scanner(dosya);
            
            System.out.println("Hesap Makinesi - Dosyadan Okuma");
            
            // Dosyadaki her satirda islemi gerceklestirmek icin dongu
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                
                // Satiri bosluklarla ayir
                String[] parcalar = satir.split(" ");
                
                // Kullanici girisi hataliysa tekrar giris iste
                if (parcalar.length != 3) {
                    System.out.println("Gecersiz islem! Lutfen dogru formatta islem girin (ornek: 10 + 5).");
                    continue;
                }
                
                try {
                    int sayi1 = Integer.parseInt(parcalar[0]); // Birinci sayi
                    int sayi2 = Integer.parseInt(parcalar[2]); // ikinci sayi
                    char islec = parcalar[1].charAt(0); // islec
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
                            System.out.println("Gecersiz islec! Lutfen +, -, * veya / kullanin.");
                            continue;
                    }
                    // Hesaplanan sonucu ekrana yazdir
                    System.out.println(sayi1 + " " + islec + " " + sayi2 + " = " + sonuc);
                } catch (NumberFormatException e) {
                    // Sayilarin parse edilmesinde hata durumunda mesaj yazdir
                    System.out.println("Sayilari parse ederken bir hata olustu: " + e.getMessage());
                }
            }
            
            // Scanner'i kapat
            scanner.close();
        } catch (FileNotFoundException e) {
            // Dosya bulunamazsa hata mesaji verilir
            System.out.println("Dosya bulunamadi: " + e.getMessage());
        }
    }
}
