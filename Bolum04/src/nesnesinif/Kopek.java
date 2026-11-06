package nesnesinif;

// Ilklendirici sirasi: static blok sinif yuklenirken bir kez,
// ornek ilklendirici her nesnede yapicidan once calisir.
public class Kopek {
	String adi;                 // alan
	Kopek(String adi) {         // yapici metot
		this.adi = adi;
		System.out.println(adi);
	}
	String havla() {            // ornege ait metot
		return adi + " haw haw haw!";
	}
	static {                    // sinifa ait ilklendirici
		System.out.println("Kopekler!");
	}
	{                           // ornege ait ilklendirici
		System.out.println("Kopek olusturuluyor.");
	}
	public static void main(String... strings) {
		var d1 = new Kopek("Kara");
		var d2 = new Kopek("Gece");
		d2.havla();             // donen deger kullanilmiyor
		// Kopekler!
		// Kopek olusturuluyor.
		// Kara
		// Kopek olusturuluyor.
		// Gece
		System.out.println(d1.havla());   // Kara haw haw haw!
	}
}
