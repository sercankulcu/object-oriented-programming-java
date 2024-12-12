package functions;

public class SayiOkuma {
	
    public static void main(String[] args) {
    	
    	System.out.println(sayiOkunusu(1234));  // Sayinin okunusunu yazdir
        
        System.out.println(sayiOkunusu(7248));  
        
        System.out.println(sayiOkunusu(297));  
        
        System.out.println(sayiOkunusu(505));  
        
        System.out.println(sayiOkunusu(300)); 
    }

    // Sayinin okunusunu donduren ana fonksiyon
    public static String sayiOkunusu(int sayi) {
        // Eger sayi 0 ise "sifir" dondurulur
        if (sayi == 0) return "sifir";

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

        // Binler basamagi eklenir
        if (bin > 0) {
            sonuc += binOkunusu(bin) + " ";
        }

        // Yuzler basamagi eklenir
        if (yuz > 0) {
            sonuc += yuzOkunusu(yuz) + " ";
        }

        // Onlar basamagi eklenir
        if (on > 0) {
            sonuc += onlarOkunusu(on) + " ";
        }

        // Birler basamagi eklenir
        if (bir > 0) {
            sonuc += birlerOkunusu(bir);
        }

        // Sonuc string'ini dondururken, basindaki ve sonundaki bosluklari temizler
        return sonuc.trim();
    }

    // Binler basamagi icin fonksiyon
    public static String binOkunusu(int bin) {
        if (bin == 1) {
            return "bin";
        } else if (bin == 2) {
            return "iki bin";
        } else if (bin == 3) {
            return "uc bin";
        } else if (bin == 4) {
            return "dort bin";
        } else if (bin == 5) {
            return "bes bin";
        } else if (bin == 6) {
            return "alti bin";
        } else if (bin == 7) {
            return "yedi bin";
        } else if (bin == 8) {
            return "sekiz bin";
        } else if (bin == 9) {
            return "dokuz bin";
        }
        return "";
    }

    // Yuzler basamagi icin fonksiyon
    public static String yuzOkunusu(int yuz) {
        if (yuz == 1) {
            return "yuz";
        } else if (yuz == 2) {
            return "iki yuz";
        } else if (yuz == 3) {
            return "uc yuz";
        } else if (yuz == 4) {
            return "dort yuz";
        } else if (yuz == 5) {
            return "bes yuz";
        } else if (yuz == 6) {
            return "alti yuz";
        } else if (yuz == 7) {
            return "yedi yuz";
        } else if (yuz == 8) {
            return "sekiz yuz";
        } else if (yuz == 9) {
            return "dokuz yuz";
        }
        return "";
    }

    // Onlar basamagi icin fonksiyon
    public static String onlarOkunusu(int on) {
        if (on == 1) {
            return "on";
        } else if (on == 2) {
            return "yirmi";
        } else if (on == 3) {
            return "otuz";
        } else if (on == 4) {
            return "kirk";
        } else if (on == 5) {
            return "elli";
        } else if (on == 6) {
            return "altmis";
        } else if (on == 7) {
            return "yetmis";
        } else if (on == 8) {
            return "seksen";
        } else if (on == 9) {
            return "doksan";
        }
        return "";
    }

    // Birler basamagi icin fonksiyon
    public static String birlerOkunusu(int bir) {
        if (bir == 1) {
            return "bir";
        } else if (bir == 2) {
            return "iki";
        } else if (bir == 3) {
            return "uc";
        } else if (bir == 4) {
            return "dort";
        } else if (bir == 5) {
            return "bes";
        } else if (bir == 6) {
            return "alti";
        } else if (bir == 7) {
            return "yedi";
        } else if (bir == 8) {
            return "sekiz";
        } else if (bir == 9) {
            return "dokuz";
        }
        return "";
    }
}
