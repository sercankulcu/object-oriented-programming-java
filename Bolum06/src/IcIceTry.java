// Ic ice try izleme: ic catch istisnayi yakalayamazsa ic finally calisir,
// istisna distaki catch'e gecer.
public class IcIceTry {
	public static void main(String[] args) {
		try {
			System.out.println("Dis try");              // Dis try
			try {
				System.out.println("Ic try");           // Ic try
				String s = null;
				System.out.println(s.length());
			} catch (ArithmeticException e) {
				System.out.println("Ic catch");
			} finally {
				System.out.println("Ic finally");       // Ic finally
			}
			System.out.println("Dis try devam");
		} catch (NullPointerException e) {
			System.out.println("Dis catch: NPE");       // Dis catch: NPE
		} finally {
			System.out.println("Dis finally");          // Dis finally
		}
		System.out.println("Program suruyor");          // Program suruyor
	}
}

/* Beklenen cikti:
Dis try
Ic try
Ic finally
Dis catch: NPE
Dis finally
Program suruyor
*/
