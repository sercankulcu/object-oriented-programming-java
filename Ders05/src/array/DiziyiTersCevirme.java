// Java'da bir diziyi ters ceviren ve dizideki minimum elemani bulan program
package array;

public class DiziyiTersCevirme {

    public static void main(String[] args) {
        // Bir dizi tanimla ve degerlerini ata
        int[] dizi = {5, 2, 8, 1, 9, 4, 7};

        // Diziyi ters cevir
        tersCevir(dizi);

        // Ters cevrilmis diziyi ekrana yazdir
        System.out.println("Ters Cevrilmis Dizi Elemanlari:");
        diziYazdir(dizi);  // Diziyi yazdirma fonksiyonunu cagir

        // Dizideki minimum elemani bul ve ekrana yazdir
        int minEleman = bulMinEleman(dizi);
        System.out.println("\nDizideki Minimum Eleman: " + minEleman);  // Minimum elemani yazdir
    }

    // Diziyi ters ceviren metod
    public static void tersCevir(int[] dizi) {
        int baslangic = 0;  // Baslangic indeksi
        int bitis = dizi.length - 1;  // Bitis indeksi

        while (baslangic < bitis) {
            // Swap (degis tokus): Baslangic ve bitis indekslerindeki elemanlari degistir
            int gecici = dizi[baslangic];
            dizi[baslangic] = dizi[bitis];
            dizi[bitis] = gecici;

            // Indeksleri guncelle
            baslangic++;
            bitis--;
        }
    }

    // Diziyi yazdiran metod
    public static void diziYazdir(int[] dizi) {
        for (int eleman : dizi) {
            System.out.print(eleman + " ");  // Dizinin her elemanini ekrana yazdir
        }
        System.out.println();  // Yeni satir
    }

    // Dizideki minimum elemani bulan metod
    public static int bulMinEleman(int[] dizi) {
        int minEleman = dizi[0];  // Minimum elemani baslangicta ilk eleman olarak ata

        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] < minEleman) {
                minEleman = dizi[i];  // Daha kucuk bir eleman bulunursa, onu minimum olarak ata
            }
        }

        return minEleman;  // Minimum elemani dondur
    }
}
