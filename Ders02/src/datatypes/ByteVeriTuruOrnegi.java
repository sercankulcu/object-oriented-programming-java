package datatypes; 

/*
 * Byte veri turu, -128 ile 127 arasinda bir tam sayiyi depolayabilen veri turudur. 
 * Kodda, byte veri turunun en kucuk ve en buyuk degerleri yazdirilir ve byte degiskenleriyle 
 * aritmetik islemler yapilir.
 */

public class ByteVeriTuruOrnegi {
    
    public static void main(String[] args) {
        
        // byte veri turunu kullanarak bir degisken tanimla
        byte minDeger = Byte.MIN_VALUE; // Byte turunun en kucuk degeri
        byte maxDeger = Byte.MAX_VALUE; // Byte turunun en buyuk degeri

        // Degerleri yazdir
        System.out.println("Byte veri turunun en kucuk degeri: " + minDeger);
        System.out.println("Byte veri turunun en buyuk degeri: " + maxDeger);

        // Bir byte degiskeni kullanarak aritmetik islem yap
        byte sayi1 = 80;
        byte sayi2 = 50;
        byte toplam = (byte) (sayi1 + sayi2); // Toplam sonucunu bir byte'a donusturmek gerekebilir
        System.out.println("Toplam: " + toplam);
        
        // Cikarma islemi
        byte fark = (byte) (sayi1 - sayi2); // Fark sonucunu bir byte'a donustur
        System.out.println("Fark: " + fark);

        // Carpma islemi
        byte carpim = (byte) (sayi1 * sayi2); // Carpim sonucunu bir byte'a donustur
        System.out.println("Carpim: " + carpim);

        // Bolme islemi
        byte bolum = (byte) (sayi1 / sayi2); // Bolum sonucunu bir byte'a donustur
        System.out.println("Bolum: " + bolum);

        // Modulus islemi (kalan)
        byte kalan = (byte) (sayi1 % sayi2); // Modulus sonucunu bir byte'a donustur
        System.out.println("Kalan: " + kalan);

        // Byte degerinin sinirlarini kontrol etme
        byte sinirKontrol = 127;
        System.out.println("Sinir Kontrol: " + sinirKontrol);
        if (sinirKontrol == Byte.MAX_VALUE) {
            System.out.println("Sinirda bir deger var.");
        } else {
            System.out.println("Sinirda degil.");
        }

        // Byte degiskeni ile bitwise islemler
        byte a = 5; // 00000101
        byte b = 3; // 00000011
        byte sonuc = (byte) (a & b); // AND islemi
        System.out.println("AND islemi sonucu: " + sonuc);
        
        sonuc = (byte) (a | b); // OR islemi
        System.out.println("OR islemi sonucu: " + sonuc);

        sonuc = (byte) (a ^ b); // XOR islemi
        System.out.println("XOR islemi sonucu: " + sonuc);

        sonuc = (byte) (~a); // NOT islemi
        System.out.println("NOT islemi sonucu: " + sonuc);
    }
}
