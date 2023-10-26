import java.util.Scanner;

public class PalindromKontrol {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir kelime veya cümle girin: ");
		String metin = scanner.nextLine();

		scanner.close();

		// Metni temizleme: Boşlukları, noktalama işaretlerini ve büyük harf küçük harfe dönüştürme
		metin = metin.replaceAll("[^a-zA-Z]", "").toLowerCase();

		// Metni ters çevirme
		String tersMetin = new StringBuilder(metin).reverse().toString();

		// Palindrom kontrolü
		if (metin.equals(tersMetin)) {
			System.out.println("Girdi bir palindromdur.");
		} else {
			System.out.println("Girdi bir palindrom değildir.");
		}
	}
}
