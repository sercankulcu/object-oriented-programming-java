import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Akis API'si: filter/map/sorted/collect hatti, tembel degerlendirme ve
// tek kullanim, reduce/groupingBy/joining, ilkel akislar, paralel akista yan etki.
public class AkisOrnekleri {

	// Akis API'si (java.util.stream)
	static void akisApisi() {
		List<Integer> notlar = Arrays.asList(45, 82, 67, 90, 38, 75);
		List<Integer> gecenler = notlar.stream()
			.filter(n -> n >= 50)
			.map(n -> n + 5)
			.sorted()
			.collect(Collectors.toList());
		System.out.println(gecenler);   // [72, 80, 87, 95]
	}

	// Tembel Degerlendirme ve Tek Kullanim
	static void tembelDegerlendirme() {
		List<String> adlar =
			Arrays.asList("Arda", "Ece", "Ayse", "Can");
		Stream<String> hat = adlar.stream()
			.filter(s -> s.startsWith("A"))
			.map(String::toUpperCase);
		// Henuz hicbir oge islenmedi.
		List<String> sonuc =
			hat.collect(Collectors.toList());
		System.out.println(sonuc);  // [ARDA, AYSE]
		try {
			hat.count();   // IllegalStateException
		} catch (IllegalStateException e) {
			System.out.println(e);  // java.lang.IllegalStateException: stream has already been operated upon or closed
		}
	}

	// Akis Hatti: Kod Izleme
	static void akisHattiIzleme() {
		List<String> adlar = Arrays.asList("Arda", "Ece", "Ayse", "Can");
		Stream<String> hat = adlar.stream()
			.filter(s -> { System.out.println("filter " + s);
						   return s.startsWith("A"); })
			.map(s -> { System.out.println("map " + s);
						return s.toUpperCase(); });
		System.out.println("hat hazir");   // hat hazir
		List<String> sonuc = hat.collect(Collectors.toList());
		// filter Arda, map Arda, filter Ece, filter Ayse, map Ayse, filter Can
		System.out.println(sonuc);         // [ARDA, AYSE]
	}

	// reduce, Collectors ve Ilkel Akislar
	static void reduceCollectors() {
		List<String> meyveler = Arrays.asList(
			"elma", "kivi", "muz", "erik", "incir");
		int toplam = Arrays.asList(4, 8, 15, 16, 23)
			.stream().reduce(0, Integer::sum);
		Map<Integer, List<String>> boy = meyveler
			.stream().collect(
				Collectors.groupingBy(String::length));
		String hepsi = meyveler.stream()
			.collect(Collectors.joining(", "));
		int t = IntStream.rangeClosed(1, 100).sum();
		Optional<String> z = meyveler.stream()
			.filter(m -> m.startsWith("z")).findFirst();
		System.out.println("toplam = " + toplam);   // toplam = 66
		System.out.println("boy = " + boy);         // boy = {3=[muz], 4=[elma, kivi, erik], 5=[incir]}
		System.out.println("hepsi = " + hepsi);     // hepsi = elma, kivi, muz, erik, incir
		System.out.println("t = " + t);             // t = 5050
		System.out.println(z.orElse("yok"));        // yok
	}

	// Yan Etkiler ve Paralel Akislar
	static void yanEtkiler() {
		List<Integer> liste = new ArrayList<>();
		try {
			IntStream.range(0, 10000).parallel()
				.forEach(liste::add);          // YANLIS: paylasilan liste
			System.out.println("YANLIS yol: " + liste.size() + " oge");  // cogu zaman 10000'den az
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("YANLIS yol: " + e.getClass().getSimpleName());  // ArrayIndexOutOfBoundsException
		}

		List<Integer> dogru = IntStream.range(0, 10000).parallel()
			.boxed()
			.collect(Collectors.toList()); // DOGRU: 10000 oge
		System.out.println("DOGRU yol: " + dogru.size() + " oge");      // DOGRU yol: 10000 oge
	}

	public static void main(String[] args) {
		akisApisi();
		tembelDegerlendirme();
		akisHattiIzleme();
		reduceCollectors();
		yanEtkiler();
	}
}
