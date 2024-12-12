package ifcondition;

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
            if (bin == 1) {
                sonuc += "bin ";
            } else if (bin == 2) {
                sonuc += "iki bin ";
            } else if (bin == 3) {
                sonuc += "uc bin ";
            } else if (bin == 4) {
                sonuc += "dort bin ";
            } else if (bin == 5) {
                sonuc += "bes bin ";
            } else if (bin == 6) {
                sonuc += "alti bin ";
            } else if (bin == 7) {
                sonuc += "yedi bin ";
            } else if (bin == 8) {
                sonuc += "sekiz bin ";
            } else if (bin == 9) {
                sonuc += "dokuz bin ";
            }
        }

        // Yuzler basamagi varsa eklenir
        if (yuz > 0) {
            if (yuz == 1) {
                sonuc += "yuz ";
            } else if (yuz == 2) {
                sonuc += "iki yuz ";
            } else if (yuz == 3) {
                sonuc += "uc yuz ";
            } else if (yuz == 4) {
                sonuc += "dort yuz ";
            } else if (yuz == 5) {
                sonuc += "bes yuz ";
            } else if (yuz == 6) {
                sonuc += "alti yuz ";
            } else if (yuz == 7) {
                sonuc += "yedi yuz ";
            } else if (yuz == 8) {
                sonuc += "sekiz yuz ";
            } else if (yuz == 9) {
                sonuc += "dokuz yuz ";
            }
        }

        // Onlar basamagi varsa eklenir
        if (on > 0) {
            if (on == 1) {
                sonuc += "on ";
            } else if (on == 2) {
                sonuc += "yirmi ";
            } else if (on == 3) {
                sonuc += "otuz ";
            } else if (on == 4) {
                sonuc += "kirk ";
            } else if (on == 5) {
                sonuc += "elli ";
            } else if (on == 6) {
                sonuc += "altmis ";
            } else if (on == 7) {
                sonuc += "yetmis ";
            } else if (on == 8) {
                sonuc += "seksen ";
            } else if (on == 9) {
                sonuc += "doksan ";
            }
        }

        // Birler basamagi varsa eklenir
        if (bir > 0) {
            if (bir == 1) {
                sonuc += "bir";
            } else if (bir == 2) {
                sonuc += "iki";
            } else if (bir == 3) {
                sonuc += "uc";
            } else if (bir == 4) {
                sonuc += "dort";
            } else if (bir == 5) {
                sonuc += "bes";
            } else if (bir == 6) {
                sonuc += "alti";
            } else if (bir == 7) {
                sonuc += "yedi";
            } else if (bir == 8) {
                sonuc += "sekiz";
            } else if (bir == 9) {
                sonuc += "dokuz";
            }
        }

        return sonuc;
    }
}
