package datatypes;

public class FloatVeDoubleOrnegi {

    public static void main(String[] args) {

        // float ve double veri turlerini kullanarak degiskenler tanimla
        float floatSayi = 123.45f; // float veri turu "f" veya "F" ile belirtilir
        double doubleSayi = 678.90;

        // Degerleri yazdir
        System.out.println("Float Sayi: " + floatSayi);
        System.out.println("Double Sayi: " + doubleSayi);

        // float ve double veri turlerini donusturme (casting)
        float floatToDouble = (float) doubleSayi; // double'dan float'a donusum (casting)
        double doubleToFloat = floatSayi; // float'tan double'a otomatik donusum

        System.out.println("Float'tan Double'a Donusum: " + floatToDouble);
        System.out.println("Double'dan Float'a Donusum: " + doubleToFloat);

        // float ve double veri turlerinde aritmetik islemler yap
        double toplama = floatSayi + doubleSayi;
        float carpma = floatSayi * (float) doubleSayi; // double'dan float'a donusum yaparak carpma islemi
        double cikarma = doubleSayi - floatSayi;
        float bolme = floatSayi / (float) doubleSayi; // double'dan float'a donusum yaparak bolme islemi

        // Islemleri yazdir
        System.out.println("Toplama Sonucu (float + double): " + toplama);
        System.out.println("Carpma Sonucu (float * double): " + carpma);
        System.out.println("Cikarma Sonucu (double - float): " + cikarma);
        System.out.println("Bolme Sonucu (float / double): " + bolme);

        // float ve double veri turlerinin min ve max degerlerini yazdir
        System.out.println("Float Min Degeri: " + Float.MIN_VALUE);
        System.out.println("Float Max Degeri: " + Float.MAX_VALUE);
        System.out.println("Double Min Degeri: " + Double.MIN_VALUE);
        System.out.println("Double Max Degeri: " + Double.MAX_VALUE);
    }
}
