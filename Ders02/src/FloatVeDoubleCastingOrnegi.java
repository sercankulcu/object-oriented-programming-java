
public class FloatVeDoubleCastingOrnegi {
	
	public static void main(String[] args) {
		
		// float ve double veri türlerini kullanarak değişkenler tanımlayalım
		float floatSayi = 123.45f; // float veri türü "f" veya "F" ile belirtilir
		double doubleSayi = 678.90;

		// Değerleri yazdıralım
		System.out.println("Float Sayı: " + floatSayi);
		System.out.println("Double Sayı: " + doubleSayi);

		// float ve double veri türlerini birbirine dönüştürebiliriz (casting)
		float floattenDouble = (float) doubleSayi; // double'dan float'a dönüşüm (casting)
		double doubletenFloat = floatSayi; // float'tan double'a otomatik dönüşüm

		System.out.println("Float'ten Double'a Dönüşüm: " + floattenDouble);
		System.out.println("Double'dan Float'a Dönüşüm: " + doubletenFloat);
	}
}
