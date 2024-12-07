package forloop;

public class ContinueOrnegi {

    // Tek ve cift sayilari ayiran ornek
    public static void tekVeCiftSayilar() {
        System.out.println("Tek ve Cift Sayilar Ornegi:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) { // Cift sayilar kontrol edilir
                System.out.println("Cift sayi: " + i);
                continue; // Cift sayilar icin kalan kod atlanir
            }
            System.out.println("Tek sayi: " + i);
        }
    }

    // 3 ve 5'in katlarini atlayan ornek
    public static void ucVeBesKatlari() {
        System.out.println("\n3 ve 5'in Katlarini Atlayan Ornek:");
        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0 || i % 5 == 0) { // 3 veya 5'in kati kontrol edilir
                System.out.println("Atlanan sayi: " + i);
                continue; // 3 veya 5'in katlari icin kalan kod atlanir
            }
            System.out.println("Gecerli sayi: " + i);
        }
    }

    // Ic ice dongulerde continue kullanimi
    public static void icIceDonguler() {
        System.out.println("\nIc Ice Dongulerde Continue Ornegi:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == j) { // i ve j esit oldugunda atlanir
                    System.out.println("i: " + i + ", j: " + j + " -> Continue uygulandi");
                    continue; // Bu sart saglandiginda ic dongu bir sonraki iterasyona gecer
                }
                System.out.println("i: " + i + ", j: " + j);
            }
        }
    }

    public static void main(String[] args) {
        // Tek ve cift sayilarin ayristirildigi ornek
        tekVeCiftSayilar();

        // 3 ve 5'in katlarini atlayan ornek
        ucVeBesKatlari();

        // Ic ice dongulerde continue kullanimi
        icIceDonguler();
    }
}
