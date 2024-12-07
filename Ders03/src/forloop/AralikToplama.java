package forloop;
import java.util.Scanner;

public class AralikToplama {

    // Verilen araliktaki (a'dan b'ye kadar) sayilarin toplamini hesaplayan metot
    public static void aralikTopla(int a, int b) {
        int toplam = 0; // Toplam degiskeni baslatilir
        for (int i = a; i <= b; i++) { // a'dan b'ye kadar olan sayilar donguyle eklenir
            toplam += i; // Her sayi toplam degiskenine eklenir
        }
        // Toplam sonucu ekrana yazdirilir
        System.out.println(a + " ile " + b + " arasindaki sayilarin toplami: " + toplam);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanicidan baslangic degeri (a) alinir
        System.out.print("Baslangic degerini girin (a): ");
        int a = scanner.nextInt();

        // Kullanicidan bitis degeri (b) alinir
        System.out.print("Bitis degerini girin (b): ");
        int b = scanner.nextInt();

        // aralikTopla metodu cagrilarak verilen araliktaki sayilarin toplami hesaplanir
        if(a < b) {
        	aralikTopla(a, b);
        }
        else {
        	aralikTopla(b, a);
        }

        // Scanner kapatilir
        scanner.close();
    }
}
