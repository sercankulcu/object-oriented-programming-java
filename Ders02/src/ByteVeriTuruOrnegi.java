
public class ByteVeriTuruOrnegi {
	
	public static void main(String[] args) {
		
		// byte veri türünü kullanarak bir değişken tanımlayalım
		byte minDeger = Byte.MIN_VALUE; // Byte türünün en küçük değeri
		byte maxDeger = Byte.MAX_VALUE; // Byte türünün en büyük değeri

		// Değerleri yazdıralım
		System.out.println("Byte veri türünün en küçük değeri: " + minDeger);
		System.out.println("Byte veri türünün en büyük değeri: " + maxDeger);

		// Bir byte değişkeni kullanarak aritmetik işlemler yapabiliriz
		byte sayi1 = 30;
		byte sayi2 = 50;
		byte toplam = (byte) (sayi1 + sayi2); // Toplam sonucunu bir byte'a dönüştürmemiz gerekebilir
		System.out.println("Toplam: " + toplam);
	}
}
