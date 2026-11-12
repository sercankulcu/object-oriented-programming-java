// Indis Sinir Disi Hatasi: once kontrollu erisim, sonra kontrolsuz erisim.
// Kontrolsuz erisimin firlattigi ArrayIndexOutOfBoundsException yakalanip mesaji yazdirilir.
public class SinirDisi {
	public static void main(String[] args) {
		int[] dizi = {10, 20, 30, 40, 50};
		int index = 5;
		// Dizi uzunlugunu kontrol etme
		if (index >= 0 && index < dizi.length) {
			int deger = dizi[index];
			System.out.println("Deger: " + deger);
		} else {
			System.out.println("Gecersiz indis: " + index);   // Gecersiz indis: 5
		}
		// Kontrolsuz erisim:
		try {
			System.out.println(dizi[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			// java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
		}
	}
}

/* Beklenen cikti:
Gecersiz indis: 5
java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
*/
