// Profil ornegi: String += her turda yeni nesne uretir, StringBuilder tek tampon kullanir.
// Sureler makineye gore degisir. JFR ile: java -XX:StartFlightRecording=filename=kayit.jfr Profil
public class Profil {
	static String birlestirArti(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += i;  // her turda yeni String
		}
		return s;
	}

	static String birlestirBuilder(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(i);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		long t0 = System.nanoTime();
		String a = birlestirArti(50_000);
		long t1 = System.nanoTime();
		String b = birlestirBuilder(50_000);
		long t2 = System.nanoTime();
		long ms1 = (t1 - t0) / 1_000_000;
		long ms2 = (t2 - t1) / 1_000_000;
		System.out.println("+= : " + ms1 + " ms");   // ornek: += : 873 ms
		System.out.println("SB : " + ms2 + " ms");   // ornek: SB : 2 ms
		System.out.println(a.equals(b));             // true
	}
}
