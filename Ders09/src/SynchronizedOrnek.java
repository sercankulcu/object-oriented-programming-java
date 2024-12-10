
public class SynchronizedOrnek {

    public static void main(String[] args) {
        Counter counter = new Counter(); // Sayac nesnesi olustur

        // Arttirma islemi yapan birinci thread
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.arttir();
            }
        });

        // Arttirma islemi yapan ikinci thread
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.arttir();
            }
        });

        // Azaltma islemi yapan ucuncu thread
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.azalt();
            }
        });

        // Azaltma islemi yapan dorduncu thread
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 3000; i++) {
                counter.azalt();
            }
        });

        // Thread'leri baslat
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Ana thread diger thread'lerin tamamlanmasini bekler
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Son sonucu yazdir
        System.out.println("Son sayac degeri: " + counter.getSayac());

        // Sayac sifirlaniyor
        counter.sifirla();
        System.out.println("Sayac sifirlandi. Yeni deger: " + counter.getSayac());
    }
}

// Counter sinifi: Paylasilan kaynak
class Counter {

    private int sayac = 0; // Sayac degeri
    private final int ALT_LIMIT = -8000; // Sayac limiti
    private final int UST_LIMIT = 20000; // Sayac limiti

    // Sayaci arttirmak icin synchronized metod
    public synchronized void arttir() {
        if (sayac >= UST_LIMIT) {
            System.out.println("Uyari: Sayac limiti asildi! [" + sayac + "]");
            return;
        }
        sayac++;
    }

    // Sayaci azaltmak icin synchronized metod
    public synchronized void azalt() {
        if (sayac <= ALT_LIMIT) {
            System.out.println("Uyari: Sayac zaten 0'da! [" + sayac + "]");
            return;
        }
        sayac--;
    }

    // Sayac degerini almak icin synchronized metod
    public synchronized int getSayac() {
        return sayac;
    }

    // Sayac sifirlama islemi icin metod
    public synchronized void sifirla() {
        sayac = 0;
        System.out.println("Sayac sifirlandi.");
    }
}
