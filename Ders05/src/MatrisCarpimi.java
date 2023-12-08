// Java'da matris çarpımını gerçekleştiren program

public class MatrisCarpimi {

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

		// Çarpım sonucunu tutacak matrisi tanımla
		int satir1 = matris1.length;
		int sutun1 = matris1[0].length;
		int sutun2 = matris2[0].length;
		int[][] carpimSonucu = new int[satir1][sutun2];

		// Matris çarpımını gerçekleştir
		for (int i = 0; i < satir1; i++) {
			for (int j = 0; j < sutun2; j++) {
				for (int k = 0; k < sutun1; k++) {
					carpimSonucu[i][j] += matris1[i][k] * matris2[k][j];
				}
			}
		}

		// Çarpım sonucunu ekrana yazdır
		System.out.println("Matris Çarpım Sonucu:");
		for (int i = 0; i < satir1; i++) {
			for (int j = 0; j < sutun2; j++) {
				System.out.print(carpimSonucu[i][j] + " ");
			}
			System.out.println();
		}
	}
}
