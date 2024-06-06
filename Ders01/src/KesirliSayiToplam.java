import java.util.Scanner;

public class KesirliSayiToplam {

	public static void main(String[] args) {

		// Kullanıcı girdisini okumak için bir Scanner nesnesi oluşturun
		Scanner tarayici = new Scanner(System.in);
		// Kullanıcıdan sayıyı girmesini isteyin
		System.out.println("Birinci sayıyı giriniz: ");
		double sayi1 = tarayici.nextDouble();
		System.out.println("İkinci sayıyı giriniz: ");
		double sayi2 = tarayici.nextDouble();
		// İki sayının toplamını hesaplayın
		double toplam = sayi1 + sayi2;
		// Sonucu görüntüleyin
		System.out.println(sayi1 + " ile " + sayi2 + " toplamı: " + toplam);
		// Tarayıcıyı kapatın
		tarayici.close();
	}
}