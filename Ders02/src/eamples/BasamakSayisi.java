package eamples;
import java.util.Scanner; // Kullanıcıdan veri girişi almak için Scanner sınıfını içe aktarır.

public class BasamakSayisi { // Ana sınıf

	public static void main(String[] args) {

		// Kullanıcıdan bir sayı almak için Scanner nesnesi oluşturur.
		Scanner scanner = new Scanner(System.in);

		// Kullanıcıdan bir sayı girmesini ister. Bu sayı basamaklarının sayısını hesaplayacağız.
		System.out.println("Bir sayı giriniz:");
		int sayi = scanner.nextInt(); // Kullanıcının girdiği sayıyı okur ve 'sayi' değişkenine atar.

		// Basamak sayısını tutmak için bir değişken tanımlar ve başlangıç değerini 0 olarak belirler.
		int basamakSayisi = 0;

		// 'while' döngüsü, sayının basamaklarını saymak için kullanılır.
		// Döngü, sayı 0'dan büyük olduğu sürece devam eder.
		while(sayi > 0) {

			// Sayının son basamağını "sayı / 10" işlemiyle sileriz (örneğin 1234 -> 123).
			sayi = sayi / 10;

			// Her işlemde bir basamak silindiği için 'basamakSayisi' bir artırılır.
			basamakSayisi++;
		}

		// Sayının kaç basamaktan oluştuğunu ekrana yazdırır.
		System.out.println("Basamak sayısı: " + basamakSayisi);

		// Scanner nesnesini kapatır. Kaynak yönetimi açısından önemli bir adımdır.
		scanner.close();
	}
}
