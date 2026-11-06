// Masa Basi Kontrol: basamaklar toplami. Her tur izleme tablosunun bir
// satiri olarak yazdirilir (sayi = 472).
public class MasaBasiKontrol {
	public static void main(String[] args) {
		int sayi = 472, toplam = 0;
		while (sayi > 0) {
			toplam += sayi % 10;
			sayi /= 10;
			System.out.println("tur: toplam = " + toplam + ", sayi = " + sayi);
		}
		// tur: toplam = 2, sayi = 47
		// tur: toplam = 9, sayi = 4
		// tur: toplam = 13, sayi = 0
		System.out.println(toplam);  // 13
	}
}
