// Java'da matris toplamini gerceklestiren program
package twodimensional;

public class MatrisToplami {

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

        // Matris toplamini tutacak matrisi tanimla
        int satir = matris1.length;  // Matristeki satir sayisi
        int sutun = matris1[0].length;  // Matristeki sutun sayisi
        int[][] toplamMatrisi = new int[satir][sutun];  // Toplam matrisini tanimla

        // Matris toplamini gerceklestir
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                toplamMatrisi[i][j] = matris1[i][j] + matris2[i][j];  // Her iki matristeki elemanlari topla
            }
        }

        // Toplam matrisini ekrana yazdir
        System.out.println("Matris Toplami:");
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print(toplamMatrisi[i][j] + " ");  // Matris elemanlarini yazdir
            }
            System.out.println();  // Satir sonu
        }
    }
}
