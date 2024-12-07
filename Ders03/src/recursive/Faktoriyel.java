package recursive; 
import java.util.Scanner;

public class Faktoriyel {

	// Rekursif olarak faktoriyel hesaplayan metod
	public static int recursiveFaktoriyel(int sayi) {
		int sonuc = 0; // Baslangic degeri
		// Eger sayi 0 ise, faktoriyel 1 olarak kabul edilir
		if (sayi == sonuc) {
			return sonuc + 1;
		}
		// Aksi takdirde, ozyinelemeli olarak sayi * (sayi-1)'in faktoriyeli hesaplanir
		return sayi * recursiveFaktoriyel(sayi - 1);
	}

	// Dongu ile faktoriyel hesaplayan metod
	public static int iterativeFaktoriyel(int sayi) {
		int sonuc = 1; // Sonuc 1 olarak alinir

		// 1'den sayiya kadar olan sayilari carpip faktoriyel hesaplanir
		for (int i = 1; i <= sayi; i++) {
			sonuc *= i;
		}
		return sonuc;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Faktoriyelini hesaplamak icin bir sayi girin: ");
		int sayi = sc.nextInt();
		sc.close();

		// Sonucu ekrana yazdir
		System.out.println(sayi + " sayisinin faktoriyeli (iterative): " + iterativeFaktoriyel(sayi));
		System.out.println(sayi + " sayisinin faktoriyeli (rekursive): " + recursiveFaktoriyel(sayi));
	}
}
