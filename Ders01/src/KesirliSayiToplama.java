import java.util.Scanner;

public class KesirliSayiToplama {

	public static void main(String[] args) {

		// Kullanici girdisini okumak için bir Scanner nesnesi oluştur
		Scanner tarayici = new Scanner(System.in);
		// Kullanicidan sayiyi girmesini iste
		System.out.println("Birinci sayiyi giriniz: ");
		double sayi1 = tarayici.nextDouble();
		
		System.out.println("ikinci sayiyi giriniz: ");
		double sayi2 = tarayici.nextDouble();
		
		// iki sayinin toplamini hesapla
		double toplam = sayi1 + sayi2;

		// Sonucu goruntule
		System.out.println(sayi1 + " ile " + sayi2 + " toplami: " + toplam);
		
		tarayici.close();
	}
}