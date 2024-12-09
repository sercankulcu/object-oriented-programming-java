package syntax;

public class UcluIslec {

    public static void main(String[] args) {

        int sayi = 10;

        // Basit bir uclu operator ornegi
        String sonuc = (sayi > 5) ? "Buyuk" : "Kucuk"; // sayi 5'ten buyukse "Buyuk", degilse "Kucuk" yazdir
        System.out.println("Sayi 5ten Buyuk mu? " + sonuc); // Sayi Buyuk mu? Buyuk
        
        sonuc = (sayi > 15) ? "Buyuk" : "Kucuk"; // sayi 5'ten buyukse "Buyuk", degilse "Kucuk" yazdir
        System.out.println("Sayi 15ten Buyuk mu? " + sonuc); // Sayi Buyuk mu? Buyuk

        // Ic ice girmis uclu operatorlerin kullanimi
        String derece = (sayi > 25) ? "Sicak" : (sayi > 15) ? "Ilik" : "Soguk"; 
        // sayi 25'ten buyukse "Sicak", 15'ten buyukse "Ilik", degilse "Soguk" yazdir
        System.out.println("Hava Durumu: 10 derece " + derece); // Hava Durumu: Ilik
        
        sayi = 20;
        derece = (sayi > 25) ? "Sicak" : (sayi > 15) ? "Ilik" : "Soguk"; 
        // sayi 25'ten buyukse "Sicak", 15'ten buyukse "Ilik", degilse "Soguk" yazdir
        System.out.println("Hava Durumu: 20 derece " + derece); // Hava Durumu: Ilik
        
        sayi = 30;
        derece = (sayi > 25) ? "Sicak" : (sayi > 15) ? "Ilik" : "Soguk"; 
        // sayi 25'ten buyukse "Sicak", 15'ten buyukse "Ilik", degilse "Soguk" yazdir
        System.out.println("Hava Durumu: 30 derece " + derece); // Hava Durumu: Ilik
    }
}
