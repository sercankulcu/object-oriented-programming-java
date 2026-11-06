// Yayilim izleme: bol'de olusan istisna hesapla'yi da yarida keser ve
// main'deki catch'e kadar yigin boyunca yukari tasinir.
public class Yayilim {
	static int bol(int a, int b) {
		System.out.println("bol basladi");
		int s = a / b;
		System.out.println("bol bitti");
		return s;
	}
	static int hesapla(int x) {
		System.out.println("hesapla basladi");
		int r = bol(x, 0);
		System.out.println("hesapla bitti");
		return r;
	}
	public static void main(String[] args) {
		try {
			int sonuc = hesapla(10);                   // hesapla basladi, bol basladi
			System.out.println("Sonuc: " + sonuc);
		} catch (ArithmeticException e) {
			System.out.println("main: " + e.getMessage()); // main: / by zero
		}
		System.out.println("Program bitti");           // Program bitti
	}
}
