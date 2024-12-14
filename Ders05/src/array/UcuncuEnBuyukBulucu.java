package array;
import java.util.Arrays;

public class UcuncuEnBuyukBulucu {

	// Diziyi artan siraya gore sirala ve ucuncu en buyugu bul
	public static int ucuncuEnBuyuguBul(int[] dizi) {

		// Diziyi artan siraya gore sirala
		Arrays.sort(dizi);
		// Ucuncu en buyuk elemani dondur
		return dizi[dizi.length - 3];
	}

	// Diziyi teker teker kontrol ederek ucuncu en buyugu bul
	public static int ucuncuEnBuyuguBulVanilla(int[] dizi) {
		// En buyuk, ikinci en buyuk ve ucuncu en buyuk degerleri icin degiskenler olustur
		int birinciEnBuyuk = Integer.MIN_VALUE;
		int ikinciEnBuyuk = Integer.MIN_VALUE;
		int ucuncuEnBuyuk = Integer.MIN_VALUE;

		// Diziyi dolasarak en buyuk degerleri guncelle
		for (int eleman : dizi) {
			if (eleman > birinciEnBuyuk) {
				ucuncuEnBuyuk = ikinciEnBuyuk;
				ikinciEnBuyuk = birinciEnBuyuk;
				birinciEnBuyuk = eleman;
			} else if (eleman > ikinciEnBuyuk) {
				ucuncuEnBuyuk = ikinciEnBuyuk;
				ikinciEnBuyuk = eleman;
			} else if (eleman > ucuncuEnBuyuk) {
				ucuncuEnBuyuk = eleman;
			}
		}
		// Ucuncu en buyuk degeri dondur
		return ucuncuEnBuyuk;
	}

	public static void main(String[] args) {

		int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3, 14};

		System.out.println(Arrays.toString(dizi));
		// Ucuncu en buyugu bul ve yazdir
		int ucuncuEnBuyuk = ucuncuEnBuyuguBul(dizi);
		System.out.println("3. buyuk sayi: " + ucuncuEnBuyuk);

		System.out.println(Arrays.toString(dizi));
		// Vanilla yontemiyle ucuncu en buyugu bul ve yazdir
		ucuncuEnBuyuk = ucuncuEnBuyuguBulVanilla(dizi);
		System.out.println("3. buyuk sayi: " + ucuncuEnBuyuk);
	}
}
