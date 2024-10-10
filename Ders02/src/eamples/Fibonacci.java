package eamples;
import java.util.Scanner; // Kullanıcıdan veri girişi almak için Scanner sınıfını içe aktarır.

public class Fibonacci { // Ana sınıf

	public static void main(String[] args) {
		
		// Kullanıcıdan bir sayı girişi almak için Scanner nesnesi oluşturur.
		Scanner scanner = new Scanner(System.in);
		
		// Kullanıcıdan bir sayı girmesini ister, bu sayı Fibonacci dizisinin kaç elemanını hesaplayacağını belirtir.
		System.out.println("Bir sayı giriniz:");
		int sayi = scanner.nextInt(); // Kullanıcının girdiği sayıyı okur ve 'sayi' değişkenine atar.
		
		// Fibonacci dizisinin ilk iki elemanını başlatır. Fibonacci dizisi 1, 1, 2, 3, 5... şeklinde ilerler.
		int sayi1 = 1; // İlk Fibonacci sayısı
		int sayi2 = 1; // İkinci Fibonacci sayısı
		
		// İlk iki Fibonacci sayısını ekrana yazdırır.
		System.out.print(sayi1 + " ");
		System.out.print(sayi2 + " ");
		
		// Sonraki Fibonacci sayısını hesaplamak için 'sonuc' değişkeni oluşturulur.
		int sonuc = 0;
		
		// Döngü, Fibonacci dizisinin ilk iki elemanı zaten yazdırıldığından, 2. indisten başlar ve
		// kullanıcının belirttiği 'sayi' değeri kadar devam eder.
		for(int i = 2; i < sayi; i++) {
			
			// 'sonuc', bir önceki iki Fibonacci sayısının toplamı olarak hesaplanır.
			sonuc = sayi1 + sayi2;
			
			// 'sayi1' bir sonraki adım için 'sayi2' olur.
			sayi1 = sayi2;
			
			// 'sayi2' ise yeni hesaplanan Fibonacci sayısı olan 'sonuc' olur.
			sayi2 = sonuc;
			
			// Hesaplanan Fibonacci sayısını ekrana yazdırır.
			System.out.print(sonuc + " ");
			
			// Altın oran, ardışık iki Fibonacci sayısı arasındaki oran olarak hesaplanır ve ekrana yazdırılır.
			// Oran hesaplaması sayi2/sayi1 şeklindedir ve sonuç double olarak yazdırılır.
			System.out.println("Altın oran = " + (double)((double)sayi2 / sayi1));
		}
		
		// Scanner nesnesini kapatır. Kaynak yönetimi açısından önemli bir adımdır.
		scanner.close();
	}
}
