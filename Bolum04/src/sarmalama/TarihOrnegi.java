package sarmalama;

import java.util.Date;

// Sinif adi cakismasi cozumu: biri import edilir (java.util.Date),
// oteki tam adiyla (java.sql.Date) yazilir.
public class TarihOrnegi {
	public static void main(String[] args) {
		Date baslangic = new Date(0);  // java.util
		java.sql.Date kayit =          // tam ad
				java.sql.Date.valueOf("2024-09-16");
		System.out.println(baslangic.getTime());   // 0
		System.out.println(kayit);                 // 2024-09-16
	}
}

/* Beklenen cikti:
0
2024-09-16
*/
