// Gerekli Java kutuphaneleri iceri aktar
import java.util.ArrayList; 
import java.util.List;
import java.util.Random;

// Konsol uzerinde top animasyonu yapan bir program
public class KonsoldaTopAnimasyonu {
    // Konsol ekraninin genisligi ve yuksekligi
    private static final int GENISLIK = 50;
    private static final int YUKSEKLIK = 20;

    // Top sinifi, topun pozisyonunu ve hareket yonunu temsil eder
    private static class Top {
        int x; // X koordinati
        int y; // Y koordinati
        int xYon; // X ekseninde hareket yonu
        int yYon; // Y ekseninde hareket yonu

        // Top nesnesi olusturucu (constructor)
        public Top(int x, int y, int xYon, int yYon) {
            this.x = x;
            this.y = y;
            this.xYon = xYon;
            this.yYon = yYon;
        }

        // Topun hareketini hesaplayan metot
        public void hareketEt() {
            x += xYon;
            y += yYon;

            // Kenarlara carpinca yonu ters cevir
            if (x <= 0 || x >= GENISLIK - 1) {
                xYon *= -1;
            }
            if (y <= 0 || y >= YUKSEKLIK - 1) {
                yYon *= -1;
            }
        }
    }

    // Programin ana metodu
    public static void main(String[] args) throws InterruptedException {
        List<Top> toplar = new ArrayList<>();

        // Toplari olustur
        toplarOlustur(toplar);

        // Animasyon dongusu
        while (true) {
            toplariHareketEttir(toplar);
            ekraniYazdir(toplar);
            Thread.sleep(100); // Daha iyi gorunur bir animasyon icin gecikme
        }
    }

    // Rastgele toplar olusturan metot
    private static void toplarOlustur(List<Top> toplar) {
        Random rastgele = new Random();
        for (int i = 0; i < 5; i++) {
            toplar.add(new Top(
                rastgele.nextInt(GENISLIK), 
                rastgele.nextInt(YUKSEKLIK), 
                rastgele.nextBoolean() ? 1 : -1, 
                rastgele.nextBoolean() ? 1 : -1
            ));
        }
    }

    // Toplarin hareket etmesini saglayan metot
    private static void toplariHareketEttir(List<Top> toplar) {
        for (Top top : toplar) {
            top.hareketEt();
        }
    }

    // Konsola toplarin yerlesimini yazdiran metot
    private static void ekraniYazdir(List<Top> toplar) {
        System.out.print("\033[H\033[2J"); // Konsolu temizle  
        for (int i = 0; i < YUKSEKLIK; i++) {
            for (int j = 0; j < GENISLIK; j++) {
                char sembol = ' '; // Varsayilan olarak bosluk
                for (Top top : toplar) {
                    if (top.x == j && top.y == i) {
                        sembol = 'O'; // Top sembolu
                    }
                }
                System.out.print(sembol);
            }
            System.out.println();
        }
    }
}
