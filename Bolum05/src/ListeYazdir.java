import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Arayuze gore programlama: parametre turu List oldugu icin
// ayni metot hem ArrayList hem LinkedList ile calisir.
public class ListeYazdir {
	// Parametre turu arayuz: her List ile calisir
	static void yazdir(List<String> liste) {
		for (String s : liste) {
			System.out.print(s + " ");
		}
		System.out.println("(" + liste.size() + " oge)");
	}

	public static void main(String[] args) {
		List<String> a = new ArrayList<>();
		a.add("Elma");
		a.add("Armut");
		List<String> b = new LinkedList<>(a);  // ayni ogeler
		b.add("Kiraz");
		yazdir(a);   // Elma Armut (2 oge)
		yazdir(b);   // Elma Armut Kiraz (3 oge)
	}
}
