package sarmalama;

// Neden public alan degil: public alana gecersiz deger yazilabilir;
// private alan ve dogrulayan setter bunu engeller.
public class NedenPublicAlanDegil {

	static class Once {
		static class Saat {
			public int saniye;
		}
	}

	static class Sonra {
		static class Saat {
			private int saniye;
			public void setSaniye(int s) {
				if (s >= 0 && s < 60) saniye = s;
			}
		}
	}

	public static void main(String[] args) {
		Once.Saat s = new Once.Saat();
		// baska bir sinifta:
		s.saniye = -5;   // kabul edilir!
		System.out.println(s.saniye);    // -5

		Sonra.Saat t = new Sonra.Saat();
		t.setSaniye(-5);                 // reddedilir
		System.out.println(t.saniye);    // 0 (ayni dosyadan okunur)
	}
}
