package array;

public class DiziElemanErisim {

    // Cift indisli elemanlari yazdirir
    static void yaz1(int[] dizi) {
    	System.out.print("Cift indisli elemanlar: ");
        for (int i = 0; i < dizi.length; i++) {
            if (i % 2 == 0) {
                System.out.print(dizi[i] + " ");
            }
        }
        System.out.println();
    }

    // i miktarda atlayan indisli elemanlari yazdirir
    static void yaz2(int[] dizi) {
    	System.out.print("i artan indislerdeki elemanlar: ");
        for (int i = 1; i < dizi.length; i += i) { // i += i hatali bir ifade
            System.out.print(dizi[i] + " ");
        }
        System.out.println();
    }

    // Dizinin tek sayi olan elemanlarini yazdirir
    static void yaz3(int[] dizi) {
    	System.out.print("Tek sayi elemanlar: ");
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] % 2 == 0)
                continue;
            System.out.print(dizi[i] + " ");
        }
        System.out.println();
    }

    // 3'e tam bolunen bir elemana rastlayana kadar elemanlari yazdirir
    static void yaz4(int[] dizi) {
    	System.out.print("Ucun kati bir elemana kadar: ");
    	for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] % 3 == 0)
                break;
            System.out.print(dizi[i] + " ");
        }
        System.out.println();
    }

    // Tum elemanlari yazdirir
    static void yazTum(int[] dizi) {
    	System.out.print("Tum elemanlar: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Ornek bir dizi
        int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3, 14};

        yazTum(dizi);
        yaz1(dizi);
        yaz2(dizi);
        yaz3(dizi);
        yaz4(dizi);
        
    }
}
