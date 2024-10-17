package functions;
import java.util.Scanner;  // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarıyoruz

public class Fibonacci {

    // 'fibonacci' metodu, kullanıcının girdiği sayıya kadar Fibonacci serisini ekrana yazdırır
    void fibonacci(int sayi) {

        int sonuc = 0;  // Her adımda iki önceki sayıların toplamı olan Fibonacci sayısını tutar
        int sayi1 = 1;  // Fibonacci serisindeki ilk sayı
        int sayi2 = 1;  // Fibonacci serisindeki ikinci sayı
        
        // İlk iki Fibonacci sayısı olan '1 1' her zaman sabit olduğundan ekrana yazdırılır
        System.out.print("1 1 ");
        
        // Döngü, 2'den başlayarak kullanıcının girdiği sayıya kadar Fibonacci sayıları hesaplar
        for(int i = 2; i < sayi; i++) {
            // Her adımda önceki iki sayının toplamı yeni sonuç olur
            sonuc = sayi1 + sayi2;
            // İkinci sayı, birinci sayının yerine geçer
            sayi1 = sayi2;
            // Hesaplanan sonuç ise ikinci sayının yerine geçer
            sayi2 = sonuc;
            // Hesaplanan Fibonacci sayısını ekrana yazdırır
            System.out.print(sonuc + " ");
        }
        
        // Bir sonraki satıra geçiş için boş bir println çağrısı yapılır
        System.out.println();
        
        // Altın oran, son iki Fibonacci sayısının birbirine bölünmesiyle hesaplanır
        System.out.println("Altın oran = " + (double)((double)sayi2 / sayi1));
    }

    public static void main(String[] args) {

        // Kullanıcıdan giriş almak için Scanner nesnesi oluşturuyoruz
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanıcıdan bir sayı girmesini isteriz
        System.out.println("Lütfen bir sayı giriniz");
        int sayi = okuyucu.nextInt();  // Kullanıcının girdiği sayı alınır
        
        // Fibonacci sınıfından bir nesne oluşturuyoruz
        Fibonacci bulucu = new Fibonacci();
        
        // 'fibonacci' metodunu çağırarak Fibonacci serisini ve altın oranı hesaplıyoruz
        bulucu.fibonacci(sayi);
        
        // Scanner nesnesini kapatıyoruz
        okuyucu.close();
    }
}
