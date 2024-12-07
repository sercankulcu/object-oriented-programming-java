package ifcondition; 
import java.util.Scanner;

public class MutlakDeger {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Kullanicidan bir sayi girmesini iste
		System.out.print("Bir sayi girin: ");
		double sayi = scanner.nextDouble();

		double mutlakDeger;

		// Sayinin negatif olup olmadigini kontrol et
		if (sayi < 0) {
			// Eger sayi negatifse, isareti degistir
			mutlakDeger = -sayi;
		} else {
			// Sayi pozitifse, oldugu gibi sayiyi al
			mutlakDeger = sayi;
		}

		// Sonuc olarak sayinin mutlak degerini ekrana yazdir
		System.out.println("Girdiginiz sayinin mutlak degeri: " + mutlakDeger);

		// Scanner nesnesini kapat
		scanner.close();
	}
}
