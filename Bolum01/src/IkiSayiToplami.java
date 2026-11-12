import java.util.Scanner;

// Toplam akis diyagraminin Java karsiligi: sirali akis (oku, hesapla, yaz).
// Klavye yerine sunumdaki girdi "7 5" okunur.
public class IkiSayiToplami {
	public static void main(String[] args) {
		Scanner giris = new Scanner("7 5");
		System.out.print("Ilk sayi: ");
		int sayi1 = giris.nextInt();
		System.out.print("Ikinci sayi: ");
		int sayi2 = giris.nextInt();
		int sonuc = sayi1 + sayi2;
		System.out.println("Sonuc: " + sonuc);  // Ilk sayi: Ikinci sayi: Sonuc: 12 (sunumda 7 ve 5 klavyeden yansir)
		giris.close();
	}
}

/* Beklenen cikti:
Ilk sayi: Ikinci sayi: Sonuc: 12
*/
