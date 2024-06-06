package datatypes;

public class ShortVeriTuruOrnegi {

	public static void main(String[] args) {

		// short veri türünü kullanarak bir değişken tanımlayalım
		short minDeger = Short.MIN_VALUE; // Short türünün en küçük değeri
		short maxDeger = Short.MAX_VALUE; // Short türünün en büyük değeri

		// Değerleri yazdıralım
		System.out.println("Short veri türünün en küçük değeri: " + minDeger);
		System.out.println("Short veri türünün en büyük değeri: " + maxDeger);

		// Bir short değişkeni kullanarak aritmetik işlemler yapabiliriz
		short sayi1 = 300;
		short sayi2 = 500;
		short toplam = (short) (sayi1 + sayi2); // Toplam sonucunu bir short'a dönüştürmemiz gerekebilir
		System.out.println("Toplam: " + toplam);
	}
	
}
