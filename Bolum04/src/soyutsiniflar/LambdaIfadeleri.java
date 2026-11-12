package soyutsiniflar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// Lambda ifadeleri: tek soyut metotlu (fonksiyonel) arayuzun kisa yazimi.
// Hazir arayuzler, filtreleme, anonim sinifla karsilastirma ve kullanim alanlari.
public class LambdaIfadeleri {

	// Anonim (Lambda) Fonksiyonlar: ayni isin isimli metotla yazimi
	static int toplama(int x, int y) {
		return x + y;
	}

	@FunctionalInterface
	interface Selamlama {
		void selamVer(String ad);
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(toplama(5, 3));   // 8

		// Fonksiyonel Arayuz
		Selamlama s = ad -> System.out.println("Merhaba " + ad);
		s.selamVer("Ayse");                  // Merhaba Ayse

		// Hazir Fonksiyonel Arayuzler
		Consumer<String> yaz = m -> System.out.println(m);
		yaz.accept("Consumer calisti");      // Consumer calisti
		Supplier<Integer> zar = () -> 4;
		System.out.println(zar.get());       // 4
		Function<String, Integer> uzunluk = m -> m.length();
		System.out.println(uzunluk.apply("Giresun"));   // 7
		Predicate<Integer> pozitifMi = x -> x > 0;
		System.out.println(pozitifMi.test(-7));         // false

		// Predicate ile Filtreleme: Kod Izleme
		{
			Predicate<Integer> ciftMi = x -> x % 2 == 0;
			List<Integer> sayilar = Arrays.asList(3, 8, 5, 12);
			List<Integer> sonuc = new ArrayList<>();
			for (int n : sayilar) {
				if (ciftMi.test(n)) {
					sonuc.add(n);
				}
			}
			System.out.println(sonuc);       // [8, 12]
		}

		// Lambda Ornegi: Liste Filtreleme
		{
			IntBinaryOperator toplama = (int x, int y) -> x + y;
			System.out.println(toplama.applyAsInt(5, 3));   // 8

			List<Integer> sayilar = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
			List<Integer> ciftSayilar = sayilar.stream().
								filter(n -> n % 2 == 0).
								collect(Collectors.toList());
			System.out.println(ciftSayilar);                          // [2, 4, 6]
			System.out.println(sayilar.stream().map(n -> n * n).toList()); // [1, 4, 9, 16, 25, 36, 49]
		}

		// Lambda ve Anonim Sinif
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonim sinif");
			}
		};
		Runnable r2 =
				() -> System.out.println("Lambda");
		r1.run();   // Anonim sinif
		r2.run();   // Lambda

		int kdv = 20;
		Function<Integer, Integer> vergili =
				fiyat -> fiyat + fiyat * kdv / 100;
		System.out.println(vergili.apply(150)); // 180
		// kdv = 18;  // eklenirse: derleme hatasi
		// derleme hatasi: local variables referenced from
		//   a lambda expression must be final
		//   or effectively final

		// Kullanim Alanlari
		List<String> isimler = new ArrayList<>(List.of("Zeynep", "Ali", "Mehmet"));
		isimler.sort((a, b) -> a.length() - b.length());
		System.out.println(isimler);   // [Ali, Zeynep, Mehmet]
		isimler.forEach(isim -> System.out.println("Merhaba " + isim));
		// Merhaba Ali
		// Merhaba Zeynep
		// Merhaba Mehmet
		Thread is = new Thread(() -> System.out.println("Is parcacigi calisti"));
		is.start();
		is.join();                     // Is parcacigi calisti
	}
}

/* Beklenen cikti:
8
Merhaba Ayse
Consumer calisti
4
7
false
[8, 12]
8
[2, 4, 6]
[1, 4, 9, 16, 25, 36, 49]
Anonim sinif
Lambda
180
[Ali, Zeynep, Mehmet]
Merhaba Ali
Merhaba Zeynep
Merhaba Mehmet
Is parcacigi calisti
*/
