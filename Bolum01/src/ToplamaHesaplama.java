import java.util.Scanner;

// ToplamaHesaplama: iki ondalik sayiyi okuyup toplar.
// Klavye yerine sabit girdi "3 5" okunur; girdi ekrana yansimaz.
public class ToplamaHesaplama {
	public static void main(String[] args) {
		Scanner tarayici = new Scanner("3 5");
		System.out.print("Birinci sayiyi giriniz: ");
		double sayi1 = tarayici.nextDouble();
		System.out.print("Ikinci sayiyi giriniz: ");
		double sayi2 = tarayici.nextDouble();
		double toplam = sayi1 + sayi2;
		System.out.println(sayi1 + " ile " + sayi2
				+ " toplami: " + toplam);               // Birinci sayiyi giriniz: Ikinci sayiyi giriniz: 3.0 ile 5.0 toplami: 8.0 (sunumda 3 ve 5 klavyeden yansir)
		tarayici.close();
	}
}
