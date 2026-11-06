// Basarisiz testten sonra duzeltilmis enBuyuk: ilk elemandan baslar.
// Hatali surum DiziIslem.java'da; duzeltilmis surum burada ic sinif olarak durur.
public class DiziIslemDuzeltme {

	static class DiziIslem {
		public static int enBuyuk(int[] dizi) {
			int enb = dizi[0];               // ilk eleman
			for (int i = 1; i < dizi.length; i++) {
				if (dizi[i] > enb) {
					enb = dizi[i];
				}
			}
			return enb;
		}
	}

	public static void main(String[] args) {
		int[] dizi = {-5, -2, -8};
		// ilk surum (DiziIslem.java) burada 0 donduruyordu
		System.out.println("En buyuk: " + DiziIslem.enBuyuk(dizi));               // En buyuk: -2
		System.out.println("En buyuk: " + DiziIslem.enBuyuk(new int[] {3, 9, 4}));   // En buyuk: 9
	}
}
