import java.util.Scanner;

// Iki Tam Sayi: sozde koddaki siralama algoritmasinin Java karsiligi.
// Sunumdaki iki izleme girdisiyle (4 11 ve 13 11) calisir.
public class IkiTamSayi {

	// Basla ... Bitir
	static void calistir(Scanner tarayici) {
		System.out.print("Birinci tamsayiyi girin: ");
		int birinciTamsayi = tarayici.nextInt();
		System.out.print("Ikinci tamsayiyi girin: ");
		int ikinciTamsayi = tarayici.nextInt();
		if (birinciTamsayi < ikinciTamsayi) {
			System.out.println(birinciTamsayi + " " + ikinciTamsayi);
		} else {
			System.out.println(ikinciTamsayi + " " + birinciTamsayi);
		}
	}

	public static void main(String[] args) {
		calistir(new Scanner("4 11"));   // Birinci tamsayiyi girin: Ikinci tamsayiyi girin: 4 11
		calistir(new Scanner("13 11"));  // Birinci tamsayiyi girin: Ikinci tamsayiyi girin: 11 13
	}
}
