public class Calculator { 

    // Iki sayiyi toplama islemi yapan method
    public int add(int a, int b) {
        return a + b;
    }

    // Iki sayiyi cikarma islemi yapan method
    public int subtract(int a, int b) {
        return a - b;
    }

    // Iki sayiyi carpma islemi yapan method
    public int multiply(int a, int b) {
        return a * b;
    }

    // Iki sayiyi bolme islemi yapan method
    public int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            // Sifira bolme yapilamaz, hata firlatilir
            throw new IllegalArgumentException("Sifira bolme yapilamaz.");
        }
        return a / b;
    }

    // Iki sayiyi mod alma islemi yapan method
    public int modulus(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            // Sifira bolme yapilamaz, hata firlatilir
            throw new IllegalArgumentException("Sifira mod alma yapilamaz.");
        }
        return a % b;
    }

    // Bir sayinin faktoryelini hesaplayan method
    public long factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            // Negatif sayi ile faktoriyel hesaplanamaz, hata firlatilir
            throw new IllegalArgumentException("Negatif sayilarin faktoriyeli hesaplanamaz.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Iki sayinin us alarak hesaplamasini yapan method
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Bir sayinin karekokunu hesaplayan method
    public double squareRoot(double a) throws IllegalArgumentException {
        if (a < 0) {
            // Negatif sayinin karekoku hesaplanamaz, hata firlatilir
            throw new IllegalArgumentException("Negatif sayilarin karekoku hesaplanamaz.");
        }
        return Math.sqrt(a);
    }

    // Iki sayinin maksimum degerini bulan method
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Iki sayinin minimum degerini bulan method
    public int min(int a, int b) {
        return (a < b) ? a : b;
    }

    // Iki sayinin ortalamasini hesaplayan method
    public double average(int a, int b) {
        return (a + b) / 2.0;
    }
}
