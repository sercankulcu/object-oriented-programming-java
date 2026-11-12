package nesnesinif;

import java.util.Scanner;

// Nesne olusturma: new ile Scanner, StringBuilder, String nesneleri.
// Klavye yerine Scanner sabit "21" dizgisinden okur.
public class Olusturma {

	// "Nesne Nasil Olusturulur?" slaytindaki ornek siniflar
	static class Araba {
		String marka;
		String model;
		int yil;
		Araba(String marka, String model, int yil) {
			this.marka = marka;
			this.model = model;
			this.yil = yil;
		}
	}

	static class Kitap {
	}

	public static void main(String[] args) {
		Scanner klavye = new Scanner("21");   // girdi: 21 (System.in yerine)
		StringBuilder metin = new StringBuilder("Java");
		String baslik = "Nesneler";           // kisayol
		String yazar = new String("Sercan");  // uzun yol
		metin.append(" 21");
		System.out.println(metin + " / " + baslik);   // Java 21 / Nesneler
		System.out.println(yazar.length());           // 6
		System.out.println(klavye.nextInt() * 2);     // 42
		klavye.close();

		// SinifAdi nesneAdi = new SinifAdi(parametreler);
		Araba corolla = new Araba("Toyota", "Corolla", 2022);
		Kitap kitap = new Kitap();
		System.out.println(corolla.marka + " " + corolla.model + " " + corolla.yil);  // Toyota Corolla 2022
		System.out.println(kitap != null);            // true
	}
}

/* Beklenen cikti:
Java 21 / Nesneler
6
42
Toyota Corolla 2022
true
*/
