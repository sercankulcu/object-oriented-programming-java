
public class AtamaIslemleriOrnegi {
	
	public static void main(String[] args) {
		// Atama işlemleri
		int x = 5; // x değişkenine 5 atandı
		int y = 10; // y değişkenine 10 atandı

		// Toplama ve atama
		x = x + y; // x, x ve y'nin toplamına eşittir
		System.out.println("Toplama ve Atama: x = " + x); // x şimdi 15

		// Çıkarma ve atama
		x -= y; // x, x ve y'nin farkına eşittir
		System.out.println("Çıkarma ve Atama: x = " + x); // x şimdi 5

		// Çarpma ve atama
		x *= 2; // x, x'nin 2 ile çarpımına eşittir
		System.out.println("Çarpma ve Atama: x = " + x); // x şimdi 10

		// Bölme ve atama
		x /= 4; // x, x'nin 4'e bölümüne eşittir
		System.out.println("Bölme ve Atama: x = " + x); // x şimdi 2

		// Modül (Kalan) ve atama
		x %= 3; // x, x'nin 3'e bölümünden kalanına eşittir
		System.out.println("Modül ve Atama: x = " + x); // x şimdi 2 % 3 = 2

	}
}
