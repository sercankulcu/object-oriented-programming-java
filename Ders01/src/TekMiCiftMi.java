import java.util.Scanner;

/*
 * Modulo operatoru (%) kullanilarak sayinin 2'ye tam olarak bolunup bolunmedigi kontrol edilir. 
 * Eger bolunuyorsa, sayi cifttir. Bolunmuyorsa, sayi tektir. 
 */

public class TekMiCiftMi {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        // Kullanicidan bir sayi girmesini iste
        System.out.println("Bir sayi giriniz: ");
        int sayi = scan.nextInt();
        scan.close();

        // Sayinin tek mi cift mi oldugunu kontrol et
        if (sayi % 2 == 0) {
            System.out.println(sayi + " cift bir sayidir.");
        } else {
            System.out.println(sayi + " tek bir sayidir.");
        }
    }
}
