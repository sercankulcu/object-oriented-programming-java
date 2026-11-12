import java.io.FileNotFoundException;
import java.io.FileReader;

// Kontrol edilen istisna (FileNotFoundException) ya bildirilir (throws) ya da
// ele alinir (try-catch). Kontrol edilmeyen istisna (ArithmeticException) onlenir.
public class KontrolEdilenIstisna {

	// Kontrol Edilen Istisna
	// public void dosyaOku() {
	//   FileReader okuyucu = new FileReader("veri.txt");
	// }
	// derleme hatasi: unreported exception FileNotFoundException;
	//   must be caught or declared to be thrown
	// Duzeltme: throws ile bildirmek
	public void dosyaOku() throws FileNotFoundException {
		// Dosya okuma kodu
		FileReader okuyucu = new FileReader("veri.txt");
	}

	// Ele Alarak Cozmek
	public static void dosyaOku2() {
		try {
			FileReader okuyucu = new FileReader("veri.txt");
			// Dosya okuma kodu
		} catch (FileNotFoundException e) {
			// Kontrol edilen istisna burada ele aliniyor
			System.err.println("Dosya bulunamadi: " + e.getMessage());
			// Gerekirse istisna tekrar firlatilabilir:
			// throw e;
		}
	}

	// Kontrol Edilmeyen Istisna: ilk surum (onlemesiz)
	static class Onlemesiz {
		public void bolmeIslemi(int pay, int payda) {
			// Kontrol edilmeyen istisna: ArithmeticException
			int sonuc = pay / payda;
		}
	}

	// Kontrol Edilmeyen Istisna: onlemeli surum
	static class Onlemeli {
		public void bolmeIslemi(int pay, int payda) {
			if (payda == 0) {   // onleme
				System.out.println("Payda sifir olamaz");
				return;
			}
			int sonuc = pay / payda;
		}
	}

	// Istisna Firlatan Metodu Cagirmak
	static class Cagiran {
		public void dosyaOku() throws FileNotFoundException {
			// Dosya okuma kodu
		}

		void cagir() {
			try {
				dosyaOku();
			} catch (FileNotFoundException e) {
				// Dosya bulunamadi durumuyla basa cikma kodu
				System.err.println("Dosya bulunamadi: " + e.getMessage());
			}
		}

		// Ele almak yerine yukari aktarmak
		public void raporHazirla() throws FileNotFoundException {
			dosyaOku();
		}
	}

	public static void main(String[] args) {
		try {
			new KontrolEdilenIstisna().dosyaOku();
		} catch (FileNotFoundException e) {
			System.out.println("main yakaladi: " + e.getMessage());  // main yakaladi: veri.txt (The system cannot find the file specified)
		}
		dosyaOku2();   // (stderr) Dosya bulunamadi: veri.txt (The system cannot find the file specified)

		try {
			new Onlemesiz().bolmeIslemi(10, 0);
		} catch (ArithmeticException e) {
			System.out.println("Onlemesiz: " + e);   // Onlemesiz: java.lang.ArithmeticException: / by zero
		}
		new Onlemeli().bolmeIslemi(10, 0);           // Payda sifir olamaz

		Cagiran c = new Cagiran();
		c.cagir();   // dosyaOku hata firlatmaz: cikti yok
		try {
			c.raporHazirla();
			System.out.println("rapor hazir");       // rapor hazir
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}

/* Beklenen cikti:
main yakaladi: veri.txt (The system cannot find the file specified)
Dosya bulunamadi: veri.txt (The system cannot find the file specified)
Onlemesiz: java.lang.ArithmeticException: / by zero
Payda sifir olamaz
rapor hazir
*/
