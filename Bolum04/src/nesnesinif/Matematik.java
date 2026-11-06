package nesnesinif;

// static metotlar: nesne olusturmadan sinif adiyla cagrilir
// (Matematik.toplama, Math.max, Math.sqrt).
public class Matematik {
	// Statik toplama metodu
	public static int toplama(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}

	public static void main(String[] args) {
		int sonuc = Matematik.toplama(5, 3);
		System.out.println("Toplama Sonucu: " + sonuc);   // Toplama Sonucu: 8
		System.out.println(Math.max(4, 9));               // 9
		System.out.println(Math.sqrt(16.0));              // 4.0
	}
}
