import java.util.Scanner;

// Statik analiz (SpotBugs) ornegi: trim() sonucu kullanilmiyor, String == ile karsilastiriliyor.
// Klavye yerine sabit girdi: "evet" yazilsa bile == yuzunden "Reddedildi" cikar.
public class SpotOrnek {
	public static void main(String[] args) {
		Scanner sc = new Scanner("evet\n");   // sunumda: new Scanner(System.in)
		String cevap = sc.nextLine();
		// sonuc kullanilmiyor:
		cevap.trim();
		// String == ile karsilastiriliyor:
		if (cevap == "evet") {
			System.out.println("Onaylandi");
		} else {
			System.out.println("Reddedildi");   // Reddedildi
		}
	}
}
