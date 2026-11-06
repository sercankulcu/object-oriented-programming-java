// Basarisiz test ornegi: enBuyuk'un ilk surumu enb = 0 ile baslar,
// bu yuzden butun elemanlari negatif olan dizide yanlis sonuc verir.
// Duzeltilmis surum: DiziIslemDuzeltme.java
public class DiziIslem {
	public static int enBuyuk(int[] dizi) {
		int enb = 0;
		for (int i = 0; i < dizi.length; i++) {
			if (dizi[i] > enb) {
				enb = dizi[i];
			}
		}
		return enb;
	}

	public static void main(String[] args) {
		System.out.println(enBuyuk(new int[] {3, 9, 4}));      // 9
		System.out.println(enBuyuk(new int[] {-5, -2, -8}));   // 0 (hatali, -2 olmali)
	}
}
