// Runnable arayuzu: tek metotlu (run) islevsel arayuz; sinifla ya da lambda ile uygulanir.
// JDK'daki tanim (burada yeniden yazilmaz, java.lang paketinde hazirdir):
//     package java.lang;
//
//     public interface Runnable {
//         void run();
//     }
public class RunnableArayuzu {

	public static class MyRunnable implements Runnable {
		@Override
		public void run() {
			// Is parcaciginin yapmasi gereken gorevler
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new MyRunnable());
		t.start();
		t.join();
		System.out.println("MyRunnable bitti: " + t.getState());  // MyRunnable bitti: TERMINATED

		Runnable r = () -> System.out.println("merhaba");
		r.run();                                                  // merhaba
		Thread t2 = new Thread(r);
		t2.start();                                               // merhaba
		t2.join();
	}
}

/* Beklenen cikti:
MyRunnable bitti: TERMINATED
merhaba
merhaba
*/
