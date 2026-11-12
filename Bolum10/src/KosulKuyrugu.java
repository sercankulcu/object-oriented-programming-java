import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Condition arayuzu: sinirli kuyruk Lock ve iki kosul (doluDegil, bosDegil) ile yazilir;
// await/signal, wait/notify'in yerini alir.
public class KosulKuyrugu {

	static class BlockingQueue {
		private final Lock kilit = new ReentrantLock();
		private final Condition doluDegil =
				kilit.newCondition();
		private final Condition bosDegil =
				kilit.newCondition();
		private Object[] veri;
		private int bas = 0;
		private int son = 0;
		private int buyukluk = 0;
		public BlockingQueue(int boyut) {
			veri = new Object[boyut];
		}

		public void add(Object oge)
				throws InterruptedException {
			kilit.lock();
			try {
				while (buyukluk == veri.length)
					doluDegil.await();
				veri[son] = oge;
				son = (son + 1) % veri.length;
				buyukluk++;
				bosDegil.signal();
			} finally {
				kilit.unlock();
			}
		}

		public Object remove()
				throws InterruptedException {
			kilit.lock();
			try {
				while (buyukluk == 0)
					bosDegil.await();
				Object oge = veri[bas];
				bas = (bas + 1) % veri.length;
				buyukluk--;
				doluDegil.signal();
				return oge;
			} finally {
				kilit.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue kuyruk = new BlockingQueue(2);
		Thread uretici = new Thread(() -> {
			try {
				for (int i = 1; i <= 4; i++) kuyruk.add(i);
			} catch (InterruptedException e) { }
		});
		uretici.start();
		for (int i = 1; i <= 4; i++) {
			System.out.print(kuyruk.remove() + " ");
		}
		System.out.println();   // 1 2 3 4
		uretici.join();
	}
}

/* Beklenen cikti:
1 2 3 4
*/
