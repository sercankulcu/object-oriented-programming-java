
public class Kisi {
	private String ad;
	private int yas;

	public Kisi(String ad, int yas) {
		this.ad = ad;
		this.yas = yas;
	}

	// equals metodu özelleştirilmiştir
	@Override
	public boolean equals(Object obj) {
		// Aynı referansa sahipse, eşittir.
		if (this == obj) return true;

		// Null kontrolü yapılır, ve nesne türü karşılaştırılır.
		if (obj == null || getClass() != obj.getClass()) return false;

		// Kisi nesnelerinin alanları karşılaştırılır.
		Kisi kisi = (Kisi) obj;
		return yas == kisi.yas && ad.equals(kisi.ad);
	}

	public static void main(String[] args) {
		// İki farklı Kisi nesnesi oluşturulur
		Kisi kisi1 = new Kisi("Ali", 25);
		Kisi kisi2 = new Kisi("Ali", 25);

		// == işleci kullanılarak eşitlik kontrolü yapılır
		if (kisi1 == kisi2) {
			System.out.println("İki kişi nesnesi eşittir.");
		} else {
			System.out.println("İki kişi nesnesi eşit değildir.");
		}

		// equals metodu kullanılarak eşitlik kontrolü yapılır
		if (kisi1.equals(kisi2)) {
			System.out.println("İki kişi nesnesi eşittir.");
		} else {
			System.out.println("İki kişi nesnesi eşit değildir.");
		}
	}
}
