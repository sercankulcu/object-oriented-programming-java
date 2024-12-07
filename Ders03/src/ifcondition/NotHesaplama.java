package ifcondition; 
import java.util.Scanner;

public class NotHesaplama {

	// 'harfNotunaCevir' metodu, girilen sayisal notu harf notuna cevirir
	public static void harfNotunaCevir(int not) {
		// Not 90 veya daha yuksekse 'A' harf notu verilir
		if (not >= 90) {
			System.out.println("A");
		} 
		// Not 80 veya daha yuksekse 'B' harf notu verilir
		else if (not >= 80) {
			System.out.println("B");
		} 
		// Not 70 veya daha yuksekse 'C' harf notu verilir
		else if (not >= 70) {
			System.out.println("C");
		} 
		// Not 60 veya daha yuksekse 'D' harf notu verilir
		else if (not >= 60) {
			System.out.println("D");
		} 
		// Diger durumlar icin 'F' harf notu verilir
		else {
			System.out.println("F");
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		// Kullaniciya notunu girmesini iste
		System.out.print("Notunuzu girin: ");
		int not = scanner.nextInt();

		// 'harfNotunaCevir' metodu ile sayisal not harf notuna cevir
		harfNotunaCevir(not);

		// Scanner nesnesi kapat
		scanner.close();
	}
}
