package functions; 
import java.util.Scanner;  // Kullanicidan giris almak icin Scanner sinifini ice aktar

public class RakamlarToplami {

    // 'rakamlarToplaminiBul' metodu, verilen sayinin rakamlarinin toplamini hesaplar
    int rakamlarToplaminiBul(int sayi) {
        int rakamlarToplami = 0;  // Rakamlarin toplamini tutacak degisken
        
        // Sayi 0'dan buyuk oldugu surece dongu devam eder
        while(sayi > 0) {
            // Sayinin son rakamini almak icin 10'a gore mod islemi yapilir
            int rakam = sayi % 10;
            // Rakamlar toplamina bu rakami ekle
            rakamlarToplami += rakam;
            // Sayiyi her seferinde 10'a bolerek bir basamagini eksilt
            sayi = sayi / 10;
        }
        
        // Tum rakamlar toplandiktan sonra sonucu dondurur
        return rakamlarToplami;
    }

    public static void main(String[] args) {
        
        // Kullanicidan giris almak icin Scanner nesnesi olustur
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanicinin bir sayi girmesini iste
        System.out.println("Lutfen bir sayi giriniz:");
        int sayi = okuyucu.nextInt();  // Kullanicinin girdigi sayi alinir
        
        // RakamlarToplami sinifindan bir nesne olustur
        RakamlarToplami bulucu = new RakamlarToplami();
        
        // 'rakamlarToplaminiBul' metodunu cagirarak girilen sayinin rakamlarinin toplamini hesapla
        int sonuc = bulucu.rakamlarToplaminiBul(sayi);
        
        // Hesaplanan rakamlar toplamini ekrana yazdir
        System.out.println("Rakamlar Toplami = " + sonuc);
        
        // Scanner nesnesini kapat
        okuyucu.close();
    }
}
