package eamples;
import java.util.Scanner; // Kullanıcıdan veri girişi almak için Scanner sınıfını içe aktarır.

public class AsalMi { // Ana sınıf

	public static void main(String[] args) {
		
		// Kullanıcıdan bir sayı almak için Scanner nesnesi oluşturur.
		Scanner scanner = new Scanner(System.in);
		
		// Kullanıcıdan bir sayı girmesini ister. Bu sayı, asal olup olmadığını kontrol edeceğimiz sayıdır.
		System.out.println("Bir sayı giriniz:");
		int sayi = scanner.nextInt(); // Kullanıcının girdiği sayıyı okur ve 'sayi' değişkenine atar.
		
		// Asal olup olmadığını kontrol etmek için 'asal' adında bir boolean değişkeni tanımlarız.
		// Başlangıçta sayının asal olduğunu varsayıyoruz.
		boolean asal = true;
		
		// 'for' döngüsü, sayının asal olup olmadığını kontrol etmek için kullanılır.
		// Döngü 2'den başlayarak (çünkü asal sayı 1 ve kendisi dışında tam böleni olmayan sayıdır)
		// girilen sayıya kadar devam eder.
		for(int i = 2; i < sayi; i++) {
			
			// Eğer sayı, 2 ile 'sayi' arasındaki herhangi bir sayıya tam bölünürse, asal değildir.
			// Tam bölünebilme kontrolü için sayi % i == 0 ifadesi kullanılır.
			if(sayi % i == 0) {
				
				// Eğer sayının bir böleni bulunursa, ekrana "sayı asal değil" yazdırılır.
				System.out.println("Sayı asal değil.");
				
				// Sayının asal olmadığını belirtmek için 'asal' değişkenini false yaparız.
				asal = false;
				
				// İlk böleni bulduktan sonra kontrol etmeye gerek olmadığı için döngüden çıkarız (break).
				break;
			}
		}
		
		// Eğer döngü tamamlandıysa ve hiçbir bölen bulunmadıysa (asal değişkeni hâlâ true ise),
		// sayının asal olduğu kabul edilir ve ekrana "sayı asal" yazdırılır.
		if(asal == true) {
			System.out.println("Sayı asal.");
		}
		
		// Scanner nesnesini kapatır. Kaynak yönetimi açısından önemli bir adımdır.
		scanner.close();
	}
}
