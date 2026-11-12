import java.util.Scanner;

// Fibonacci: ilk n terimi yazar; sozde kodun Java karsiligi (n = 5).
public class Fibonacci {
	public static void main(String[] args) {
		Scanner tarayici = new Scanner("5");
		// Kac terim istendigini gir
		int n = tarayici.nextInt();
		// Ilk iki Fibonacci sayisini baslat
		int a = 0;
		int b = 1;
		if (n >= 1) System.out.print(a + " ");
		if (n >= 2) System.out.print(b + " ");
		// Kalan terimleri hesapla: i = 2'den n - 1'e kadar
		for (int i = 2; i <= n - 1; i++) {
			int sonuc = a + b;
			a = b;
			b = sonuc;
			System.out.print(sonuc + " ");
		}
		System.out.println();  // 0 1 1 2 3
		tarayici.close();
	}
}

/* Beklenen cikti:
0 1 1 2 3
*/
