// Yakalanmayan istisna: 10 / 0 ArithmeticException firlatir, sonraki satirlar
// calismaz. Program 0 ile bitsin diye govde calistir() icinde, main onu yakalar
// ve JVM'in yazacagi raporu (istisna + yigin izi) kendisi yazar.
public class Cokus {
	static void calistir() {
		int pay = 10, payda = 0;
		System.out.println("Basla");
		int sonuc = pay / payda;
		System.out.println("Sonuc: " + sonuc);
		System.out.println("Bitti");
	}

	public static void main(String[] args) {
		try {
			calistir();   // Basla
		} catch (ArithmeticException e) {
			System.out.print("Exception in thread main ");
			e.printStackTrace(System.out);   // java.lang.ArithmeticException: / by zero  at Cokus.calistir(...)
		}
	}
}

/* Beklenen cikti:
Basla
Exception in thread main java.lang.ArithmeticException: / by zero
	at Cokus.calistir(Cokus.java:8)
	at Cokus.main(Cokus.java:15)
*/
