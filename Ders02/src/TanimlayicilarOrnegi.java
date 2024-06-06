
public class TanimlayicilarOrnegi {

	//Metot tanımlama
	void selamVer() { // "selamVer" adında bir metot tanımlandı
		System.out.println("Merhaba, dünya!");
	}

	public static void main(String[] args) {

		// Değişken tanımlama
		int yas = 30; // "yas" adında bir değişken tanımlandı

		// Sabit (final) tanımlama
		final double PI = 3.14159; // "PI" adında bir sabit tanımlandı

		// Sınıf tanımlama
		class Ogrenci { // "Ogrenci" adında bir sınıf tanımlandı
			String ad;
			String soyad;
		}

		// Etiket (label) kullanımı
		dongu: for (int i = 1; i <= 5; i++) {
			if (i == 3) {
				continue dongu; // "dongu" etiketini kullanarak döngüyü atladı
			}
			System.out.println("İterasyon " + i);
		}

		// Daha fazla tanımlayıcı kullanımı...
	}
}
