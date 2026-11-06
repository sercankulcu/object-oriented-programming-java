import java.util.Scanner;

// Us Alma: tabani us kez carparak kuvvet hesaplar (taban = 3, us = 4).
public class UsAlma {
	public static void main(String[] args) {
		Scanner tarayici = new Scanner("3 4");
		// Bir sayiyi gir
		int taban = tarayici.nextInt();
		// Bir ussu gir
		int us = tarayici.nextInt();
		// Sonucu saklamak icin bir degiskeni baslat
		int sonuc = 1;
		// Ussu kullanarak sonucu hesapla
		for (int i = 1; i <= us; i++) {
			sonuc = sonuc * taban;
		}
		System.out.println("Sonuc: " + sonuc);  // Sonuc: 81
		tarayici.close();
	}
}
