package eamples;
import java.util.Random; // Rastgele sayılar üretmek için Random sınıfını içe aktarır.
import java.util.Scanner; // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarır.

public class Rastgele { // Ana sınıf

	public static void main(String[] args) { // Programın çalışmaya başladığı ana fonksiyon
		
		// Random sınıfından bir nesne oluşturur, bu nesne ile rastgele sayılar üretilecek.
		Random rastgele = new Random();
		
		// 1 ile 100 arasında rastgele bir sayı üretir. 'nextInt(100)' ifadesi 0-99 arasında bir sayı üretir,
		// bu yüzden sonuca 1 eklenir ve 1-100 aralığında bir sayı elde edilir.
		int sayi = rastgele.nextInt(100) + 1; 
		
		// Kullanıcıdan giriş almak için Scanner nesnesi oluşturur.
		Scanner scanner = new Scanner(System.in);
		
		// Kullanıcının doğru tahmini yapana kadar dönecek sonsuz bir döngü başlatılır.
		while(true) {
			
			// Kullanıcının girdiği sayıyı okur ve 'girilen' değişkenine atar.
			int girilen = scanner.nextInt();
			
			// Rastgele üretilen sayı ve kullanıcının girdiği sayıyı ekrana yazdırır.
			System.out.println("Rastgele = " + sayi + " Girilen = " + girilen);
			
			// Eğer kullanıcının girdiği sayı, rastgele üretilen sayıya eşitse, döngüden çıkar.
			if(sayi == girilen) {
				// Tahmin doğru, döngü sonlanır.
				break;
			} 
			// Eğer girilen sayı, rastgele sayıdan küçükse, kullanıcıya daha büyük bir sayı girmesi gerektiğini söyler.
			else if(girilen < sayi) {
				System.out.println("Daha büyük bir sayı giriniz (yukarı).");
			} 
			// Eğer girilen sayı, rastgele sayıdan büyükse, kullanıcıya daha küçük bir sayı girmesi gerektiğini söyler.
			else {
				System.out.println("Daha küçük bir sayı giriniz (aşağı).");
			}
		}
		// Program burada sonlanır, scanner nesnesini kapatmayı unutmamak gerekir.
		scanner.close(); // Scanner nesnesini kapatır, bu kaynak yönetimi için önemlidir.
	}
}
