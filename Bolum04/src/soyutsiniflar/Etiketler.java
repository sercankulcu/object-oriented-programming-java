package soyutsiniflar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Etiketler (annotations): @FunctionalInterface derleyiciye kural denetletir;
// ozel etiket RUNTIME saklanirsa yansima ile calisirken okunur.
public class Etiketler {

	// @FunctionalInterface
	// interface Islem {
	//     int uygula(int a, int b);
	//     int ters(int a);   // 2. soyut metot
	// }
	// derleme hatasi: Unexpected @FunctionalInterface annotation
	//   Islem is not a functional interface
	//     multiple non-overriding abstract methods
	//     found in interface Islem

	// Duzeltilmis hali: tek soyut metot
	@FunctionalInterface
	interface Islem {
		int uygula(int a, int b);
	}

	@Retention(RetentionPolicy.RUNTIME)  // calisirken okunur
	@Target(ElementType.METHOD)          // yalnizca metotlara
	@interface Gorev {
		String yazar();
		int oncelik() default 1;
	}

	static class Isler {
		@Gorev(yazar = "Ayse", oncelik = 3)
		public void yedekle() { System.out.println("Yedek alindi"); }
		public void temizle() { System.out.println("Temizlendi"); }
	}

	public static void main(String[] args) throws Exception {
		Islem carp = (a, b) -> a * b;
		System.out.println(carp.uygula(6, 7));   // 42

		// main icinde (yansima, java.lang.reflect.Method):
		Isler isler = new Isler();
		for (Method m : Isler.class.getDeclaredMethods()) {
			Gorev g = m.getAnnotation(Gorev.class);
			if (g != null) {
				System.out.println(m.getName() + ", "
					+ g.yazar() + ", " + g.oncelik());
				m.invoke(isler);
			}
		}
		// yedekle, Ayse, 3
		// Yedek alindi
		isler.temizle();   // Temizlendi
	}
}

/* Beklenen cikti:
42
yedekle, Ayse, 3
Yedek alindi
Temizlendi
*/
