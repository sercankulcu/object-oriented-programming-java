package ifcondition; 
import java.util.Scanner;

/*
 * Verilen tarihe gore burcunuzu yazdirir: 
 */

public class BurcYazdir {

	public static void main(String[] args) {

		Scanner girdi = new Scanner(System.in);

		// Kullaniciya dogum ayini sor
		System.out.print("Dogum ayinizi girin (1-12): ");
		int ay = girdi.nextInt();
		// Kullaniciya dogum gununu sor
		System.out.print("Dogum gununuzu girin (1-31): ");
		int gun = girdi.nextInt();

		String burc = "";

		// Burc hesaplamalari yapiliyor
		if ((ay == 3 && gun >= 21) || (ay == 4 && gun <= 19)) {
			burc = "Koc";
		} else if ((ay == 4 && gun >= 20) || (ay == 5 && gun <= 20)) {
			burc = "Boga";
		} else if ((ay == 5 && gun >= 21) || (ay == 6 && gun <= 20)) {
			burc = "ikizler";
		} else if ((ay == 6 && gun >= 21) || (ay == 7 && gun <= 22)) {
			burc = "Yengec";
		} else if ((ay == 7 && gun >= 23) || (ay == 8 && gun <= 22)) {
			burc = "Aslan";
		} else if ((ay == 8 && gun >= 23) || (ay == 9 && gun <= 22)) {
			burc = "Basak";
		} else if ((ay == 9 && gun >= 23) || (ay == 10 && gun <= 22)) {
			burc = "Terazi";
		} else if ((ay == 10 && gun >= 23) || (ay == 11 && gun <= 21)) {
			burc = "Akrep";
		} else if ((ay == 11 && gun >= 22) || (ay == 12 && gun <= 21)) {
			burc = "Yay";
		} else if ((ay == 12 && gun >= 22) || (ay == 1 && gun <= 19)) {
			burc = "Oglak";
		} else if ((ay == 1 && gun >= 20) || (ay == 2 && gun <= 18)) {
			burc = "Kova";
		} else if ((ay == 2 && gun >= 19) || (ay == 3 && gun <= 20)) {
			burc = "Balik";
		}

		// Hesaplanan burc ekrana yazdiriliyor
		System.out.println("Burcunuz: " + burc);
	}
}
