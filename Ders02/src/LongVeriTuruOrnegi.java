
public class LongVeriTuruOrnegi {

	public static void main(String[] args) {

		// long, short ve int veri türlerini kullanarak değişkenler tanımlayalım
		long uzunSayi = 2147483648L; // long veri türü "L" ile belirtilir
		short kisaSayi = 32000;
		int tamSayi = 2147483647;

		// Değerleri yazdıralım
		System.out.println("Uzun Sayı: " + uzunSayi);
		System.out.println("Kısa Sayı: " + kisaSayi);
		System.out.println("Tam Sayı: " + tamSayi);

		// short ve int veri türlerini toplayabiliriz
		// Sonuç otomatik olarak int türüne dönüşecektir
		int toplam = kisaSayi + tamSayi;
		System.out.println("Toplam: " + toplam);

		// long türünden int türüne ve int türünden short türüne açık dönüşüm yapabiliriz (casting)
		long uzunSayi2 = 50000;
		int tamSayi2 = (int) uzunSayi2; // long'dan int'e dönüşüm (casting)
		short kisaSayi2 = (short) tamSayi2; // int'ten short'a dönüşüm (casting)

		System.out.println("Uzun Sayı 2: " + uzunSayi2);
		System.out.println("Tam Sayı 2: " + tamSayi2);
		System.out.println("Kısa Sayı 2: " + kisaSayi2);
	}
}
