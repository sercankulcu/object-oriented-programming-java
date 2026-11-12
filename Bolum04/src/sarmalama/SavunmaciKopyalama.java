package sarmalama;

// Savunmaci kopyalama: dizi giriste ve cikista kopyalanir; dis
// degisiklikler Karne'nin ic dizisine ulasmaz.
public class SavunmaciKopyalama {

	static class Karne {
		private final int[] notlar;
		public Karne(int[] notlar) {
			this.notlar = notlar.clone(); // giriste
		}
		public int[] getNotlar() {
			return notlar.clone();        // cikista
		}
		// ortalama() ayni
		public double ortalama() {
			int t = 0;
			for (int n : notlar) t += n;
			return (double) t / notlar.length;
		}
	}

	public static void main(String[] args) {
		int[] dizi = {70, 80, 90};
		Karne k = new Karne(dizi);
		dizi[0] = 0;
		k.getNotlar()[1] = -100;
		System.out.println(k.ortalama());   // 80.0
	}
}

/* Beklenen cikti:
80.0
*/
