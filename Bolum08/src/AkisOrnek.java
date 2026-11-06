import java.util.Scanner;

// Ilk ornek: giris akisindan (System.in) okuma, cikis (System.out) ve hata (System.err) akisina yazma.
// Klavye yerine sabit girdi kullanilir: kullanici "42" yazmis gibi.
public class AkisOrnek {
	public static void main(String[] args) {
		// Giris akisindan veri okuma
		Scanner scanner = new Scanner("42\n");   // sunumda: new Scanner(System.in)
		int kullaniciGirdisi = scanner.nextInt();
		// Cikis akisina veri yazma
		System.out.println("Merhaba, Dunya!");                        // Merhaba, Dunya!
		System.out.println("Girdiginiz sayi: " + kullaniciGirdisi);  // Girdiginiz sayi: 42
		System.err.println("Bu satir hata akisina yazildi.");        // Bu satir hata akisina yazildi.
	}
}
