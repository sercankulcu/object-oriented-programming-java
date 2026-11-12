// char ve int: karakterler sayisal kodlardir; aritmetikte int'e genisler.
public class CharVeInt {

	// char ve int
	static void charVeInt() {
		char karakter = 'A';
		int kod = karakter;               // 65
		System.out.println(kod);                          // 65
		char sonraki = (char) (kod + 1);
		System.out.println(sonraki);                      // B
		System.out.println('B' + 'C');                    // 133
		System.out.println("" + 'B' + 'C');               // BC
		System.out.println((char) (karakter + 32));       // a
		System.out.println((int) '\u015F');               // s-cedilla kodu -> 351
	}

	// char ve int: Kod Izleme
	static void charVeIntIzleme() {
		char c = 'd';
		int kod = c;
		char buyuk = (char) (c - 32);
		int fark = 'z' - c;
		char sonraki = c;
		sonraki++;
		System.out.println(kod + " " + buyuk + " " + fark + " " + sonraki);  // 100 D 22 e
		System.out.println(c + 1);       // 101
		System.out.println("" + c + 1);  // d1
	}

	public static void main(String[] args) {
		charVeInt();
		charVeIntIzleme();
	}
}

/* Beklenen cikti:
65
B
133
BC
a
351
100 D 22 e
101
d1
*/
