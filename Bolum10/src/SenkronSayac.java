// Yarisi onlemek: sayacin metotlari synchronized oldugunda iki is parcacigi artislari kaybetmez.
public class SenkronSayac {

	static class Sayac {
		private int deger = 0;
		public synchronized void arttir() { deger++; }
		public synchronized int getDeger() { return deger; }
	}

	public static void main(String[] args)
			throws InterruptedException {
		Sayac sayac = new Sayac();
		Runnable gorev = () -> {
			for (int i = 0; i < 100_000; i++) {
				sayac.arttir();
			}
		};
		Thread t1 = new Thread(gorev);
		Thread t2 = new Thread(gorev);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Sonuc: " + sayac.getDeger());   // Sonuc: 200000
	}
}
