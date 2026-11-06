/* Cok satirli aciklama:
   derleyici bunu yok sayar.
   Temel soz dizimi kurallari: ; ile biten deyimler, buyuk-kucuk harf
   duyarliligi, satir bolme. */
public class Kurallar {
	// Tek satirlik aciklama
	public static void main(String[] args) {
		int sayi = 5;  // ; ile biter
		int Sayi = 7;  // sayi != Sayi
		System.out.println(sayi
				+ Sayi);   // satir bolunebilir -> 12
	}
}
