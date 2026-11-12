import java.util.Scanner;

// do-while: Girdi Dogrulama. Gecerli sayi gelene kadar yeniden sorar.
// Girdiler (15 0 7) klavye yerine sabit dizgiden okunur.
public class DoWhileGirdi {
	public static void main(String[] args) {
		Scanner klavye = new Scanner("15 0 7");
		int sayi;
		do {
			System.out.print("1-10 arasi bir sayi girin: ");
			sayi = klavye.nextInt();
		} while (sayi < 1 || sayi > 10);
		System.out.println("Kabul edilen sayi: " + sayi);
		// 1-10 arasi bir sayi girin: (uc kez) Kabul edilen sayi: 7
		klavye.close();
	}
}

/* Beklenen cikti:
1-10 arasi bir sayi girin: 1-10 arasi bir sayi girin: 1-10 arasi bir sayi girin: Kabul edilen sayi: 7
*/
