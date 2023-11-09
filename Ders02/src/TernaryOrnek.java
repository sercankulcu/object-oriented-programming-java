
public class TernaryOrnek {

	public static void main(String[] args) {

		int sayi = 10;

		// Basit bir üçlü operatör örneği
		String sonuc = (sayi > 5) ? "Büyük" : "Küçük";
		System.out.println("Sayı Büyük mü? " + sonuc); // Sayı Büyük mü? Büyük

		// İç içe geçmiş üçlü operatörlerin kullanımı
		String derece = (sayi > 25) ? "Sıcak" : (sayi > 15) ? "Ilık" : "Soğuk";
		System.out.println("Hava Durumu: " + derece); // Hava Durumu: Ilık
	}
}
