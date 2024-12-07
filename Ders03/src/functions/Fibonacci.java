package functions; 
import java.util.Scanner;  // Kullanicidan giris almak icin Scanner sinifini ice aktar

public class Fibonacci {

    // 'fibonacci' metodu, kullanicinin girdigi sayiya kadar Fibonacci serisini ekrana yazdirir
    void fibonacci(int sayi) {

        int sonuc = 0;  // Her adimda iki onceki sayilarin toplami olan Fibonacci sayisini tutar
        int sayi1 = 1;  // Fibonacci serisindeki ilk sayi
        int sayi2 = 1;  // Fibonacci serisindeki ikinci sayi
        
        // Ilk iki Fibonacci sayisi olan '1 1' her zaman sabit oldugundan ekrana yazdirilir
        System.out.print("1 1 ");
        
        // Dongu, 2'den baslayarak kullanicinin girdigi sayiya kadar Fibonacci sayilari hesaplar
        for(int i = 2; i < sayi; i++) {
            // Her adimda onceki iki sayinin toplami yeni sonuc olur
            sonuc = sayi1 + sayi2;
            // Ikinci sayi, birinci sayinin yerine gecer
            sayi1 = sayi2;
            // Hesaplanan sonuc ise ikinci sayinin yerine gecer
            sayi2 = sonuc;
            // Hesaplanan Fibonacci sayisini ekrana yazdirir
            System.out.print(sonuc + " ");
        }
        
        // Bir sonraki satira gecis icin bos bir println cagrisi yapilir
        System.out.println();
        
        // Altin oran, son iki Fibonacci sayisinin birbirine bolunmesiyle hesaplanir
        System.out.println("Altin oran = " + (double)((double)sayi2 / sayi1));
    }

    public static void main(String[] args) {

        // Kullanicidan giris almak icin Scanner nesnesi olustur
        Scanner okuyucu = new Scanner(System.in);
        
        // Kullanicidan bir sayi girmesini iste
        System.out.println("Lutfen bir sayi giriniz");
        int sayi = okuyucu.nextInt();  // Kullanicinin girdigi sayi alinir
        
        // Fibonacci sinifindan bir nesne olustur
        Fibonacci bulucu = new Fibonacci();
        
        // 'fibonacci' metodunu cagirararak Fibonacci serisini ve altin orani hesapla
        bulucu.fibonacci(sayi);
        
        // Scanner nesnesini kapat
        okuyucu.close();
    }
}
