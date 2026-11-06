package banka;

// Paket ornegi: banka paketindeki public Hesap sinifi; baska
// paketten import banka.Hesap ile kullanilir.
public class Hesap {
	private double bakiye;

	public void yatir(double miktar) {
		if (miktar > 0) {
			bakiye += miktar;
		}
	}

	public double getBakiye() {
		return bakiye;
	}
}
