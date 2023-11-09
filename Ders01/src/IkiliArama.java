import java.util.Scanner;

public class IkiliArama {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Sıralı bir dizi oluştur
		int[] siraliDizi = {5, 10, 15, 20, 25, 30, 35, 40};

		System.out.print("Aranacak değeri girin: ");
		int aranan = scanner.nextInt();

		int sonuc = ikiliArama(siraliDizi, aranan);

		if (sonuc == -1) {
			System.out.println("Değer bulunamadı.");
		} else {
			System.out.println("Değer bulundu! İndis: " + sonuc);
		}

		scanner.close();
	}

	public static int ikiliArama(int[] dizi, int aranan) {
		int sol = 0;
		int sag = dizi.length - 1;

		while (sol <= sag) {
			int orta = sol + (sag - sol) / 2;

			if (dizi[orta] == aranan) {
				return orta;
			}

			if (dizi[orta] < aranan) {
				sol = orta + 1;
			} else {
				sag = orta - 1;
			}
		}

		return -1;
	}
}
