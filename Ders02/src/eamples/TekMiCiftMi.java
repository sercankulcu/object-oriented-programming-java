package eamples;
import java.util.Scanner; // Kullanıcıdan veri girişi almak için Java'nın Scanner sınıfını içe aktarır.

public class TekMiCiftMi { // Programın ana sınıfı.
	
	public static void main(String[] args) { // Programın çalışmaya başladığı ana fonksiyon.
		
		// Kullanıcıdan sayı almak için Scanner objesi oluşturur.
		Scanner scanner = new Scanner(System.in); 
		
		// Kullanıcıdan bir sayı girmesini ister.
		System.out.println("Bir sayı giriniz:");
		
		// Kullanıcının girdiği sayıyı okur ve 'sayi' değişkenine atar.
		int sayi = scanner.nextInt(); 
		
		// Girilen sayının tek mi çift mi olduğunu kontrol eden koşul yapısı.
		// Modulus (%) operatörü ile sayının 2'ye bölümünden kalan kontrol edilir.
		// Eğer kalan 1 ise sayı tektir.
		if(sayi % 2 == 1) {
			// Eğer sayı tektir, bu mesaj ekrana yazdırılır.
			System.out.println("Girilen sayı tektir.");
		}
		// Eğer sayı teklik şartını sağlamazsa, sayı çifttir.
		else {
			// Eğer sayı çifttir, bu mesaj ekrana yazdırılır.
			System.out.println("Girilen sayı çifttir.");
		}
		
		// Scanner objesini kapatır, bu işlem kaynakları serbest bırakır.
		scanner.close(); 
	}

}
