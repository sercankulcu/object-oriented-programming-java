package sarmalama;

// Sizan referans: yapici disaridaki diziyi, getter ic diziyi
// paylasir; final alan olsa da dizinin icerigi disaridan bozulur.
public class SizanReferans {

	static class Karne {
		private final int[] notlar;
		public Karne(int[] notlar) {
			this.notlar = notlar; // ayni dizi
		}
		public int[] getNotlar() {
			return notlar;        // ic dizi
		}
		public double ortalama() {
			int t = 0;
			for (int n : notlar) t += n;
			return (double) t / notlar.length;
		}
	}

	public static void main(String[] args) {
		int[] dizi = {70, 80, 90};
		Karne k = new Karne(dizi);
		dizi[0] = 0;                // disaridaki dizi
		k.getNotlar()[1] = -100;    // getter'dan gelen
		System.out.println(k.ortalama());   // -3.3333333333333335
	}
}
