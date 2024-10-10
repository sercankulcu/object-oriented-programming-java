package eamples;
import java.util.Scanner; // Kullanıcıdan veri girişi almak için Scanner sınıfını içe aktarır.

public class Faktoriyel { // Ana sınıf

	public static void main(String[] args) {
		
		// Kullanıcıdan bir sayı almak için Scanner nesnesi oluşturur.
		Scanner scanner = new Scanner(System.in);
		
		// Kullanıcıdan faktöriyelini hesaplamak için bir sayı girmesini ister.
		System.out.println("Bir sayı giriniz:");
		int sayi = scanner.nextInt(); // Girilen sayıyı okur ve 'sayi' değişkenine atar.
		
		// Faktöriyel hesaplaması için başlangıç değeri 1 olan 'faktoriyel' değişkeni tanımlanır.
		int faktoriyel = 1;
		
		// Kullanıcının girdiği sayıyı ekrana yazdırır.
		// Örneğin, "5" girdiyse, ekrana "5" yazdırır.
		System.out.print(sayi);
		
		// Faktöriyel hesaplamak için 'while' döngüsü başlatılır.
		// Döngü, sayı 0'dan büyük olduğu sürece devam eder.
		// Faktöriyel, 1'den başlayarak sayıya kadar olan tüm sayıların çarpımına eşittir.
		while(sayi > 0) {
			
			// 'faktoriyel' değeri, her adımda o anki 'sayi' değeri ile çarpılır.
			faktoriyel *= sayi;
			
			// Sayıyı 1 azaltarak bir sonraki sayıya geçer.
			sayi--;
		}
		
		// Faktöriyel hesaplandıktan sonra sonucu ekrana yazdırır.
		// Örneğin, "5! = 120" şeklinde çıktı verecektir.
		System.out.println("! = " + faktoriyel);
		
		// Scanner nesnesini kapatır. Kaynak yönetimi açısından önemli bir adımdır.
		scanner.close();
	}
}
