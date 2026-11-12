import java.util.concurrent.locks.ReentrantLock;

// Yeniden giris: kilidi tutan is parcacigi ayni kilidi tekrar alabilir; getHoldCount kac kez
// alindigini sayar.
public class YenidenGiris {
	static final ReentrantLock kilit =
			new ReentrantLock();
	static void yaz(String yer) {
		System.out.println(yer + kilit.getHoldCount());
	}
	static void dis() {
		kilit.lock();
		try { yaz("dis(): "); ic(); }
		finally { kilit.unlock(); }
	}
	static void ic() {
		kilit.lock();   // beklemeden girer
		try { yaz("ic():  "); }
		finally { kilit.unlock(); }
	}
	public static void main(String[] args) {
		dis();
		yaz("main:  ");
		// dis(): 1
		// ic():  2
		// main:  0
	}
}

/* Beklenen cikti:
dis(): 1
ic():  2
main:  0
*/
