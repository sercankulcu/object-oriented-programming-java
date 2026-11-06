package sarmalama;

// On ve son kosullar: metodun yorumunda cagiranin saglamasi gereken
// (on kosul) ve metodun garanti ettigi (son kosul) yazilir.
public class OnVeSonKosullar {

	static class OnKosul {
		static class VeriIslemleri {
			// On kosul: veri != null
			public void veriEkle(String veri) {
				// verinin null olup olmadigini kontrol et
				// ...
			}
		}
	}

	static class SonKosul {
		static class VeriIslemleri {
			// Son kosul: veri tabanina veri eklendiyse true doner
			public boolean veriEkle(String veri) {
				// veriyi ekleyip eklemedigini kontrol et
				// ...
				return true;
			}
		}
	}

	public static void main(String[] args) {
		new OnKosul.VeriIslemleri().veriEkle("Ali");      // ciktisi yok
		System.out.println(new SonKosul.VeriIslemleri().veriEkle("Ali"));  // true
	}
}
