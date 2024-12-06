// Java'da lineer arama kullanarak bir dizide minimum elemani bulan program

public class EnKucukElemaniBul {

    public static void main(String[] args) {
        // Bir dizi tanimla ve degerlerini ata
        int[] dizi = {5, 2, 8, 1, 9, 4, 7};

        // Minimum elemani bulmak icin lineer arama yap
        int minEleman = dizi[0]; // Minimum elemani baslangicta ilk eleman olarak ata

        // Dizinin her elemanini kontrol et
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] < minEleman) {
                minEleman = dizi[i]; // Yeni minimum elemani bulursak, onu ata
            }
        }

        // Minimum elemani ekrana yazdir
        System.out.println("Dizideki Minimum Eleman: " + minEleman);
    }
}
