import java.util.Scanner;

// Scanner ile dizgi okuma: next bosluga kadar, nextLine satir sonuna kadar okur.
// nextInt satir sonunu birakir; ardindan gelen nextLine bos dizgi dondurur.
// Girdiler klavye yerine sabit dizgilerden okunur.
public class DizgiGirdi {

	// Scanner ile Dizgi Okuma / next ve nextLine: Adim Adim
	static void nextVeNextLine(String girdiSatiri) {
		Scanner klavye = new Scanner(girdiSatiri);
		System.out.println("bir metin giriniz");
		String girdi = klavye.next();
		System.out.println(girdi);    // bilgisayar
		girdi = klavye.next();
		System.out.println(girdi);    // ve
		girdi = klavye.nextLine();
		System.out.println(girdi);    //  programlamaya giris
		klavye.close();
	}

	// nextInt ve nextLine Tuzagi
	static void tuzak(String girdiler) {
		Scanner klavye = new Scanner(girdiler);
		System.out.print("Ya\u015f: ");
		int yas = klavye.nextInt();
		System.out.print("Ad: ");
		String ad = klavye.nextLine();
		System.out.println("[" + ad + "] " + yas);             // Yas: Ad: [] 19
		klavye.close();
	}

	// Tuzagin cozumu: nextInt'ten sonra satir sonunu at
	static void tuzakCozumu(String girdiler) {
		Scanner klavye = new Scanner(girdiler);
		System.out.print("Ya\u015f: ");
		int yas = klavye.nextInt();
		klavye.nextLine();          // satir sonunu at
		System.out.print("Ad: ");
		String ad = klavye.nextLine();
		System.out.println("[" + ad + "] " + yas);             // Yas: Ad: [Ayse] 19
		klavye.close();
	}

	public static void main(String[] args) {
		nextVeNextLine("bilgisayar ve programlamaya giri\u015f");
		// bir metin giriniz
		// bilgisayar
		// ve
		//  programlamaya giris
		tuzak("19\nAy\u015fe\n");
		tuzakCozumu("19\nAy\u015fe\n");
	}
}

/* Beklenen cikti:
bir metin giriniz
bilgisayar
ve
 programlamaya giriş
Yaş: Ad: [] 19
Yaş: Ad: [Ayşe] 19
*/
