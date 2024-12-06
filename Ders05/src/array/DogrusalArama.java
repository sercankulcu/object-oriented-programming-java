package array;
import java.util.Scanner;

public class DogrusalArama {

    void dogrusalArama(int[] dizi, int aranan) {
        // Aranan deger icin bayrak tanimla
        boolean bulundu = false;

        // Dizideki her elemani kontrol et
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] == aranan) {
                // Aranan deger bulunursa
                bulundu = true;
                System.out.println("Aranan oge bulundu: Indis " + i);
                break;
            }
        }

        // Aranan deger bulunamazsa
        if (bulundu == false) {
            System.out.println("Aranan oge bulunamadi");
        }
    }

    public static void main(String[] args) {
        
        Scanner tarayici = new Scanner(System.in);

        // Ornek bir dizi olustur
        int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3, 14};

        System.out.print("Aranacak degeri girin: ");
        int aranan = tarayici.nextInt();
        
        DogrusalArama arayici = new DogrusalArama();
        arayici.dogrusalArama(dizi, aranan);

        tarayici.close();
    }
}
