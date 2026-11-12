import java.util.Scanner;

// Faktoriyel: sozde koddaki dongulu hesabin Java karsiligi (sayi = 5).
public class Faktoriyel {
	public static void main(String[] args) {
		Scanner tarayici = new Scanner("5");
		// Bir sayiyi gir
		int sayi = tarayici.nextInt();
		// Sonucu saklamak icin bir degiskeni baslat
		long faktoriyel = 1;
		// Faktoriyel hesabi icin dongu
		for (int i = 1; i <= sayi; i++) {
			faktoriyel = faktoriyel * i;
		}
		System.out.println("Girilen sayinin faktoriyeli: " + faktoriyel);  // Girilen sayinin faktoriyeli: 120
		tarayici.close();
	}
}

/* Beklenen cikti:
Girilen sayinin faktoriyeli: 120
*/
