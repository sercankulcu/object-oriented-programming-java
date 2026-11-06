// Ornek problemler: join ile sira, run()'in durumu degistirmemesi, senkronize olmayan
// Hesap sinifi ve ters sirada kilit alan iki is parcacigi.
public class OrnekProblemler {

	// Problem: yatir senkronize degil; iki is parcacigi ayni anda yatirirsa para kaybolabilir
	static class Hesap {
		private int bakiye = 0;
		void yatir(int m) { bakiye += m; }
		int getBakiye() { return bakiye; }
	}

	// Kilitlenebilecek kod (calistirilmiyor):
	// T1                    // T2
	// synchronized (a) {       synchronized (b) {
	//   synchronized (b) { }     synchronized (a) { }
	// }                        }

	public static void main(String[] args) throws InterruptedException {
		// Ornek Problemler (1)
		Thread t = new Thread(() -> System.out.print("B"));
		System.out.print("A");
		t.start();
		t.join();
		System.out.print("C");
		System.out.println();                    // ABC

		Thread t2 = new Thread(() -> System.out.print("X"));
		System.out.print(t2.getState() + " ");
		t2.run();
		System.out.print(" " + t2.getState());
		System.out.println();                    // NEW X NEW

		// Ornek Problemler (2): tek is parcacigiyla dogru calisir
		Hesap h = new Hesap();
		h.yatir(100);
		h.yatir(50);
		System.out.println(h.getBakiye());       // 150
	}
}
