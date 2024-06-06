package datatypes;

public class CharVeBooleanCastingOrnegi {
	
	public static void main(String[] args) {
		
		// char ve boolean veri türlerini kullanarak değişkenler tanımlayalım
		char karakter = 'A';
		boolean dogruMu = true;

		// Değerleri yazdıralım
		System.out.println("Karakter: " + karakter);
		System.out.println("Boolean Değeri: " + dogruMu);

		// char verisini int'e dönüştürebiliriz (casting)
		int karakterInt = karakter; // char'dan int'e dönüşüm (casting)
		System.out.println("Karakterin ASCII Değeri: " + karakterInt);

		// boolean verisini kullanarak koşullu ifade oluşturalım
		if (dogruMu) {
			System.out.println("Bu ifade doğru.");
		} else {
			System.out.println("Bu ifade yanlış.");
		}

		// int verisini char'a dönüştürebiliriz (casting)
		int intDeger = 65;
		char charDeger = (char) intDeger; // int'ten char'a dönüşüm (casting)
		System.out.println("ASCII Değerinden Karakter: " + charDeger);
	}
}
