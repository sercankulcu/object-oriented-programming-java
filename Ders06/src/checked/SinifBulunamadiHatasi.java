package checked;

public class SinifBulunamadiHatasi {

    public static void main(String[] args) {
        try {
            // Belirtilen sinifi yuklemeye calis
            String sinifAdi = "java.util.Scanner"; // Mevcut bir sinif
            Class<?> sinif = Class.forName(sinifAdi); // Sinifi yukle
            System.out.println(sinifAdi + " sinifi basariyla yuklendi.");
            
            // Mevcut olmayan bir sinifi yuklemeyi dene
            String olmayanSinifAdi = "com.ornek.Sinif";
            Class<?> olmayanSinif = Class.forName(olmayanSinifAdi); // Hata olusur
            System.out.println(olmayanSinifAdi + " sinifi basariyla yuklendi.");
            
        } catch (ClassNotFoundException e) {
            // Eger belirtilen sinif bulunamazsa bu blok calisir
            System.out.println("Sinif bulunamadi: " + e.getMessage());
            e.printStackTrace(); // Istisnanin izini yazdir
        } finally {
            // Kaynak temizleme veya islemin tamamlandigini bildirmek icin kullanilir
            System.out.println("Islem tamamlandi.");
        }
    }
}
