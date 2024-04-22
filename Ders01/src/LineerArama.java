import java.util.Scanner;

public class LineerArama {

	void lineerArama(int[] dizi, int aranan) {
		boolean bulundu = false;
		for (int i = 0; i < dizi.length; i++) {
			if (dizi[i] == aranan) {
				bulundu = true;
				System.out.println("Aranan öğe bulundu: " + i);
			}
		}
		if(bulundu == false) {
			System.out.println("Aranan öğe bulunamadı");
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		// Örnek bir dizi oluştur
		int[] dizi = {5, 10, 15, 20, 25, 30, 35, 40};

		System.out.print("Aranacak değeri girin: ");
		int aranan = scanner.nextInt();
		
		(new LineerArama()).lineerArama(dizi, aranan);

		boolean bulundu = false;

		// Lineer arama
		for (int i = 0; i < dizi.length; i++) {
			if (dizi[i] == aranan) {
				System.out.println("Değer bulundu! İndis: " + i);
				bulundu = true;
				break;
			}
		}

		if (!bulundu) {
			System.out.println("Değer bulunamadı.");
		}

		scanner.close();
	}
}
