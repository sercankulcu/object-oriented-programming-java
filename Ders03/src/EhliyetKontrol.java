import java.util.Scanner;

public class EhliyetKontrol {
    public static void main(String[] args) {
        Scanner klavye = new Scanner(System.in);

        System.out.print("Yaşınızı girin: ");
        int yas = klavye.nextInt();

        if (yas >= 18) {
            System.out.println("Ehliyet alabilirsiniz.");
        } else {
            System.out.println("Ehliyet alamazsınız.");
        }

        klavye.close();
    }
}
