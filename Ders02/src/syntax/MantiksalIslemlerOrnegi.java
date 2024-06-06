package syntax;

public class MantiksalIslemlerOrnegi {

	public static void main(String[] args) {

		boolean dogru = true;
		boolean yanlis = false;

		// "VE" Mantıksal Operatörü (&&)
		boolean veSonuc = dogru && yanlis;
		System.out.println("VE Mantıksal Operatörü (&&): " + veSonuc); // false

		// "VEYA" Mantıksal Operatörü (||)
		boolean veyaSonuc = dogru || yanlis;
		System.out.println("VEYA Mantıksal Operatörü (||): " + veyaSonuc); // true

		// "DEĞİL" Mantıksal Operatörü (!)
		boolean degilSonuc = !dogru;
		System.out.println("DEĞİL Mantıksal Operatörü (!): " + degilSonuc); // false

		// Karmaşık mantıksal ifadeler
		boolean karmaSonuc = (dogru && yanlis) || (dogru || !yanlis);
		System.out.println("Karmaşık Mantıksal İfade: " + karmaSonuc); // true
	}
}
