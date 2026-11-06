import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Hazir cozum: java.util.concurrent.ArrayBlockingQueue; put() doluysa, take() bossa bekler.
public class HazirKuyruk {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> kuyruk =
				new ArrayBlockingQueue<>(2);
		Thread uretici = new Thread(() -> {
			try {
				// put(): kuyruk doluysa bekler
				for (int i = 1; i <= 4; i++) kuyruk.put(i);
			} catch (InterruptedException e) { }
		});
		uretici.start();
		for (int i = 1; i <= 4; i++) {
			// take(): kuyruk bossa bekler
			System.out.print(kuyruk.take() + " ");
		}
		System.out.println();   // 1 2 3 4
		uretici.join();
	}
}
