import java.util.Scanner;

/*
 * Bu program, verilen bir para miktarini olusturmak icin gereken minimum sayida 
 * bozuk para miktarini hesaplar:
 */

public class ParaBozma {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Kullanıcıdan bozuk para miktarini girmesi istenir
		System.out.print("Bozuk para miktarini giriniz: ");
		double para = sc.nextDouble();
		sc.close();

		para += 0.001; // Double hassasiyet hatalarini onlemek icin 1,2999999999 != 1,3

		// Her bir bozuk para turunden kac adet gerektigini hesaplama
		int yirmiBesKurus = (int) (para / 0.25); // 25 kurus
		para = para % 0.25;
		int onKurus = (int) (para / 0.1); // 10 kurus
		para = para % 0.1;
		int besKurus = (int) (para / 0.05); // 5 kurus
		para = para % 0.05;
		int birKurus = (int) (para / 0.01); // 1 kurus

		// Sonuclari yazdirma
		System.out.println("25 Kurus: " + yirmiBesKurus + " tane.");
		System.out.println("10 Kurus: " + onKurus + " tane.");
		System.out.println("5  Kurus: " + besKurus + " tane.");
		System.out.println("1  Kurus: " + birKurus + " tane.");
	}
}
