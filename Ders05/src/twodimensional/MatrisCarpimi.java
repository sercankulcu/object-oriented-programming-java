// Java'da matris carpimini gerceklestiren program
package twodimensional;

public class MatrisCarpimi {

    public static void main(String[] args) {
        // Ilk matrisi tanimla ve degerlerini ata
        int[][] matris1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Ikinci matrisi tanimla ve degerlerini ata
        int[][] matris2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        // Carpim sonucunu tutacak matrisi tanimla
        int satir1 = matris1.length;  // Birinci matrisin satir sayisi
        int sutun1 = matris1[0].length;  // Birinci matrisin sutun sayisi
        int sutun2 = matris2[0].length;  // Ikinci matrisin sutun sayisi
        int[][] carpimSonucu = new int[satir1][sutun2];  // Carpim sonucu matrisini tanimla

        // Matris carpimini gerceklestir
        for (int i = 0; i < satir1; i++) {
            for (int j = 0; j < sutun2; j++) {
                for (int k = 0; k < sutun1; k++) {
                    carpimSonucu[i][j] += matris1[i][k] * matris2[k][j];  // Carpim islemi
                }
            }
        }

        // Carpim sonucunu ekrana yazdir
        System.out.println("Matris Carpim Sonucu:");
        for (int i = 0; i < satir1; i++) {
            for (int j = 0; j < sutun2; j++) {
                System.out.print(carpimSonucu[i][j] + " ");  // Matris elemanlarini yazdir
            }
            System.out.println();  // Satir sonu
        }
    }
}
