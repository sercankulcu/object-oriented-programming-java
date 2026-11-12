// Istisna nesnesi: getMessage, toString, getClass().getSimpleName()
// ve printStackTrace ile yigin izi (System.err'e yazar).
public class IstisnaNesnesi {
	public static void main(String[] args) {
		try {
			int[] dizi = new int[3];
			dizi[5] = 7;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());                  // Index 5 out of bounds for length 3
			System.out.println(e);                               // java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
			System.out.println(e.getClass().getSimpleName());    // ArrayIndexOutOfBoundsException
			e.printStackTrace();                                 // ayni satir + "at IstisnaNesnesi.main(IstisnaNesnesi.java:7)"
		}
	}
}

/* Beklenen cikti:
Index 5 out of bounds for length 3
java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
ArrayIndexOutOfBoundsException
java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
	at IstisnaNesnesi.main(IstisnaNesnesi.java:7)
*/
