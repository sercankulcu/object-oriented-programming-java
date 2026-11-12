// Fonksiyon Icinde Fonksiyon: ikiKareToplami, kareAl ve topla metotlarini cagirir.
// Cagri yigini: main -> ikiKareToplami -> kareAl(3), kareAl(4) -> topla(9, 16).
public class IcIce {
	public static int kareAl(int sayi) {
		return sayi * sayi;
	}
	public static int topla(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}
	public static int ikiKareToplami(int sayi1, int sayi2) {
		return topla(kareAl(sayi1), kareAl(sayi2));
	}
	public static void main(String[] args) {
		int sonuc = ikiKareToplami(3, 4);
		System.out.println(sonuc);                // 25
	}
}

/* Beklenen cikti:
25
*/
