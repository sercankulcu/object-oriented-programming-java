package array;

public class SecmeliSiralama {

    public static void main(String[] args) {
        // Ornek bir dizi olustur
        int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3, 14};

        // Secmeli siralama uygula
        secimSiralama(dizi);

        // Siralanmis diziyi ekrana yazdir
        System.out.println("Siralanmis Dizi:");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
    }

    public static void secimSiralama(int[] dizi) {

        // Her eleman icin uygun yeri bul
        for (int i = 0; i < dizi.length - 1; i++) {
            int minIndis = i;

            // Kalan elemanlar arasinda minimumu bul
            for (int j = i + 1; j < dizi.length; j++) {
                if (dizi[j] < dizi[minIndis]) {
                    minIndis = j;
                }
            }

            // Minimum elemani yer degistir
            int gecici = dizi[minIndis];
            dizi[minIndis] = dizi[i];
            dizi[i] = gecici;
        }
    }
}
