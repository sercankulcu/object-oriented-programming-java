package functions; 
import java.util.Scanner;  // Kullaniciya giris almak icin Scanner sinifini ice aktar

public class BasamakSayisi {

    // 'basamakSayisiBul' metodu verilen sayinin kac basamaktan olustugunu bulur
    int basamakSayisiBul(int sayi) {
        int basamakSayisi = 0;  // Basamak sayisini tutacak degisken
        // Sayi 0'dan buyuk oldugu surece dongu devam eder
        while(sayi > 0) {
            // Sayi her dongude 10'a bolunerek bir basamak eksiltilir
            sayi = sayi / 10;
            // Her bolme isleminde bir basamak oldugu icin sayaci arttir
            basamakSayisi++;
        }
        // Basamak sayisini dondur
        return basamakSayisi;
    }

    public static void main(String[] args) {
        
        // Kullaniciya giris almak icin Scanner nesnesi olustur
        Scanner okuyucu = new Scanner(System.in);
        // Kullanicinin girdigi sayiyi al
        int sayi = okuyucu.nextInt();
        
        // BasamakSayisi sinifindan bir nesne olustur
        BasamakSayisi bulucu = new BasamakSayisi();
        
        // 'basamakSayisiBul' metodunu cagirararak sayinin basamak sayisini hesapla
        int sonuc = bulucu.basamakSayisiBul(sayi);
        
        // Sonucu ekrana yazdir
        System.out.println(sonuc);
        
        // Scanner nesnesini kapat
        okuyucu.close();
    }
}
