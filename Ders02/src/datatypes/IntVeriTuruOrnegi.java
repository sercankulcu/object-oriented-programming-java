package datatypes;

public class IntVeriTuruOrnegi {

	public static void main(String[] args) {

		// short ve int veri türlerini kullanarak değişkenler tanımlayalım
		short kisaSayi = 32000;
		int tamSayi = 2147483647;

		// Değerleri yazdıralım
		System.out.println("Kısa Sayı: " + kisaSayi);
		System.out.println("Tam Sayı: " + tamSayi);

		// Bir short ve bir int değişkenini toplama işlemi yapabiliriz
		// Sonuç otomatik olarak int türüne dönüşecektir
		int toplam = kisaSayi + tamSayi;
		System.out.println("Toplam: " + toplam);

		// short türünden int türüne açık bir dönüşüm yapabiliriz (casting)
		short kisaSayi2 = 30000;
		int toplam2 = kisaSayi2 + kisaSayi2; // Dönüşüm (casting)
		System.out.println("Toplam 2: " + toplam2);
	}
}
