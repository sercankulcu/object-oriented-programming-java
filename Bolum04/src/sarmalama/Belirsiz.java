package sarmalama;

import java.util.*;
import java.sql.*;

// Sinif adi cakismasi: java.util ve java.sql ikisi de Date icerir;
// yildizli iki import ile kisa ad belirsizdir, tam ad kullanilir.
public class Belirsiz {
	public static void main(String[] args) {
		// Date tarih = null;
		// Belirsiz.java:6: error: reference to Date is ambiguous
		//   both class java.sql.Date in java.sql and
		//   class java.util.Date in java.util match
		java.util.Date tarih = null;   // duzeltme: tam ad
		System.out.println(tarih);     // null
		List<String> liste = new ArrayList<>();   // java.util.* hala kullanilabilir
		System.out.println(liste.size() + " " + Types.INTEGER);   // 0 4 (java.sql.Types)
	}
}

/* Beklenen cikti:
null
0 4
*/
