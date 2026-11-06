// tr/edu/giresun/banka/Yardimci.java
package tr.edu.giresun.banka;

// Paket adlandirma: ters alan adi (tr.edu.giresun) ile baslayan paket;
// Yardimci paket erisimli oldugu icin alt paketten bile gorulmez.
class Yardimci {                  // paket erisimli
	static double kdv(double t) { return t * 0.20; }

	// ayni paketten erisim serbest
	public static void main(String[] args) {
		System.out.println(kdv(100));   // 20.0
	}
}
