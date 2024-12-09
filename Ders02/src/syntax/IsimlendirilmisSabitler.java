package syntax;

public class IsimlendirilmisSabitler {

    public static void main(String[] args) {
        // Isimlendirilmis sabitleri kullanarak matematiksel bir islem yap
        final double PI = 3.14159; // PI sabiti tanimlandi ve degeri atandi
        final int YARICAP = 5; // Yaricap sabiti tanimlandi ve degeri atandi

        // Dairenin alanini hesaplayalim
        double alan = PI * YARICAP * YARICAP;
        System.out.println("Dairenin Alani: " + alan);

        // Isimlendirilmis sabitlerin degerleri degistirilemez
        // PI = 3.14; // Hata! Sabit degeri degistirilemez

        // Isimlendirilmis sabitlerin kullanilmasi, kodun daha okunakli ve bakimi daha kolay olmasini saglar
    }
}
