package datatypes;

public class CharVeBooleanOrnegi {

    public static void main(String[] args) {

        // char ve boolean veri turlerini kullanarak degiskenler tanimla
        char karakter = 'A';
        boolean dogruMu = true;

        // Degerleri yazdir
        System.out.println("Karakter: " + karakter);
        System.out.println("Boolean Degeri: " + dogruMu);

        // char verisini int'e donustur (casting)
        int karakterInt = karakter; // char'dan int'e donusum (casting)
        System.out.println("Karakterin ASCII Degeri: " + karakterInt);

        // boolean verisini kullanarak kosullu ifade olusturalim
        if (dogruMu) {
            System.out.println("Bu ifade dogru.");
        } else {
            System.out.println("Bu ifade yanlis.");
        }

        // int verisini char'a donustur (casting)
        int intDeger = 66;
        char charDeger = (char) intDeger; // int'ten char'a donusum (casting)
        System.out.println("ASCII Degerinden Karakter: " + charDeger);

        // char degerini baska bir char ile toplama
        char char1 = 'B';
        char char2 = 'C';
        int toplam = char1 + char2; // char'larin ASCII degerlerinin toplami
        System.out.println("Char1 ve Char2'nin toplami (ASCII Degerleri): " + toplam);

        // boolean veri tipini kullanarak tersini alma islemi 
        boolean yanlisMi = !dogruMu; // dogruMu'nun tersi
        System.out.println("Ters deger: " + yanlisMi);

        // boolean ile kosul testi 
        if (dogruMu && !yanlisMi) {
            System.out.println("Her iki kosul dogru.");
        } else {
            System.out.println("Kosullardan biri yanlis.");
        }

        // char'in kucuk harfe donusumu
        char kucukHarf = Character.toLowerCase(karakter); // char'i kucuk harfe cevirme
        System.out.println("Karakterin kucuk harfi: " + kucukHarf);

        // char'in buyuk harfe donusumu
        char buyukHarf = Character.toUpperCase(kucukHarf); // char'i buyuk harfe cevirme
        System.out.println("Char'in buyuk harfi: " + buyukHarf);
    }
}
