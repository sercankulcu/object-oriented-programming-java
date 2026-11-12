public class Jdb { // jdb ile hata ayiklama; satir numaralari sunumdakiyle ayni tutuldu
	static int kare(int x) {
		int sonuc = x * x;
		return sonuc;
	}

	public static void main(String[] args) {
		int toplam = 0;
		for (int i = 1; i <= 3; i++) {
			toplam += kare(i);
		}
		System.out.println("Toplam: " + toplam);   // Toplam: 14
	}
}
// Calistirma:   javac -g Jdb.java   ve   jdb Jdb
// Oturum:       stop at Jdb:4, run, where, locals, cont, print sonuc, clear Jdb:4, cont

/* Beklenen cikti:
Toplam: 14
*/
