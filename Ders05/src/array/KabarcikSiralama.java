package array;

public class KabarcikSiralama {

    public static void main(String[] args) {
        
        int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3, 14};

        // Kabarcik siralama uygula
        kabarcikSiralama(dizi);

        // Siralanmis diziyi ekrana yazdir
        System.out.println("Siralanmis Dizi:");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
    }

    static void kabarcikSiralama(int[] dizi) {

        for (int i = 0; i < dizi.length - 1; i++) {
            // Siralama islemi icin tekrar et
            for (int j = 0; j < dizi.length - i - 1; j++) {
                if (dizi[j] > dizi[j + 1]) {
                    // Elemanlari yer degistir
                    int gecici = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = gecici;
                }
            }
        }
    }
}
