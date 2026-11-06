import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

// Siralama: Collections.sort, reverseOrder, reverse; Comparable ile dogal
// sira, Comparator ile baska bir sira; shuffle ile karistirma.
public class SiralamaOrnekleri {

	// Comparable: Dogal Sira
	static class Ogrenci implements Comparable<Ogrenci> {
		String isim;
		int puan;

		Ogrenci(String isim, int puan) {
			this.isim = isim;
			this.puan = puan;
		}

		// puana gore artan sira
		@Override
		public int compareTo(Ogrenci diger) {
			return Integer.compare(puan, diger.puan);
		}

		@Override
		public String toString() {
			return isim + ":" + puan;
		}
	}

	// Siralama Metotlari
	static void siralamaMetotlari() {
		List<String> isimler = new ArrayList<>(
				Arrays.asList("Cem", "Ayse", "Banu", "Ali"));
		Collections.sort(isimler);
		System.out.println(isimler);   // [Ali, Ayse, Banu, Cem]
		Collections.sort(isimler, Collections.reverseOrder());
		System.out.println(isimler);   // [Cem, Banu, Ayse, Ali]
		Collections.reverse(isimler);
		System.out.println(isimler);   // [Ali, Ayse, Banu, Cem]
	}

	// Comparable: Dogal Sira ve Comparator: Baska Bir Sira
	static void comparableComparator() {
		List<Ogrenci> sinif = new ArrayList<>();
		sinif.add(new Ogrenci("Cem", 72));
		sinif.add(new Ogrenci("Ayse", 95));
		sinif.add(new Ogrenci("Banu", 60));

		Collections.sort(sinif);
		System.out.println(sinif);   // [Banu:60, Cem:72, Ayse:95]

		Collections.sort(sinif, new Comparator<Ogrenci>() {
			@Override
			public int compare(Ogrenci a, Ogrenci b) {
				return a.isim.compareTo(b.isim);   // isme gore
			}
		});
		System.out.println(sinif);   // [Ayse:95, Banu:60, Cem:72]

		// Java 8+: ayni isin kisa yazimi
		sinif.sort(Comparator.comparing(o -> o.puan));
		System.out.println(sinif);   // [Banu:60, Cem:72, Ayse:95]
	}

	// Karistirma (tekrarlanabilir olsun diye sabit tohum: new Random(42))
	static void karistirma() {
		List<String> ogrenciler = new ArrayList<>(
				Arrays.asList("Ali", "Banu", "Cem", "Deniz"));
		Collections.shuffle(ogrenciler, new Random(42));
		System.out.println(ogrenciler);   // [Deniz, Banu, Ali, Cem] (tohum 42)
	}

	public static void main(String[] args) {
		siralamaMetotlari();
		comparableComparator();
		karistirma();
	}
}
