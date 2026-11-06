// Matris Transpozu: 2x3 matrisin satirlari 3x2 matrisin sutunlari olur, T[j][i] = M[i][j].
public class MatrisTranspozu {
	public static void main(String[] args) {
		int[][] matris = {
			{1, 2, 3},
			{4, 5, 6}
		};
		System.out.println("Orijinal Matris:");
		yazdirMatris(matris);                     // 1 2 3 / 4 5 6
		int satirSayisi = matris.length;
		int sutunSayisi = matris[0].length;
		int[][] transpozMatris = new int[sutunSayisi][satirSayisi];
		for (int i = 0; i < satirSayisi; i++) {
			for (int j = 0; j < sutunSayisi; j++) {
				transpozMatris[j][i] = matris[i][j];
			}
		}
		System.out.println("Transpoz Matris:");
		yazdirMatris(transpozMatris);             // 1 4 / 2 5 / 3 6
	}

	// Yardimci Metot: yazdirMatris
	public static void yazdirMatris(int[][] matris) {
		for (int i = 0; i < matris.length; i++) {
			for (int j = 0; j < matris[i].length; j++) {
				System.out.print(matris[i][j] + " ");
			}
			System.out.println();
		}
	}
}
