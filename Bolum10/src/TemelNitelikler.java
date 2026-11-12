import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

// Is parcaciginin temel nitelikleri (ad, kimlik, oncelik, grup, daemon, durum)
// ve JVM'deki butun is parcaciklarinin gruplari.
public class TemelNitelikler {

	static void nitelikler() {
		Thread t = Thread.currentThread();   // calisan
		System.out.println("Ad      : " + t.getName());           // Ad      : main
		// threadId(): Java 19+ (oncesinde getId())
		System.out.println("Kimlik  : " + t.threadId());         // Kimlik  : 1
		System.out.println("Oncelik : " + t.getPriority());      // Oncelik : 5
		String grup = t.getThreadGroup().getName();
		System.out.println("Grup    : " + grup);                  // Grup    : main
		System.out.println("Daemon  : " + t.isDaemon());         // Daemon  : false
		System.out.println("Durum   : " + t.getState());         // Durum   : RUNNABLE
	}

	// Is Parcacigi Gruplari: kumenin sirasi her calistirmada degisebildigi icin
	// satirlar once listeye alinip siralaniyor (sunumda dogrudan yazdiriliyor).
	static void gruplar() {
		Set<Thread> hepsi =
				Thread.getAllStackTraces().keySet();
		List<String> satirlar = new ArrayList<>();
		for (Thread t : hepsi) {
			satirlar.add(t.getThreadGroup().getName()
					+ "  " + t.getName()
					+ "  daemon=" + t.isDaemon());
		}
		Collections.sort(satirlar);
		for (String s : satirlar)
			System.out.println(s);
		// InnocuousThreadGroup  Common-Cleaner  daemon=true
		// main  main  daemon=false
		// system  Attach Listener  daemon=true
		// system  Finalizer  daemon=true
		// system  Notification Thread  daemon=true
		// system  Reference Handler  daemon=true
		// system  Signal Dispatcher  daemon=true
	}

	public static void main(String[] args) {
		nitelikler();
		gruplar();
	}
}

/* Not: bu programin ciktisi her calistirmada degisir: JVM'nin kendi is parcaciklari (Attach Listener,
   Finalizer, ...) surume ve ortama gore farklidir; asagidaki bir ornek calistirmadir. */
/* Beklenen cikti:
Ad      : main
Kimlik  : 1
Oncelik : 5
Grup    : main
Daemon  : false
Durum   : RUNNABLE
InnocuousThreadGroup  Common-Cleaner  daemon=true
main  main  daemon=false
system  Attach Listener  daemon=true
system  Finalizer  daemon=true
system  Notification Thread  daemon=true
system  Reference Handler  daemon=true
system  Signal Dispatcher  daemon=true
*/
