package array;

public class SayiOkuma {
	
    public static void main(String[] args) {
    	
        System.out.println(sayiOkunusu(1234));  // Sayinin okunusunu yazdir
        
        System.out.println(sayiOkunusu(7248));  
        
        System.out.println(sayiOkunusu(297));  
        
        System.out.println(sayiOkunusu(505));  
        
        System.out.println(sayiOkunusu(300));  
    }

    // Sayinin okunusunu donduren fonksiyon
    public static String sayiOkunusu(int sayi) {
        // Eger sayi 0 ise "sifir" dondurulur
        if (sayi == 0) return "sifir";

        // Birler, onlar, yuzler ve binler basamagi icin diziler
        String[] birler = {"", "bir", "iki", "uc", "dort", "bes", "alti", "yedi", "sekiz", "dokuz"};
        String[] onlar = {"", "on", "yirmi", "otuz", "kirk", "elli", "altmis", "yetmis", "seksen", "doksan"};
        String[] yuzler = {"", "yuz"};  // Yuzler icin sadece "yuz" kelimesi var
        String[] binler = {"", "bin"};  // Binler icin sadece "bin" kelimesi var

        // Sonuc metnini tutacak degisken
        String sonuc = "";

        // Binler basamagini ayirma
        int bin = sayi / 1000;
        // Yuzler basamagini ayirma
        int yuz = (sayi / 100) % 10;
        // Onlar basamagini ayirma
        int on = (sayi / 10) % 10;
        // Birler basamagini ayirma
        int bir = sayi % 10;

        // Binler basamagi varsa eklenir
        if (bin > 0) {
            // Binler basamagi 1'den buyukse, sayinin okunusu da eklenir
            if (bin > 1) sonuc += birler[bin] + " ";
            sonuc += binler[1] + " ";  // "bin" kelimesi eklenir
        }

        // Yuzler basamagi varsa eklenir
        if (yuz > 0) {
            // Yuzler basamagi 1'den buyukse, sayinin okunusu da eklenir
            if (yuz > 1) sonuc += birler[yuz] + " ";
            sonuc += yuzler[1] + " ";  // "yuz" kelimesi eklenir
        }

        // Onlar basamagi varsa eklenir
        if (on > 0) {
            sonuc += onlar[on] + " ";  // Onlar basamaginin okunusu eklenir
        }

        // Birler basamagi varsa eklenir
        if (bir > 0) {
            sonuc += birler[bir];  // Birler basamaginin okunusu eklenir
        }

        return sonuc;
    }
}
