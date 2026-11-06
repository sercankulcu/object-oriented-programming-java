package nesnesinif;

// Kayitlar (records): yapici, erisim metotlari, equals, hashCode ve
// toString derleyici tarafindan uretilir; alanlar degistirilemez.
public class KayitTesti {

	record Nokta(double x, double y) { }

	public static void main(String[] args) {
		Nokta nokta1 = new Nokta(1.0, 2.5);
		Nokta nokta2 = new Nokta(1.0, 2.5);
		boolean esitMi = nokta1.equals(nokta2);
		System.out.println(esitMi);                     // true
		System.out.println(nokta1 == nokta2);           // false
		System.out.println(nokta1);                     // Nokta[x=1.0, y=2.5]
		System.out.println(nokta1.x() + nokta1.y());    // 3.5
		// nokta1.x = 3.0;
		// derleme hatasi: x has private access in Nokta (ayri sinifta)
	}
}
