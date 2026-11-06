// Hata Mesajlarini Okumak: sifira bolme derlenir ama calisirken
// ArithmeticException firlatir. Burada yakalanip mesaji yazdirilir.
public class Bolme {
	public static void main(String[] args) {
		int a = 10, b = 0;
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			// Sunumda: Exception in thread "main" java.lang.ArithmeticException: / by zero
			//              at Bolme.main(Bolme.java:4)
			System.out.println(e);  // java.lang.ArithmeticException: / by zero
		}
	}
}
