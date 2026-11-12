import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Ornek problem: LinkedHashSet ile tekrarlari ilk gorulme sirasini
// koruyarak atmak.
public class TekrarSiz {
	static List<String> tekrarSiz(List<String> giris) {
		Set<String> gorulen = new LinkedHashSet<>(giris);
		return new ArrayList<>(gorulen);
	}

	public static void main(String[] args) {
		List<String> l = Arrays.asList("b", "a", "b", "c", "a");
		System.out.println(tekrarSiz(l));   // [b, a, c]
	}
}

/* Beklenen cikti:
[b, a, c]
*/
