
public class IsimlendirilmisSabitlerOrnegi {
	
	public static void main(String[] args) {
		// İsimlendirilmiş sabitleri kullanarak matematiksel bir işlem yapalım
		final double PI = 3.14159; // PI sabiti tanımlandı ve değeri atandı
		final int YARICAP = 5; // Yarıçap sabiti tanımlandı ve değeri atandı

		// Dairenin alanını hesaplayalım
		double alan = PI * YARICAP * YARICAP;
		System.out.println("Dairenin Alanı: " + alan);

		// İsimlendirilmiş sabitlerin değerleri değiştirilemez
		// PI = 3.14; // Hata! Sabit değeri değiştirilemez

		// İsimlendirilmiş sabitlerin kullanılması, kodun daha okunaklı ve bakımı daha kolay olmasını sağlar
	}
}
