package ifcondition;

public class SayiOkuma {
	
    public static void main(String[] args) {
    	
    	System.out.println(sayiOkunusu(1234));  // Sayinin okunusunu yazdir
        
        System.out.println(sayiOkunusu(7248));  
        
        System.out.println(sayiOkunusu(297));  
        
        System.out.println(sayiOkunusu(505));  
        
        System.out.println(sayiOkunusu(300)); 
    }

    // Sayının okunuşunu döndüren fonksiyon
    public static String sayiOkunusu(int sayi) {
        // Eğer sayı 0 ise "sifir" döndürülür
        if (sayi == 0) return "sifir";

        // Sonuç metnini tutacak değişken
        String sonuc = "";

        // Binler basamağını ayırma
        int bin = sayi / 1000;
        // Yüzler basamağını ayırma
        int yuz = (sayi / 100) % 10;
        // Onlar basamağını ayırma
        int on = (sayi / 10) % 10;
        // Birler basamağını ayırma
        int bir = sayi % 10;

        // Binler basamağı varsa eklenir
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

        // Yüzler basamağı varsa eklenir
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

        // Onlar basamağı varsa eklenir
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

        // Birler basamağı varsa eklenir
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

        // Sonuç string'ini döndürürken, başındaki ve sonundaki boşlukları temizler
        return sonuc.trim();
    }
}
