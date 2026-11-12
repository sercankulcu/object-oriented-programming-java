package uygulama;

// import banka.Yardimci;
// derleme hatasi: Ana2.java:3: error: Yardimci is not public in banka;
// cannot be accessed from outside package

// Paket erisimi: public olmayan banka.Yardimci baska paketten
// import edilemez.
public class Ana2 {
	public static void main(String[] args) {
		System.out.println("banka.Yardimci buradan gorulmez");
	}
}

/* Beklenen cikti:
banka.Yardimci buradan gorulmez
*/
