package nesnesinif;

// this ile nesneyi aktarmak: Takim kendisini (this) Oyuncu'nun
// metoduna parametre olarak gonderir.
public class Takim {
	private String ad;
	public Takim(String ad) {
		this.ad = ad;
	}
	public void oyuncuEkle(Oyuncu oyuncu) {
		oyuncu.takimaKatil(this);   // bu nesne
	}
	public String getAd() {
		return ad;
	}
	public static void main(String[] args) {
		Takim takim = new Takim("Giresunspor");
		Oyuncu oyuncu = new Oyuncu("Mert");
		takim.oyuncuEkle(oyuncu);   // Mert -> Giresunspor
	}

	static class Oyuncu {
		private String ad;
		Oyuncu(String ad) {
			this.ad = ad;
		}
		void takimaKatil(Takim takim) {
			String t = takim.getAd();
			System.out.println(ad + " -> " + t);
		}
	}
}
