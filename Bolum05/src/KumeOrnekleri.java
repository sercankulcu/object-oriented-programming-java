import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

// Kumeler: HashSet, LinkedHashSet, TreeSet; equals/hashCode'un onemi,
// degisen anahtar sorunu, TreeSet aralik metotlari ve kume islemleri.
public class KumeOrnekleri {

	// Kendi Siniflarimiz ve HashSet: equals/hashCode yazilmis surum
	static class Nokta {
		int x, y;
		Nokta(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Nokta)) return false;
			Nokta n = (Nokta) o;
			return x == n.x && y == n.y;
		}
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	// Karsilastirma icin: equals/hashCode yazilmamis surum
	static class NoktaA {
		int x, y;
		NoktaA(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// Set Arayuzu
	static void setArayuzu() {
		Set<String> meyveler = new HashSet<>();
		System.out.println(meyveler.add("Elma"));        // true
		System.out.println(meyveler.add("Armut"));       // true
		System.out.println(meyveler.add("Elma"));        // false
		System.out.println(meyveler.size());             // 2
		System.out.println(meyveler.contains("Armut"));  // true
		meyveler.remove("Armut");
		System.out.println(meyveler);                    // [Elma]
	}

	// LinkedHashSet Sinifi
	static void linkedHashSetSinifi() {
		LinkedHashSet<Integer> sayilar =
				new LinkedHashSet<>();
		sayilar.add(5);
		sayilar.add(10);
		sayilar.add(5);         // tekrar: eklenmez
		sayilar.add(1);
		System.out.println(sayilar);   // [5, 10, 1]
	}

	// Uc Kumenin Sirasi
	static void ucKumeninSirasi() {
		String[] kelimeler = {"muz", "elma", "kiraz", "elma", "armut"};
		Set<String> h = new HashSet<>();
		Set<String> l = new LinkedHashSet<>();
		Set<String> t = new TreeSet<>();
		for (String k : kelimeler) {
			h.add(k);
			l.add(k);
			t.add(k);
		}
		System.out.println("HashSet:       " + h);   // [muz, elma, armut, kiraz]
		System.out.println("LinkedHashSet: " + l);   // [muz, elma, kiraz, armut]
		System.out.println("TreeSet:       " + t);   // [armut, elma, kiraz, muz]
	}

	// Kendi Siniflarimiz ve HashSet
	static void kendiSiniflarimiz() {
		Set<NoktaA> s1 = new HashSet<>();
		s1.add(new NoktaA(1, 2));
		s1.add(new NoktaA(1, 2));
		System.out.println(s1.size());   // 2

		Set<Nokta> s2 = new HashSet<>();
		s2.add(new Nokta(1, 2));
		s2.add(new Nokta(1, 2));
		System.out.println(s2.size());   // 1
	}

	// Degisen Anahtar: Kod Izleme
	static void degisenAnahtar() {
		Set<Nokta> kume = new HashSet<>();
		Nokta p = new Nokta(1, 2);
		kume.add(p);
		System.out.println(kume.contains(p));                 // true
		p.x = 5;              // alan degisti
		System.out.println(kume.contains(p));                 // false
		System.out.println(kume.contains(new Nokta(1, 2)));   // false
		kume.add(p);
		System.out.println(kume.size());                      // 2
	}

	// TreeSet Ornegi
	static void treeSetOrnegi() {
		TreeSet<Integer> notlar = new TreeSet<>();
		notlar.add(70);
		notlar.add(50);
		notlar.add(90);
		notlar.add(60);
		notlar.add(80);
		System.out.println(notlar);                               // [50, 60, 70, 80, 90]
		System.out.println(notlar.first() + " " + notlar.last()); // 50 90
		System.out.println(notlar.headSet(70));     // [50, 60] (70 haric)
		System.out.println(notlar.tailSet(70));     // [70, 80, 90] (70 dahil)
		System.out.println(notlar.subSet(60, 90));  // [60, 70, 80] ([60, 90))
		System.out.println(notlar.comparator());    // null (dogal sira)

		TreeSet<String> meyveler = new TreeSet<>();
		meyveler.add("Elma");
		meyveler.add("Armut");
		System.out.println(meyveler);               // [Armut, Elma]
	}

	// Kume Islemleri
	static void kumeIslemleri() {
		Set<Integer> a = new TreeSet<>(Arrays.asList(1, 2, 3, 4));
		Set<Integer> b = new TreeSet<>(Arrays.asList(3, 4, 5));

		Set<Integer> birlesim = new TreeSet<>(a);
		birlesim.addAll(b);
		Set<Integer> kesisim = new TreeSet<>(a);
		kesisim.retainAll(b);
		Set<Integer> fark = new TreeSet<>(a);
		fark.removeAll(b);

		System.out.println("A birlesim B = " + birlesim);  // A birlesim B = [1, 2, 3, 4, 5]
		System.out.println("A kesisim B = " + kesisim);    // A kesisim B = [3, 4]
		System.out.println("A - B = " + fark);             // A - B = [1, 2]
		System.out.println(a.containsAll(kesisim));        // true
	}

	public static void main(String[] args) {
		setArayuzu();
		linkedHashSetSinifi();
		ucKumeninSirasi();
		kendiSiniflarimiz();
		degisenAnahtar();
		treeSetOrnegi();
		kumeIslemleri();
	}
}
