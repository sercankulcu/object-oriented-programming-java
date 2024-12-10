
public class RunnableOrnegi implements Runnable {

    private String mesaj; // Yazdirilacak mesaj
    private int gecikme; // Gecikme suresi (milisaniye cinsinden)
    private volatile boolean calisiyor = true; // Thread'in calisma durumu

    // Constructor: Mesaj ve gecikme suresi ile nesne olusturur
    public RunnableOrnegi(String mesaj, int gecikme) {
        this.mesaj = mesaj;
        this.gecikme = gecikme;
    }

    // Thread'in calisacak metodu
    public void run() {
        while (calisiyor) {
            System.out.println(Thread.currentThread().getName() + ": " + mesaj); // Mesaji yazdir
            try {
                Thread.sleep(gecikme); // Belirtilen sure kadar bekle
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " kesildi.");
                return; // Kesinti durumunda thread sonlandirilir
            }
        }
        System.out.println(Thread.currentThread().getName() + " durduruldu.");
    }

    // Thread'i durdurma metodu
    public void durdur() {
        calisiyor = false;
    }

    // Ana metod
    public static void main(String[] args) {
        // Thread nesnelerini tutmak icin
        RunnableOrnegi runnable1 = new RunnableOrnegi("ali", 1000);
        Thread t1 = new Thread(runnable1, "Thread-1");
        
        RunnableOrnegi runnable2 = new RunnableOrnegi("veli", 2000);
        Thread t2 = new Thread(runnable2, "Thread-2");
        
        RunnableOrnegi runnable3 = new RunnableOrnegi("ayse", 3000);
        Thread t3 = new Thread(runnable3, "Thread-3");

        // Thread'leri baslat
        t1.start();
        t2.start();
        t3.start();

        // Belirli bir sure sonra tum thread'leri durdur
        try {
            Thread.sleep(10000); // 10 saniye bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread'ler durduruluyor...");
        runnable1.durdur();
        runnable2.durdur();
        runnable3.durdur();

        try {
            t1.join(); // Thread-1'in bitmesini bekle
            t2.join(); // Thread-2'nin bitmesini bekle
            t3.join(); // Thread-3'un bitmesini bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program sonlandi.");
    }
}
