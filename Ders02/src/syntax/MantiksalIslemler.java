package syntax;

public class MantiksalIslemler {

	public static void main(String[] args) {

		boolean dogru = true;  // dogru degiskeni true olarak tanimlandi
		boolean yanlis = false; // yanlis degiskeni false olarak tanimlandi

		// "VE" Mantiksal Operatoru (&&)
		boolean veSonuc = dogru && yanlis; // dogru VE yanlis operatoru ile karsilastirildi
		System.out.println("VE Mantiksal Operatori (&&): " + veSonuc); // false

		// "VEYA" Mantiksal Operatoru (||)
		boolean veyaSonuc = dogru || yanlis; // dogru VEYA yanlis operatoru ile karsilastirildi
		System.out.println("VEYA Mantiksal Operatori (||): " + veyaSonuc); // true

		// "DEGiL" Mantiksal Operatoru (!)
		boolean degilSonuc = !dogru; // dogru degil ise sonuc alindi
		System.out.println("DEGiL Mantiksal Operatori (!): " + degilSonuc); // false

		// Karmasik mantiksal ifadeler
		boolean karmaSonuc = (dogru && yanlis) || (dogru || !yanlis); // karmasik mantiksal ifade
		System.out.println("Karmasik Mantiksal ifade: " + karmaSonuc); // true
	}
}
