import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// ClassCastException: yanlis tur donusumu; ham (raw) koleksiyonlar hatayi
// calisma zamanina birakir. instanceof ve jenerikler hatayi onler.
// Not: ham turler sunumun bilerek gosterdigi seydir; -Xlint rawtypes/unchecked uyarisi verir.
public class ClassCastOrnekleri {

	static void ornekler() {
		Object obj = "Merhaba";
		Integer number;
		try {
			number = (Integer) obj;
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());   // class java.lang.String cannot be cast to class java.lang.Integer (...)
		}
		ArrayList list = new ArrayList();
		list.add("Merhaba");
		try {
			number = (Integer) list.get(0);
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());   // class java.lang.String cannot be cast to class java.lang.Integer (...)
		}
		Map map = new HashMap();
		map.put("anahtar", "Deger");
		Integer value;
		try {
			value = (Integer) map.get("anahtar");
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());   // class java.lang.String cannot be cast to class java.lang.Integer (...)
		}
		Set set = new HashSet();
		set.add("Merhaba");
		try {
			value = (Integer) set.iterator().next();
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());   // class java.lang.String cannot be cast to class java.lang.Integer (...)
		}
		Object[] objArray = new String[5];
		try {
			Integer[] intArray = (Integer[]) objArray;
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());   // class [Ljava.lang.String; cannot be cast to class [Ljava.lang.Integer; (...)
		}
	}

	// instanceof ile Onleme
	static void instanceofIleOnleme() {
		Object obj = "Merhaba";
		if (obj instanceof Integer) {
			Integer sayi = (Integer) obj;
			System.out.println("Sayi: " + sayi);
		} else {
			System.out.println("obj bir Integer degil");   // obj bir Integer degil
		}

		if (obj instanceof Integer sayi) {
			System.out.println("Sayi: " + sayi);
		}

		ArrayList<String> liste = new ArrayList<>();
		liste.add("Merhaba");
		// Integer n = (Integer) liste.get(0);
		// derleme hatasi: incompatible types: String cannot be converted to Integer
		String n = liste.get(0);   // duzeltme: jenerik tur zaten String
		System.out.println(n);     // Merhaba
	}

	public static void main(String[] args) {
		ornekler();
		instanceofIleOnleme();
	}
}

/* Beklenen cikti:
class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
class [Ljava.lang.String; cannot be cast to class [Ljava.lang.Integer; ([Ljava.lang.String; and [Ljava.lang.Integer; are in module java.base of loader 'bootstrap')
obj bir Integer degil
Merhaba
*/
