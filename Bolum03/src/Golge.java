// Isim Cakismasi: yerel degisken ayni adli sinif alanini golgeler; Golge.deger alana erisir.
public class Golge {
	static int deger = 10;  // sinif alani
	static void goster() {
		int deger = 5;      // alani golgeler
		System.out.println(deger);            // 5
		System.out.println(Golge.deger);      // 10
	}
	public static void main(String[] args) {
		goster();
		System.out.println(deger);            // 10
	}
}

/* Beklenen cikti:
5
10
10
*/
