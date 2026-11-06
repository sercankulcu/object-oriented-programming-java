package nesnesinif;

// Integer onbellegi (kod izleme): 127 onbellekten gelir, 128 her
// seferinde yeni nesnedir; null kutudan cikarilinca hata firlatir.
public class IntegerOnbellegi {
	public static void main(String[] args) {
		Integer a = 127, b = 127;
		Integer c = 128, d = 128;
		System.out.println(a == b);           // true
		System.out.println(c == d);           // false
		System.out.println(c.equals(d));      // true
		int t = c + d;
		System.out.println(t);                // 256
		Integer bos = null;
		try {
			int x = bos;
			System.out.println(x);
		} catch (NullPointerException e) {
			// Exception in thread "main" java.lang.NullPointerException
			System.out.println(e.getClass().getName());   // java.lang.NullPointerException
		}
	}
}
