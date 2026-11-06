// Ornek: CokBoyutluDiziOrnegi. 3x3 matrisi ic ice donguyle doldurur ve yazdirir.
public class CokBoyutluDiziOrnegi {
	public static void main(String[] args) {
		// 3x3 boyutunda iki boyutlu bir dizi (matris)
		int[][] matris = new int[3][3];
		// Matrisin elemanlarina ilk degerlerini atama
		for (int satir = 0; satir < 3; satir++) {
			for (int sutun = 0; sutun < 3; sutun++) {
				matris[satir][sutun] = satir * 3 + sutun + 1;
			}
		}
		// Matrisi ekrana yazdirma
		System.out.println("Matrisin Icerigi:");
		for (int satir = 0; satir < 3; satir++) {
			for (int sutun = 0; sutun < 3; sutun++) {
				System.out.print(matris[satir][sutun] + " ");
			}
			System.out.println(); // Yeni satira gecme
		}
		// Matrisin Icerigi:
		// 1 2 3
		// 4 5 6
		// 7 8 9
	}
}
