// finally izleme: return'den once bile finally blogu calisir;
// hata olunca catch'in donus degeri kullanilir.
public class FinallyIzleme {
	static int bol(int a, int b) {
		try {
			System.out.println("try basladi");
			int s = a / b;
			System.out.println("try bitti");
			return s;
		} catch (ArithmeticException e) {
			System.out.println("catch: " + e.getMessage());
			return -1;
		} finally {
			System.out.println("finally");
		}
	}
	public static void main(String[] args) {
		System.out.println("Sonuc = " + bol(10, 2));   // try basladi, try bitti, finally, Sonuc = 5
		System.out.println("Sonuc = " + bol(10, 0));   // try basladi, catch: / by zero, finally, Sonuc = -1
	}
}
