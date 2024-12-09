package string; 
import java.util.Random;

/*
 * Bu kod, minimum 8 karakter ve maksimum 12 karakter iceren bir rastgele sifre olusturur. 
 * Sifre en az bir buyuk harf, bir rakam ve bir ozel karakter icermektedir:
 */

public class SifreUreteci {

    public static String sifreUret() {
        
        String buyukHarfler = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Buyuk harfler
        String rakamlar = "0123456789"; // Rakamlar
        String ozelKarakterler = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/\\"; // Ozel karakterler

        Random rastgele = new Random();

        int uzunluk = 8 + rastgele.nextInt(5); // 8 ile 12 arasinda rastgele bir uzunluk belirlenir
        String sifre = "";

        // Her bir karakter grubundan rastgele bir karakter secilir ve sifreye eklenir
        sifre += buyukHarfler.charAt(rastgele.nextInt(buyukHarfler.length()));
        sifre += rakamlar.charAt(rastgele.nextInt(rakamlar.length()));
        sifre += ozelKarakterler.charAt(rastgele.nextInt(ozelKarakterler.length()));

        // Geriye kalan karakterler rastgele secilir
        for (int i = 0; i < uzunluk - 3; i++) {
            String karakterler = buyukHarfler + rakamlar + ozelKarakterler + buyukHarfler.toLowerCase();
            sifre += karakterler.charAt(rastgele.nextInt(karakterler.length()));
        }

        return stringKaristir(sifre); // Sifreyi karistir ve dondur
    }

    public static String stringKaristir(String sifre) {
    	
        char[] dizi = sifre.toCharArray();
        Random rastgele = new Random();
        for (int i = dizi.length - 1; i > 0; i--) {
            int index = rastgele.nextInt(i); // Rastgele bir index sec
            char temp = dizi[index];
            dizi[index] = dizi[i];
            dizi[i] = temp;
        }
        return new String(dizi);
    }
    
    public static void main(String[] args) {
        System.out.println(sifreUret()); // Rastgele sifreyi yazdir
    }
}
