package sarmalama;

// Erisim belirleyiciler: sinif ve metot public, alanlar private;
// baska sinif alana dogrudan degil, metotla ulasir.
public class ErisimBelirleyiciler {

	static class Ogrenci {      // herkese acik sinif
		private String ad;      // gizli alan
		private int not;        // gizli alan

		public int getNot() {   // acik metot
			return not;
		}
	}

	static class DijitalSaat {
		private int saniye;
		public int getSaniye() {
			return saniye;
		}
	}

	// private alana erisim denemesi (ayri Test sinifinda):
	// DijitalSaat s = new DijitalSaat();
	// s.saniye = 75;
	// Test.java:4: error: saniye has private access in DijitalSaat
	static class Test {
		public static void main(String[] args) {
			DijitalSaat s = new DijitalSaat();
			System.out.println(s.getSaniye());   // 0
		}
	}

	public static void main(String[] args) {
		Ogrenci o = new Ogrenci();
		System.out.println(o.getNot());          // 0
		System.out.println(o.ad);                // null (ayni dosyadan erisim)
		Test.main(args);                         // 0
	}
}
