
public class KarsilastirmaIslemleriOrnegi {
	
	public static void main(String[] args) {
		
		int sayi1 = 10;
		int sayi2 = 20;

		// Eşitlik karşılaştırması
		boolean esitMi = (sayi1 == sayi2);
		System.out.println("sayi1, sayi2'ye eşit mi? " + esitMi); // false

		// Eşit değil karşılaştırması
		boolean esitDegilMi = (sayi1 != sayi2);
		System.out.println("sayi1, sayi2'ye eşit değil mi? " + esitDegilMi); // true

		// Büyüklük karşılaştırması
		boolean buyukMu = (sayi1 > sayi2);
		System.out.println("sayi1, sayi2'den büyük mü? " + buyukMu); // false

		// Küçüklük karşılaştırması
		boolean kucukMu = (sayi1 < sayi2);
		System.out.println("sayi1, sayi2'den küçük mü? " + kucukMu); // true

		// Büyük veya eşit karşılaştırması
		boolean buyukVeyaEsitMi = (sayi1 >= sayi2);
		System.out.println("sayi1, sayi2'den büyük veya eşit mi? " + buyukVeyaEsitMi); // false

		// Küçük veya eşit karşılaştırması
		boolean kucukVeyaEsitMi = (sayi1 <= sayi2);
		System.out.println("sayi1, sayi2'den küçük veya eşit mi? " + kucukVeyaEsitMi); // true
	}
}
