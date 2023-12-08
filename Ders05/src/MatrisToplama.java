// Java'da matris toplamını gerçekleştiren program

public class MatrisToplama {

	public static void main(String[] args) {
		// İlk matrisi tanımla ve değerlerini ata
		int[][] matris1 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};

		// İkinci matrisi tanımla ve değerlerini ata
		int[][] matris2 = {
				{9, 8, 7},
				{6, 5, 4},
				{3, 2, 1}
		};

		// Matris toplamını tutacak matrisi tanımla
		int satir = matris1.length;
		int sutun = matris1[0].length;
		int[][] toplamMatrisi = new int[satir][sutun];

		// Matris toplamını gerçekleştir
		for (int i = 0; i < satir; i++) {
			for (int j = 0; j < sutun; j++) {
				toplamMatrisi[i][j] = matris1[i][j] + matris2[i][j];
			}
		}

		// Toplam matrisini ekrana yazdır
		System.out.println("Matris Toplamı:");
		for (int i = 0; i < satir; i++) {
			for (int j = 0; j < sutun; j++) {
				System.out.print(toplamMatrisi[i][j] + " ");
			}
			System.out.println();
		}
	}
}
