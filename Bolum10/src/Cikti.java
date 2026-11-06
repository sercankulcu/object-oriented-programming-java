import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Yardimci sinif: is parcaciklarinin yazdigi satirlari yakalar ve siralayip yazdirir.
// Satirlarin sirasi is parcacigi zamanlamasina bagli oldugundan ornekler bunu kullanir;
// boylece program her calistirmada ayni ciktiyi verir.
public class Cikti {
	private static PrintStream asil;
	private static ByteArrayOutputStream tampon;

	// System.out'u bir tampona yonlendirir
	public static synchronized void yakala() {
		asil = System.out;
		tampon = new ByteArrayOutputStream();
		System.setOut(new PrintStream(tampon, true));
	}

	// System.out'u geri verir, yakalanan satirlari siralayip yazdirir
	public static synchronized void siraliYazdir() {
		siraliYazdir(null, null);
	}

	// Ayni, ama once her satirda desen -> yerine degisimi yapar (degisen ad ve sayilar icin)
	public static synchronized void siraliYazdir(String desen, String yerine) {
		System.out.flush();
		System.setOut(asil);
		List<String> satirlar = new ArrayList<>();
		for (String s : tampon.toString().split("\\R")) {
			if (s.isEmpty())
				continue;
			satirlar.add(desen == null ? s : s.replaceAll(desen, yerine));
		}
		Collections.sort(satirlar);
		for (String s : satirlar)
			System.out.println(s);
	}

	// Ana is parcacigi disindaki, main grubundaki daemon olmayan butun is parcaciklarini bekler
	public static void digerleriniBekle() throws InterruptedException {
		for (Thread t : Thread.getAllStackTraces().keySet()) {
			ThreadGroup g = t.getThreadGroup();
			if (t != Thread.currentThread() && !t.isDaemon()
					&& g != null && g.getName().equals("main"))
				t.join();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		yakala();
		Thread a = new Thread(() -> System.out.println("b: ikinci"));
		Thread b = new Thread(() -> System.out.println("a: birinci"));
		a.start();
		b.start();
		digerleriniBekle();
		siraliYazdir();
		// a: birinci
		// b: ikinci
	}
}
