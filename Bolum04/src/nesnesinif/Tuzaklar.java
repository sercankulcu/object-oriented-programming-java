package nesnesinif;

import java.util.ArrayList;

// Wrapper tuzaklari: koleksiyonlarda kutulama, -128..127 onbellegi
// yuzunden == karsilastirmasi ve null'in kutudan cikarilmasi.
public class Tuzaklar {
	public static void main(String[] args) {
		ArrayList<Integer> liste = new ArrayList<>();
		liste.add(5);                 // autoboxing: 5 -> Integer
		int ilk = liste.get(0);       // unboxing: Integer -> int
		System.out.println(ilk + 1);          // 6
		Integer a = 127, b = 127;
		Integer c = 128, d = 128;
		System.out.println(a == b);           // true
		System.out.println(c == d);           // false
		System.out.println(c.equals(d));      // true
		Integer bos = null;
		try {
			int x = bos;                  // NullPointerException
			System.out.println(x);
		} catch (NullPointerException e) {
			// java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "<local7>" is null
			System.out.println(e);
		}
	}
}
