// Ne Kadar Yer Tutar? Goruntu ve sesin bayt olarak boyutu.
// long ile hesaplanir; int tasabilirdi.
public class YerHesabi {
	public static void main(String[] args) {
		long piksel = 1920L * 1080;  // Full HD bir kare
		long kare = piksel * 3;      // R, G, B: 3 bayt
		long saniye = kare * 30;     // saniyede 30 kare
		System.out.println("Piksel: " + piksel);             // Piksel: 2073600
		System.out.println("Kare (bayt): " + kare);          // Kare (bayt): 6220800
		System.out.println("1 saniye (bayt): " + saniye);    // 1 saniye (bayt): 186624000
		System.out.println("1 dakika (MB): "
				+ saniye * 60 / 1_000_000);                  // 1 dakika (MB): 11197
		// 44,1 kHz, 16 bit (2 bayt), stereo, 1 dakika
		long ses = 44_100L * 2 * 2 * 60;
		System.out.println("1 dk CD sesi (bayt): " + ses);   // 1 dk CD sesi (bayt): 10584000
	}
}
