// Kod kapsami ornegi: IsaretTest yalnizca pozitif ve negatif dali sinar,
// "sifir" dali hic calismaz (kapsam araci bu satiri kirmizi gosterir).
public class Isaret {
	public static String isaret(int x) {
		if (x > 0) {
			return "pozitif";
		} else if (x < 0) {
			return "negatif";
		}
		return "sifir";
	}

	public static void main(String[] args) {
		System.out.println(isaret(5));    // pozitif
		System.out.println(isaret(-3));   // negatif
		System.out.println(isaret(0));    // sifir
	}
}
