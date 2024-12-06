package array;

public class HizliSiralama {

    public static void sirala(int[] dizi, int sol, int sag) {

        // Pivot degeri ve indeksini belirle
        int pivotIndeks = sol + (sag - sol) / 2;
        int pivotDegeri = dizi[pivotIndeks];
        int i = sol;
        int j = sag;

        while (i <= j) {
            // Pivot degerinden kucuk elemanlar bulunur
            while (dizi[i] < pivotDegeri) {
                i++;
            }
            // Pivot degerinden buyuk elemanlar bulunur
            while (dizi[j] > pivotDegeri) {
                j--;
            }
            // Elemanlar yer degistirilir
            if (i <= j) {
                int gecici = dizi[i];
                dizi[i] = dizi[j];
                dizi[j] = gecici;
                i++;
                j--;
            }
            // Sol alt diziyi sirala
            if (sol < i) {
                sirala(dizi, sol, j);
            }
            // Sag alt diziyi sirala
            if (sag > i) {
                sirala(dizi, i, sag);
            }
        }
    }

    public static void main(String[] args) {
        // Ornek bir dizi olustur
        int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3, 14};

        // Dizi hizli siralama ile siralanir
        HizliSiralama.sirala(dizi, 0, dizi.length - 1);

        // Siralanmis dizi ekrana yazdirilir
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println();
    }
}
