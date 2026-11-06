import java.util.Arrays;

// Karsilikli dislama: oncelikli kuyrugun butun metotlari synchronized; ayni anda
// tek is parcacigi kuyrugu degistirebilir. Dolu kuyruga ekleme istisna firlatir.
public class KarsilikliDislama {

	static class HeapFullException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		HeapFullException() { super("Kuyruk dolu"); }
	}

	static class OncelikliKuyruk {
		private int[] veri;
		private int boyut;
		public OncelikliKuyruk(int n) { veri = new int[n]; }
		public synchronized void ekle(int o) {
			if (boyut == veri.length)
				throw new HeapFullException();
			veri[boyut++] = o;
		}
		public synchronized int cikar() {   // en kucugu
			int enk = 0;
			for (int i = 1; i < boyut; i++) {
				if (veri[i] < veri[enk]) enk = i;
			}
			int sonuc = veri[enk];
			veri[enk] = veri[--boyut];
			return sonuc;
		}
		public synchronized String toString() {
			return Arrays.toString(Arrays.copyOf(veri, boyut));
		}
	}

	public static void main(String[] args) {
		OncelikliKuyruk k =
				new OncelikliKuyruk(3);
		k.ekle(5);
		k.ekle(2);
		k.ekle(8);
		System.out.println(k);         // [5, 2, 8]
		int x = k.cikar();
		System.out.println(x);         // 2
		System.out.println(k);         // [5, 8]
		k.ekle(1);
		try {
			k.ekle(9);
		} catch (HeapFullException e) {
			String m = e.getMessage();
			System.out.println(m);     // Kuyruk dolu
		}
	}
}
