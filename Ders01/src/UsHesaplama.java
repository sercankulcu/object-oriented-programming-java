
public class UsHesaplama {

	public static void main(String[] args) {

		double sonuc = usHesapla(5, -2);
		System.out.println(sonuc);

		sonuc = usHesapla(5, -3);
		System.out.println(sonuc);

		sonuc = usHesapla(5, -1);
		System.out.println(sonuc);

		sonuc = usHesapla(5, 0);
		System.out.println(sonuc);

		sonuc = usHesapla(5, 2);
		System.out.println(sonuc);
	}

	public static double usHesapla(double taban, int us) {

		double sonuc = 1;
		if (us < 0) {
			sonuc = 1.0 / (usHesapla(taban, -us)); // Negatif üs için hesaplama
		} else {
			for (int i = 0; i < us; i++) {
				sonuc *= taban;
			}
		}
		return sonuc;
	}
}
