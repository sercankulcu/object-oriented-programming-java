import javax.swing.SwingUtilities;

// invokeLater isi olay kuyruguna birakip hemen doner; invokeAndWait is bitene kadar bekler.
// Isler olay dagitim is parcaciginda (EDT) sirayla calisir.
public class InvokeLaterIzleme {
	public static void main(String[] a) throws Exception {
		System.out.println("1 main");
		SwingUtilities.invokeLater(
				() -> System.out.println("3 is A"));
		SwingUtilities.invokeLater(
				() -> System.out.println("4 is B"));
		System.out.println("2 main devam ediyor");
		SwingUtilities.invokeAndWait(() -> System.out.println(
				"5 is C, EDT mi? " + SwingUtilities.isEventDispatchThread()));
		System.out.println("6 main, EDT mi? "
				+ SwingUtilities.isEventDispatchThread());
		// 1 main
		// 2 main devam ediyor
		// 3 is A
		// 4 is B
		// 5 is C, EDT mi? true
		// 6 main, EDT mi? false
		// Not: "2" ile "3" iki ayri is parcacigindan yazilir; EDT'nin baslamasi zaman aldigi
		// icin pratikte hep bu siradadir, ama bu sira garanti degildir.
	}
}

/* Beklenen cikti:
1 main
2 main devam ediyor
3 is A
4 is B
5 is C, EDT mi? true
6 main, EDT mi? false
*/
