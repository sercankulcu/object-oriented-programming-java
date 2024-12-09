package unchecked;

public class BosReferansHatasi {

    public static void main(String[] args) {
        
        // Null degeri atanmis bir nesne olustur
        String str = null;
        
        try {
            // Null olan nesne uzerinde bir metod cagirilmaya calisilir
            int uzunluk = str.length(); // Burada NullPointerException olusur
            System.out.println("String uzunlugu: " + uzunluk);
        } catch (NullPointerException e) {
            // NullPointerException yakalanir ve kullaniciya mesaj verilir
            System.out.println("Hata: Null deger uzerinde islem yapilamaz!");
            System.out.println("Hata mesaji: " + e.getMessage());
            e.printStackTrace(); // Istisnanin izini yazdir
        } finally {
            // Kaynak temizleme veya islemin tamamlandigini bildirmek icin kullanilir
            System.out.println("Islem tamamlandi.");
        }

        // Alternatif bir ornek: Null degeri olmayan bir nesne
        String str2 = "Merhaba";
        System.out.println("String uzunlugu: " + str2.length()); // Bu islem basariyla calisir
    }
}
