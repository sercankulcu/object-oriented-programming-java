// Genelleme: sabit davranisli metodu parametre alarak genel hale getirmek.
public class Genelleme {
	// Ozel: yalnizca 10 tane '-' yazar
	static void cizgiCiz() {
		System.out.println("----------");
	}
	// Genel: uzunlugu ve karakteri parametre
	static void cizgiCiz(int uzunluk, char karakter) {
		for (int i = 0; i < uzunluk; i++) {
			System.out.print(karakter);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		cizgiCiz();              // ----------
		cizgiCiz(5, '*');        // *****
		cizgiCiz(12, '=');       // ============
	}
}

/* Beklenen cikti:
----------
*****
============
*/
