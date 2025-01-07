package whileloop;
import java.util.Scanner;

public class CollatzDizisi {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pozitif bir tam sayi giriniz: "); // Kullanicidan pozitif bir tam sayi girmesini iste
        int n = scanner.nextInt();
        scanner.close();
        // Negatif veya sifir kontrolu
        if (n <= 0) {
            System.out.println("Lutfen pozitif bir tam sayi giriniz."); // Negatif ya da sifir girilirse uyari
            return; // Programi sonlandir
        }

        int sayac = 1; // Ilk sayi dizinin bir parcasi oldugu icin sayac 1 ile basliyor
        System.out.println("Collatz Dizisi:");
        System.out.print(n); // Ilk sayiyi yazdir

        // Collatz dizisini olustur
        while (n != 1) { // 1'e ulasana kadar dongu devam eder
            if (n % 2 == 0) { // Sayi ciftse
                n /= 2; // 2'ye bol
            } else { // Sayi tekse
                n = 3 * n + 1; // 3n + 1 islemini uygula
            }
            System.out.print(" -> " + n); // Her adimdaki degeri yazdir
            sayac++; // Her adimda sayac artirilir
        }

        // Dizinin uzunlugunu yazdir
        System.out.println("\nCollatz dizisinin uzunlugu: " + sayac);
    }
}
