package syntax;

public class AtamaIslemleri {

    public static void main(String[] args) {
        // Atama islemleri
        int x = 5; // x degiskenine 5 atandi
        int y = 10; // y degiskenine 10 atandi
        int z = 15; // z degiskenine 15 atandi

        // Toplama ve atama
        x = x + y; // x, x ve y'nin toplamina esit olur
        System.out.println("Toplama ve Atama: x = " + x + " y = " + y); // x simdi 15

        // Cikarma ve atama
        x -= y; // x, x ve y'nin farkina esit olur
        System.out.println("Cikarma ve Atama: x = " + x + " y = " + y); // x simdi 5

        // Carpma ve atama
        x *= 2; // x, x'in 2 ile carpimina esit olur
        System.out.println("Carpma ve Atama: x = " + x + " y = " + y); // x simdi 10

        // Bolme ve atama
        x /= 4; // x, x'in 4'e bolumune esit olur
        System.out.println("Bolme ve Atama: x = " + x + " y = " + y); // x simdi 2

        // Modul (Kalan) ve atama
        x %= 3; // x, x'in 3'e bolumunden kalanina esit olur
        System.out.println("Mod ve Atama: x = " + x + " y = " + y); // x simdi 2 % 3 = 2

        // x'in z ile toplanmasi
        x += z; // x, x ve z'nin toplamina esit olur
        System.out.println("Toplama ve Atama (x + z): x = " + x + " z = " + z); // x simdi 17

        // x'in z ile carpimi
        x *= z; // x, x ve z'nin carpimina esit olur
        System.out.println("Carpma ve Atama (x * z): x = " + x + " z = " + z); // x simdi 255

        // z'nin x'e bolunmesi
        x = z / x; // z'nin x'e bolumune esit olur
        System.out.println("Bolme ve Atama (z / x): x = " + x + " z = " + z); // x simdi 0

        // y'nin x'e bolumunden kalan
        x = y % (x + 1); // y'nin x'e bolumunden kalan
        System.out.println("Mod ve Atama (y % (x + 1)): x = " + x + " y = " + y); // x simdi 0

        // y'nin x'e eklenmesi
        x = 10; // x'i 10'a ayarla
        y += x; // y, y ve x'in toplamina esit olur
        System.out.println("Toplama ve Atama (y + x): x = " + x + " y = " + y); // y simdi 20

        // y'nin x'e bolunmesi
        y /= x; // y, y'nin x'e bolumune esit olur
        System.out.println("Bolme ve Atama (y / x): x = " + x + " y = " + y); // y simdi 2

        // x'in negatif degeri
        x = -x; // x'in negatif degeri
        System.out.println("Negatif deger: x = " + x); // x simdi -10
    }
}
