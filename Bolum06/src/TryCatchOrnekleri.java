// try-catch-finally yapilari: tek catch, coklu catch, hangi catch'in
// calistigi, | ile coklu yakalama, finally ve ic ice try iskeletleri.
public class TryCatchOrnekleri {

	// try ve catch Deyimleri
	static void tryVeCatch() {
		try {
			// Potansiyel hata iceren kodlar
			int sonuc = 10 / 0; // Hata: ArithmeticException
		} catch (ArithmeticException e) {
			// Hata durumuyla basa cikma
			System.out.println("hata olustu: " + e.getMessage());   // hata olustu: / by zero
		}
	}

	// Coklu catch Blogu (iskelet)
	static void cokluCatch() {
		try {
			// Potansiyel hata iceren kodlar
		} catch (ArithmeticException e) {
			// ArithmeticException ile basa cikma
		} catch (NullPointerException e) {
			// NullPointerException ile basa cikma
		} catch (Exception e) {
			// Diger hata turleri icin genel durum
		}
	}

	// Hangi catch Calisir?
	static void bol(String[] girdi) {
		try {
			int x = Integer.parseInt(girdi[0]);
			int y = Integer.parseInt(girdi[1]);
			System.out.println("Sonuc: " + (x / y));
		} catch (NumberFormatException e) {
			System.out.println("Sayi degil: " + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("Sifir: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Eksik: " + e.getMessage());
		} finally {
			System.out.println("finally calisti");
		}
	}

	// Coklu Yakalama: |
	static void cokluYakalama() {
		try {
			Object o = "Merhaba";
			Integer i = (Integer) o;
		} catch (ClassCastException
				| NullPointerException e) {
			System.out.println("Tur veya null hatasi: "
				+ e.getClass().getSimpleName());   // Tur veya null hatasi: ClassCastException
		}
		// } catch (FileNotFoundException
		//     | IOException e) {
		// derleme hatasi: Alternatives in a multi-catch statement cannot be related
		// by subclassing (FileNotFoundException, IOException'in alt sinifidir).
		// Duzeltme: yalnizca ust sinifi yakala -> catch (IOException e)
	}

	// finally Blogu (iskelet)
	static void finallyBlogu() {
		try {
			// Potansiyel hata iceren kodlar
		} catch (Exception e) {
			// Diger hata turleri icin genel durum
		} finally {
			// Her durumda calistirilacak kodlar
		}
	}

	// Ic Ice try Bloklari (iskelet)
	static void icIceTry() {
		try {
			// Distaki try blogu
			try {
				// Icteki try blogu
				// Potansiyel hata iceren kodlar
			} catch (Exception e) {
				// Icteki catch blogu
			} finally {
				// Icteki finally blogu
			}
		} catch (Exception e) {
			// Distaki catch blogu
		} finally {
			// Distaki finally blogu
		}
	}

	public static void main(String[] args) {
		tryVeCatch();
		cokluCatch();
		bol(new String[] {"10", "abc"});   // Sayi degil: For input string: "abc"   finally calisti
		bol(new String[] {"10", "0"});     // Sifir: / by zero   finally calisti
		bol(new String[] {"10"});          // Eksik: Index 1 out of bounds for length 1   finally calisti
		cokluYakalama();
		finallyBlogu();
		icIceTry();
	}
}

/* Beklenen cikti:
hata olustu: / by zero
Sayi degil: For input string: "abc"
finally calisti
Sifir: / by zero
finally calisti
Eksik: Index 1 out of bounds for length 1
finally calisti
Tur veya null hatasi: ClassCastException
*/
