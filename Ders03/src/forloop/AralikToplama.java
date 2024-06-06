package forloop;
import java.util.Scanner;

public class AralikToplama {
	
	public static void aralikTopla(int a, int b) {
		int toplam = 0;
		for (int i = a; i <= b; i++) {
			toplam += i;
		}
		System.out.println(a + " ile " + b + " arasındaki sayıların toplamı: " + toplam);		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Başlangıç değerini girin (a): ");
		int a = scanner.nextInt();

		System.out.print("Bitiş değerini girin (b): ");
		int b = scanner.nextInt();

		aralikTopla(a, b);
		scanner.close();
	}
}
