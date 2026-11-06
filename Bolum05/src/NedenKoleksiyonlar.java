import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Koleksiyonlara giris: dizinin sabit boyutu, ArrayList'in buyumesi,
// cercevenin uc unsuru, jenerik tipler ve ilk List/Map ornekleri.
public class NedenKoleksiyonlar {

	// Neden Koleksiyonlar?
	static void nedenKoleksiyonlar() {
		int[] dizi = new int[3];      // boyut sabit: 3
		dizi[0] = 10;
		dizi[1] = 20;
		dizi[2] = 30;
		try {
			dizi[3] = 40;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("dizi[3] = 40 -> " + e);
		}

		List<Integer> liste = new ArrayList<>();
		liste.add(10);
		liste.add(20);
		liste.add(30);
		liste.add(40);       // sorun yok: buyur
		System.out.println(liste);                    // [10, 20, 30, 40]
		System.out.println("boyut: " + liste.size()); // boyut: 4
	}

	// Cercevenin Uc Unsuru
	static void ucUnsur() {
		List<String> liste = new ArrayList<>();  // arayuz <- sinif
		liste.add("Mavi");
		liste.add("Kirmizi");
		Collections.sort(liste);                  // algoritma
		System.out.println(liste);                // [Kirmizi, Mavi]
	}

	// Jenerik Tipler ve Tip Guvenligi
	static void jenerikTipler() {
		List<String> isimler = new ArrayList<>();
		isimler.add("Ali");
		// isimler.add(42);           // derleme hatasi
		String ilk = isimler.get(0);  // tur donusumu gerekmez

		List<Integer> notlar = new ArrayList<>();  // List<int> olmaz
		notlar.add(85);               // kutulama: int -> Integer
		int n = notlar.get(0);        // kutudan cikarma -> int
		System.out.println(ilk + " " + n);         // Ali 85
	}

	// Ilk Ornekler
	static void ilkOrnekler() {
		// Isim listesi (ArrayList)
		List<String> isimListesi = new ArrayList<>();
		isimListesi.add("Ahmet");
		isimListesi.add("Ayse");
		System.out.println(isimListesi);           // [Ahmet, Ayse]

		// Telefon rehberi (HashMap)
		Map<String, String> telefonRehberi = new HashMap<>();
		telefonRehberi.put("Ahmet", "555-1234");
		telefonRehberi.put("Ayse", "555-9876");
		System.out.println(telefonRehberi.get("Ahmet"));  // 555-1234
	}

	public static void main(String[] args) {
		nedenKoleksiyonlar();
		ucUnsur();
		jenerikTipler();
		ilkOrnekler();
	}
}
