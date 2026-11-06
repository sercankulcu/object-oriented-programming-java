// join(): main, hesap is parcacigi bitene kadar bekler; join'den once sonuc henuz 0'dir.
public class JoinOrnegi {
	static long sonuc = 0;
	public static void main(String[] args)
			throws InterruptedException {
		Thread hesap = new Thread(() -> {
			long toplam = 0;
			for (int i = 1; i <= 1_000_000; i++) {
				toplam += i;
			}
			sonuc = toplam;
		});
		hesap.start();
		System.out.println("join oncesi : " + sonuc);   // join oncesi : 0
		hesap.join();   // hesap bitene kadar bekle
		System.out.println("join sonrasi: " + sonuc);   // join sonrasi: 500000500000
	}
}
