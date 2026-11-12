package kalitim;

// Kirilgan ust sinif: SayanListe, ust sinifin hepsiniEkle()'nin ekle()'yi
// cagirdigini bilmedigi icin iki kez sayar. Olusumla (iletme) cozum: SayanListe2.
public class KirilganUstSinif {

	static class Liste {
		private String[] ogeler = new String[10];
		private int boyut;
		void ekle(String s) { ogeler[boyut++] = s; }
		void hepsiniEkle(String[] dizi) {
			for (String s : dizi) ekle(s);
		}
		int boyut() { return boyut; }
		String oge(int i) { return ogeler[i]; }
	}

	static class SayanListe extends Liste {
		int eklemeSayisi = 0;
		@Override void ekle(String s) {
			eklemeSayisi++;
			super.ekle(s);
		}
		@Override void hepsiniEkle(String[] dizi) {
			eklemeSayisi += dizi.length;
			super.hepsiniEkle(dizi);
		}
	}

	// Olusumla Cozum: Iletme
	static class SayanListe2 {
		private final Liste liste = new Liste(); // has-a
		private int eklemeSayisi = 0;
		void ekle(String s) {
			eklemeSayisi++;
			liste.ekle(s);            // iletir
		}
		void hepsiniEkle(String[] dizi) {
			eklemeSayisi += dizi.length;
			liste.hepsiniEkle(dizi);  // iletir
		}
		int getEklemeSayisi() { return eklemeSayisi; }
		int boyut() { return liste.boyut(); }
	}

	public static void main(String[] args) {
		SayanListe l = new SayanListe();
		l.hepsiniEkle(new String[] {"a", "b", "c"});
		System.out.println(l.eklemeSayisi + " " + l.boyut());   // 6 3

		SayanListe2 l2 = new SayanListe2();
		l2.hepsiniEkle(new String[] {"a", "b", "c"});
		System.out.println(l2.getEklemeSayisi()
			+ " " + l2.boyut());                                // 3 3
		l2.ekle("d");
		System.out.println(l2.getEklemeSayisi() + " " + l2.boyut());   // 4 4
	}
}

/* Beklenen cikti:
6 3
3 3
4 4
*/
