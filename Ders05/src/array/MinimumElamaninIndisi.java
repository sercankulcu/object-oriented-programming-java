package array;

public class MinimumElamaninIndisi {

    public static int minimumIndis(int[] dizi) {
        // Eger dizi bos veya null ise -1 dondur
        if (dizi == null || dizi.length == 0) {
            return -1;
        }

        int minIndis = 0; // Minimum elemanin indisi
        for (int i = 1; i < dizi.length; i++) {
            // Her elemani minimum eleman ile karsilastir
            System.out.println(dizi[i] + " ile " + dizi[minIndis] + " karsilastir.");
            if (dizi[i] < dizi[minIndis]) {
                minIndis = i; // Yeni minimum elemanin indisini guncelle
            }
        }
        return minIndis; // Minimum elemanin indisini dondur
    }

    public static void main(String[] args) {
        // Ornek bir dizi olustur
        int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3, 14};
        int minIndis = minimumIndis(dizi);

        // Minimum elemanin indisini kontrol et ve yazdir
        if (minIndis != -1) {
            System.out.println("Dizideki minimum elemanin indisi: " + minIndis);
        } else {
            System.out.println("Dizi bos veya null.");
        }
    }
}
