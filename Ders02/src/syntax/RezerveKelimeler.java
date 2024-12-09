package syntax;

public class RezerveKelimeler {

	public static void main(String[] args) {

		// Rezerve edilmis kelimeler kullanildiginda hata alinir
		//		int new = 5; // "new" kelimesi rezerve edilmistir ve bir degisken adi olarak kullanilamaz
		//		String switch = "Yesil"; // "switch" kelimesi rezerve edilmistir ve bir degisken adi olarak kullanilamaz

		// Asagidaki rezerve edilmis kelimeleri kullanmak hata verir:
		// abstract, assert, boolean, break, byte, case, catch, char, class, const, continue, default,
		// do, double, else, enum, extends, final, finally, float, for, goto, if, implements, import,
		// instanceof, int, interface, long, native, new, package, private, protected, public, return,
		// short, static, strictfp, super, switch, synchronized, this, throw, throws, transient, try,
		// void, volatile, while, true, false, null

		// Bu rezerve edilmis kelimelerin yerine farkli isimlendirmeler kullanilir
		int yeniDeger = 10; // yeniDeger degiskeni tanimlandi ve 10 degeri atandi
		String renk = "Mavi"; // renk degiskeni tanimlandi ve "Mavi" degeri atandi

	}
}
