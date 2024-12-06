package array;

public class EklemeliSiralama {
	
    public static void sirala(int[] dizi) {
        // Diziyi sirala
        for (int i = 1; i < dizi.length; i++) {
            int gecici = dizi[i];
            int j = i - 1;

            // Elemani dogru konuma yerlestir
            while (j >= 0 && dizi[j] > gecici) {
                dizi[j + 1] = dizi[j];
                j--;
            }
            dizi[j + 1] = gecici;
        }
    }
	
    public static void main(String[] args) {
        // 10 rastgele elemandan olusan bir dizi olustur
        int[] sayilar = new int[20];
        for (int i = 0; i < sayilar.length; i++) {
            sayilar[i] = (int)(Math.random() * 100);
        }
        
        System.out.print("Orjinal: ");
        for (int i = 0; i < sayilar.length; i++) {
            System.out.print(sayilar[i] + " ");
        }
        System.out.println();

        // Diziyi sirala
        EklemeliSiralama.sirala(sayilar);

        System.out.print("Sirali : ");
        // Siralanmis diziyi yazdir
        for (int i = 0; i < sayilar.length; i++) {
            System.out.print(sayilar[i] + " ");
        }
        System.out.println();
    }
}
