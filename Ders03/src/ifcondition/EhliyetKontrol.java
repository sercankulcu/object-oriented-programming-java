package ifcondition; 
import java.util.Scanner;

public class EhliyetKontrol {
	
	public static void main(String[] args) {
		
		Scanner klavye = new Scanner(System.in);

		// Kullaniciya yasini sor
		System.out.print("Yasinizi girin: ");
		int yas = klavye.nextInt();

		// Eger yas 18 veya daha buyukse ehliyet alabilir
		if (yas >= 18) {
			System.out.println("Ehliyet alabilirsiniz.");
		} else {
			// Yas 18'den kucukse ehliyet alamaz
			System.out.println("Ehliyet alamazsiniz.");
		}

		// Scanner nesnesini kapat
		klavye.close();
	}
}
