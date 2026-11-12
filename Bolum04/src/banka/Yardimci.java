package banka;

// Paket erisimi: public olmayan Yardimci sinifi yalnizca banka
// paketinin icinden kullanilabilir.
class Yardimci {     // public degil
	static double kdv(double tutar) {
		return tutar * 0.20;
	}

	// ayni paketten erisim serbest
	public static void main(String[] args) {
		System.out.println(Yardimci.kdv(250.0));   // 50.0
	}
}

/* Beklenen cikti:
50.0
*/
