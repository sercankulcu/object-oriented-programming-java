
public class ThreadOrnegi extends Thread {

    private String mesaj; // Yazdirilacak mesaj
    private int gecikme; // Gecikme suresi (milisaniye cinsinden)
    private volatile boolean calisiyor = true; // Thread'in calisma durumu

    // Constructor: Mesaj ve gecikme suresi ile nesne olusturur
    public ThreadOrnegi(String mesaj, int gecikme) {
        this.mesaj = mesaj;
        this.gecikme = gecikme;
    }

    // Thread'in calisacak metodu
    public void run() {
        int sayac = 0;
        while (calisiyor) {
            System.out.println(Thread.currentThread().getName() + ": " + mesaj + " [" + sayac + "]");
            try {
                Thread.sleep(gecikme); // Belirtilen sure kadar bekle
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " kesildi.");
                return; // Thread sonlandirilir
            }
            sayac++;
        }
        System.out.println(Thread.currentThread().getName() + " durduruldu.");
    }

    // Thread'i durdurma metodu
    public void durdur() {
        calisiyor = false;
    }

    // Ana metod
    public static void main(String[] args) {
        // Thread nesnelerini olustur ve adlandir
    	ThreadOrnegi thread1 = new ThreadOrnegi("ali", 1000);
        Thread t1 = new Thread(thread1, "Thread-1");
        
        ThreadOrnegi thread2 = new ThreadOrnegi("veli", 2000);
        Thread t2 = new Thread(thread2, "Thread-2");
        
        ThreadOrnegi thread3 = new ThreadOrnegi("ayse", 3000);
        Thread t3 = new Thread(thread3, "Thread-3");

        // Thread'leri baslat
        t1.start();
        t2.start();
        t3.start();

        // Ana thread'de baska isler yap
        for (int i = 0; i < 5; i++) {
            System.out.println("Ana thread is yapiyor: " + i);
            try {
                Thread.sleep(500); // 0.5 saniye uyur
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Belirli bir sure sonra tum thread'leri durdur
        try {
            Thread.sleep(10000); // 10 saniye bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tum thread'ler durduruluyor...");
        thread1.durdur();
        thread2.durdur();
        thread3.durdur();

        // Tum thread'lerin tamamlanmasini bekle
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program tamamlandi.");
    }
}
