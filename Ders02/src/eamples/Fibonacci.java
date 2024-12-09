package eamples;
import java.util.Scanner; // Kullanicidan veri girisi almak icin Scanner sinifini ice aktarir.

public class Fibonacci { // Ana sinif

    public static void main(String[] args) {
        
        // Kullanicidan bir sayi girisi almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in);
        
        // Kullanicidan bir sayi girmesini ister, bu sayi Fibonacci dizisinin kacinci elemanini hesaplayacagini belirtir.
        System.out.println("Bir sayi giriniz:");
        int sayi = scanner.nextInt(); // Kullanicinin girdigi sayiyi okur ve 'sayi' degiskenine atar.
        
        // Fibonacci dizisinin ilk iki elemanini baslatir. Fibonacci dizisi 1, 1, 2, 3, 5... sekilinde ilerler.
        int sayi1 = 1; // Ilk Fibonacci sayisi
        int sayi2 = 1; // Ikinci Fibonacci sayisi
        
        // Ilk iki Fibonacci sayisini ekrana yazdirir.
        System.out.print(sayi1 + " ");
        System.out.print(sayi2 + " ");
        
        // Sonraki Fibonacci sayisini hesaplamak icin 'sonuc' degiskeni olusturulur.
        int sonuc = 0;
        
        // Dongu, Fibonacci dizisinin ilk iki elemani zaten yazdirildigindan, 2. indisten baslar ve
        // kullanicinin belirttigi 'sayi' degerine kadar devam eder.
        for(int i = 2; i < sayi; i++) {
            
            // 'sonuc', bir onceki iki Fibonacci sayisinin toplami olarak hesaplanir.
            sonuc = sayi1 + sayi2;
            
            // 'sayi1' bir sonraki adim icin 'sayi2' olur.
            sayi1 = sayi2;
            
            // 'sayi2' ise yeni hesaplanan Fibonacci sayisi olan 'sonuc' olur.
            sayi2 = sonuc;
            
            // Hesaplanan Fibonacci sayisini ekrana yazdirir.
            System.out.print(sonuc + " ");
            
            // Altin oran, ardisik iki Fibonacci sayisi arasindaki oran olarak hesaplanir ve ekrana yazdirilir.
            // Oran hesaplamasi sayi2/sayi1 seklindedir ve sonuclar double olarak yazdirilir.
            System.out.println("\tAltin oran = " + (double)((double)sayi2 / sayi1));
        }
        
        // Scanner nesnesini kapatir. Kaynak yonetimi acisindan onemli bir adimdir.
        scanner.close();
    }
}
