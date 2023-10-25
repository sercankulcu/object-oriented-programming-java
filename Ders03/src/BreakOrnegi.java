public class BreakOrnegi {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Döngüyü kırdık!");
                break;
            }
            System.out.println("Döngü adımı: " + i);
        }
    }
}
