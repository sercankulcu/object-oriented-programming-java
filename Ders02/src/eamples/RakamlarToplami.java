package eamples;
import java.util.Scanner; // Kullanıcıdan veri girişi almak için Scanner sınıfını içe aktarır.

public class RakamlarToplami { // Ana sınıf

	public static void main(String[] args) {
		
		// Kullanıcıdan giriş almak için Scanner nesnesi oluşturur.
		Scanner scanner = new Scanner(System.in);
		
		// Kullanıcıdan bir sayı girmesini ister.
		System.out.println("Bir sayı giriniz:");
		
		// Kullanıcının girdiği sayıyı okur ve 'sayi' değişkenine atar.
		int sayi = scanner.nextInt();
		
		// Rakamların toplamını tutmak için 'rakamlarToplami' adında bir değişken oluşturur, başlangıç değeri 0'dır.
		int rakamlarToplami = 0;
		
		// Sayının basamaklarını tek tek almak için bir döngü başlatır.
		// Döngü, 'sayi' 0'dan büyük olduğu sürece devam eder.
		while(sayi > 0) {
			
			// Sayının son basamağını almak için 10'a göre mod (kalan) işlemi yapılır.
			int rakam = sayi % 10;
			
			// Alınan basamak değeri 'rakamlarToplami' değişkenine eklenir.
			rakamlarToplami += rakam;
			
			// Sayının son basamağını silmek için sayıyı 10'a böleriz.
			// Bu işlemle sayının bir basamağı eksilir.
			sayi = sayi / 10;
		}
		
		// Sonuç olarak rakamların toplamını ekrana yazdırır.
		System.out.println("Rakamlar toplamı: " + rakamlarToplami);
		
		// Scanner nesnesini kapatır. Kaynak yönetimi açısından önemli bir adımdır.
		scanner.close(); 
	}
}
