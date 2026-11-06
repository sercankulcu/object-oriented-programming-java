// Fonksiyon Cagirma: main, toplama metodunu cagirir ve donen degeri yazdirir.
public class ToplamaOrnegi {
	public static int toplama(int sayi1, int sayi2) {
		int sonuc = sayi1 + sayi2;
		return sonuc;
	}

	public static void main(String[] args) {
		int sonuc = toplama(5, 3);
		System.out.println("Toplam: " + sonuc);   // Toplam: 8
	}
}
