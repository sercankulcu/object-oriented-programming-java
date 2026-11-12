// tr/edu/giresun/banka/rapor/Rapor.java
package tr.edu.giresun.banka.rapor;

// import tr.edu.giresun.banka.Yardimci;
// error: Yardimci is not public in tr.edu.giresun.banka; cannot be
// accessed from outside package
// Alt paket ayri bir pakettir: ust paketin paket erisimli uyelerini goremez.

public class Rapor {
	// double hesapla() { return Yardimci.kdv(100); }   // derleme hatasi (yukarida)
	double hesapla() { return 100 * 0.20; }             // duzeltme: Yardimci kullanilmadan

	public static void main(String[] args) {
		System.out.println(new Rapor().hesapla());   // 20.0
	}
}

/* Beklenen cikti:
20.0
*/
