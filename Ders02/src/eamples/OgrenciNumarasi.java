package eamples;
import java.util.Scanner; // Kullanıcıdan veri girişi almak için Scanner sınıfını içe aktarır.

public class OgrenciNumarasi { // Ana sınıf

	public static void main(String[] args) {
		
		// Kullanıcıdan öğrenci numarasını almak için Scanner nesnesi oluşturur.
		Scanner scanner = new Scanner(System.in);
		
		// Kullanıcıdan bir öğrenci numarası girmesini ister.
		System.out.println("Öğrenci numarasını giriniz:");
		int numara = scanner.nextInt(); // Girilen öğrenci numarasını okur ve 'numara' değişkenine atar.
		
		// Öğrenci numarasının ilk iki hanesi kayıt yılını belirler. Bu iki hane 10000000'e bölünerek elde edilir.
		// 2000 yılına eklenerek öğrenci numarasındaki yıl bilgisi çözülür.
		int kayityili = (numara / 10000000) + 2000;
		
		// Öğrencinin kayıt yılı ekrana yazdırılır.
		System.out.println("Kayıt yılı: " + kayityili);
		
		// Öğrenci numarasının son üç hanesi, öğrencinin kayıt sırasını gösterir.
		// Mod 1000 işlemi ile bu üç hane alınır.
		int kayitsirasi = numara % 1000;
		
		// Kayıt sırası ekrana yazdırılır.
		System.out.println("Kayıt sırası: " + kayitsirasi);
		
		// Öğrenci numarasının 5. hanesi öğrencinin bölümünü gösterir.
		// 100000'e bölünerek ilgili hane alınır ve mod 10 işlemi ile bu hane elde edilir.
		int bolumu = (numara / 100000) % 10;
		
		// Bölüm numarasına göre öğrencinin hangi bölümde olduğunu belirler ve ekrana yazar.
		if(bolumu == 7) {
			// Eğer bölüm numarası 7 ise Elektrik Elektronik bölümü yazdırılır.
			System.out.println("Bölüm: Elektrik Elektronik");
		} else if (bolumu == 6) {
			// Eğer bölüm numarası 6 ise Bilgisayar Mühendisliği bölümü yazdırılır.
			System.out.println("Bölüm: Bilgisayar");
		} else if (bolumu == 5) {
			// Eğer bölüm numarası 5 ise Makina Mühendisliği bölümü yazdırılır.
			System.out.println("Bölüm: Makina");
		} else {
			// Eğer bölüm numarası 5, 6 veya 7 değilse, bölüm tanımlanmaz.
			System.out.println("Bilinmeyen bölüm");
		}
		
		// Scanner nesnesini kapatır. Kaynak yönetimi açısından önemli bir adımdır.
		scanner.close(); 
	}
}
