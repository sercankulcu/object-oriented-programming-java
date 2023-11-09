import java.util.Random;

public class RastgeleDiziArama {

	public static void main(String[] args) {

		// Örnek bir dizi oluştur
		int[] dizi = {5, 10, 15, 20, 25, 30, 35, 40};

		// Rastgele bir indis seç
		Random random = new Random();
		int rastgeleIndis = random.nextInt(dizi.length);

		// Rastgele seçilen indisteki öğeyi ekrana yazdır
		System.out.println("Rastgele Seçilen Öğe: " + dizi[rastgeleIndis]);
	}
}
