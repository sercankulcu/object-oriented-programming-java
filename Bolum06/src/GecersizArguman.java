import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// IllegalArgumentException: kendi metotlarimizda gecersiz argumani reddetmek
// ve Java kutuphanesinin ayni istisnayi firlattigi ornekler.
public class GecersizArguman {
	private int age;
	private String name;

	public void yasAyarla(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Yas negatif olamaz");
		}
		this.age = age;
	}
	public void adAyarla(String name) {
		if (name.length() < 3) {
			throw new IllegalArgumentException("3 karakter olmali");
		}
		this.name = name;
	}

	public static void main(String[] args) {
		GecersizArguman g = new GecersizArguman();
		g.yasAyarla(20);
		g.adAyarla("Ali");
		System.out.println(g.name + " " + g.age);   // Ali 20

		try {
			g.yasAyarla(-5);
		} catch (IllegalArgumentException e) {
			System.out.println(e);   // java.lang.IllegalArgumentException: Yas negatif olamaz
		}
		try {
			g.adAyarla("Al");
		} catch (IllegalArgumentException e) {
			System.out.println(e);   // java.lang.IllegalArgumentException: 3 karakter olmali
		}
		int[] numbers = {1, 2, 3};
		try {
			Arrays.copyOfRange(numbers, 5, 2);
		} catch (IllegalArgumentException e) {
			System.out.println(e);   // java.lang.IllegalArgumentException: 5 > 2
		}
		try {
			List<Integer> liste = new ArrayList<>(-1);
		} catch (IllegalArgumentException e) {
			System.out.println(e);   // java.lang.IllegalArgumentException: Illegal Capacity: -1
		}
		try {
			File file = new File(URI.create("http://ornek.com/a.txt"));
		} catch (IllegalArgumentException e) {
			System.out.println(e);   // java.lang.IllegalArgumentException: URI scheme is not "file"
		}
		Runnable gorev = () -> System.out.println("gorev");
		Thread thread = new Thread(gorev);
		try {
			thread.setPriority(11);
		} catch (IllegalArgumentException e) {
			System.out.println(e);   // java.lang.IllegalArgumentException
		}
	}
}

/* Beklenen cikti:
Ali 20
java.lang.IllegalArgumentException: Yas negatif olamaz
java.lang.IllegalArgumentException: 3 karakter olmali
java.lang.IllegalArgumentException: 5 > 2
java.lang.IllegalArgumentException: Illegal Capacity: -1
java.lang.IllegalArgumentException: URI scheme is not "file"
java.lang.IllegalArgumentException
*/
