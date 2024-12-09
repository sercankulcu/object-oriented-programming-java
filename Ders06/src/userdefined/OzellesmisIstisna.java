package userdefined;

// Bu sinif, ozel bir istisna tanimlar
public class OzellesmisIstisna extends Exception {

    // Benzersiz bir ID degiskeni (serilestirme icin)
    private static final long serialVersionUID = 1L;
    
    // Ozel mesaj degiskeni
    private final String mesaj;

    // Yapici (constructor), mesaj parametresi alir
    public OzellesmisIstisna(String mesaj) {
        super(mesaj); // Ust sinifin yapicisini cagirir
        this.mesaj = mesaj; // Mesaj degiskenine degeri atar
    }

    // Mesaji geri donduren metot
    @Override
    public String getMessage() {
        return mesaj; // Mesaji dondurur
    }
    
    /**
     * Ana metot, istisnanin farkli durumlarda nasil calistigini test eder.
     */
    public static void main(String[] args) {
    	
        // 1. Ornek: Basit bir istisna firlatma ve yakalama
    	System.out.println("1. Ornek: Basit bir istisna firlatma ve yakalama");
        try {
            throw new OzellesmisIstisna("Bu bir ozel istisnadir");
        } catch (OzellesmisIstisna e) {
            System.out.println("Hata Mesaji: " + e.getMessage());
        }

        // 2. Ornek: Istisna baska bir metot icinde firlatiliyor
        System.out.println("2. Ornek: Istisna baska bir metot icinde firlatiliyor");
        try {
            istisnaFirlat();
        } catch (OzellesmisIstisna e) {
            System.out.println("Metottan Gelen Hata: " + e.getMessage());
        }

        // 3. Ornek: Birden fazla istisna durumunu kontrol etme
        System.out.println("3. Ornek: Birden fazla istisna durumunu kontrol etme");
        try {
            kontrolEt(-5);
        } catch (OzellesmisIstisna e) {
            System.out.println("Kontrol Hatasi: " + e.getMessage());
        }

        // 4. Ornek: Normal akis
        System.out.println("4. Ornek: Normal akis");
        try {
            kontrolEt(10);
            System.out.println("Hata yok, islem basariyla tamamlandi!");
        } catch (OzellesmisIstisna e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    /**
     * Bu metot her zaman bir OzellesmisIstisna firlatir.
     * @throws OzellesmisIstisna ozel istisna
     */
    public static void istisnaFirlat() throws OzellesmisIstisna {
        throw new OzellesmisIstisna("Bu metot her zaman bir istisna firlatir!");
    }

    /**
     * Sayi kontrolu yapan bir metot. Eger sayi 0'dan kucukse istisna firlatir.
     * @param sayi Kontrol edilecek sayi
     * @throws OzellesmisIstisna Eger sayi 0'dan kucukse firlatilir
     */
    public static void kontrolEt(int sayi) throws OzellesmisIstisna {
        if (sayi < 0) {
            throw new OzellesmisIstisna("Gecersiz sayi: " + sayi + ". Sifirdan kucuk olamaz.");
        }
    }
}
