package unchecked;

public class HataFirlatma {

    public static void main(String[] args) {
    	
        try {
            // bol fonksiyonunu cagir ve sonucunu yazdir
            bol(10, 0);
        } catch (ArithmeticException e) {
            // Sifira bolme istisnasini yakala ve mesaj yazdir
            System.out.println("Hata: Sifira bolme islemi yapilamaz!");
            System.out.println("Hata mesaji: " + e.getMessage());
        }

        // Ek testler 
        try {
            bol(20, 5); // Gecerli bir bolme islemi
            bol(15, -3); // Negatif sayi ile bolme islemi
        } catch (ArithmeticException e) {
            System.out.println("Hata olustu: " + e.getMessage());
        }

        // Alternatif bir islem ornegi
        System.out.println("Toplama islemi: " + topla(10, 5));
    }

    /**
     * Iki sayiyi bolen bir metot
     * @param x Bolunen
     * @param y Bolen
     * @throws ArithmeticException Eger y sifirsa
     */
    public static void bol(int x, int y) throws ArithmeticException {
        if (y == 0) {
            // Eger bolen sifir ise ArithmeticException firlat
            throw new ArithmeticException("Sifira bolme hatasi!");
        }
        int z = x / y; // Bolme islemini yap
        System.out.println("Bolme Islemi: " + z); // Sonucu yazdir
    }

    /**
     * Iki sayinin toplamini bulan bir metot
     * @param a Birinci sayi
     * @param b Ikinci sayi
     * @return a ve b toplami
     */
    public static int topla(int a, int b) {
        return a + b; // Iki sayiyi topla ve sonucu dondur
    }
}
