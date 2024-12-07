package forloop;

public class BreakOrnegi {

    // For dongusunde break kullanimi
    public static void forDongusuOrnegi() {
        System.out.println("For dongusu ornegi:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) { // Deger 5 oldugunda dongu kirilir
                System.out.println("Dongu 5 degerinde kirildi!");
                break;
            }
            System.out.println("Dongu adimi: " + i);
        }
    }

    // While dongusunde break kullanimi
    public static void whileDongusuOrnegi() {
        System.out.println("\nWhile dongusu ornegi:");
        int i = 1;
        while (i <= 10) {
            if (i == 7) { // Deger 7 oldugunda dongu kirilir
                System.out.println("Dongu 7 degerinde kirildi!");
                break;
            }
            System.out.println("Dongu adimi: " + i);
            i++;
        }
    }

    // Ic ice dongulerde break kullanimi
    public static void icIceDongulerOrnegi() {
        System.out.println("\nIc ice donguler ornegi:");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (j == 2) { // Ic dongu belirli bir sartta kirilir
                    System.out.println("Ic dongu j = 2 de kirildi (i = " + i + ")");
                    break;
                }
                System.out.println("i: " + i + ", j: " + j);
            }
        }
    }

    public static void main(String[] args) {
        // For dongusu ornegi
        forDongusuOrnegi();

        // While dongusu ornegi
        whileDongusuOrnegi();

        // Ic ice donguler ornegi
        icIceDongulerOrnegi();
    }
}
