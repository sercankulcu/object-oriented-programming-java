
public class ToplamOnaKadar {
	
    public static void main(String[] args) {
        int toplam = 0;

        for (int i = 1; i <= 10; i++) {
            toplam += i;
        }

        System.out.println("1'den 10'a kadar olan sayıların toplamı: " + toplam);
    }
}
