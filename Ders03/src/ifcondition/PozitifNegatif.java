package ifcondition; 
import java.util.Scanner;

public class PozitifNegatif {
    public static void main(String[] args) {
        // Kullanici dan veri almak icin Scanner nesnesi olustur
        Scanner scanner = new Scanner(System.in);

        // Kullaniciya sayi girmesi iste
        System.out.print("Bir sayi girin: ");
        double sayi = scanner.nextDouble();

        // Sayinin pozitif olup olmadigi kontrol et
        if (sayi > 0) {
            System.out.println("Girdiginiz sayi pozitif.");
        } 
        // Sayinin negatif olup olmadigi kontrol et
        else if (sayi < 0) {
            System.out.println("Girdiginiz sayi negatif.");
        } 
        // Sayinin sifir olup olmadigi kontrol et
        else {
            System.out.println("Girdiginiz sayi sifir.");
        }

        // Scanner nesnesi kapatiliyor
        scanner.close();
    }
}
