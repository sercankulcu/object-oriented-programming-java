package kalitim;

// Nesnenin gorunumunu kisitlama: Parca tipindeki degisken Lastik nesnesinin
// yalnizca Parca kismini gorur; Lastik'e ozgu metot icin instanceof ve donusum gerekir.
public class GorunumKisitlama {

	static class Parca {
		private String marka;
		private String seriNo;
		Parca(String marka, String seriNo) {
			this.marka = marka;
			this.seriNo = seriNo;
		}
		String getMarka() { return marka; }
		String seriNumarasi() { return seriNo; }
	}

	static class Lastik extends Parca {
		private String ebat;
		private boolean kislik;
		Lastik(String marka, String seriNo, String ebat, boolean kislik) {
			super(marka, seriNo);
			this.ebat = ebat;
			this.kislik = kislik;
		}
		String getEbat() { return ebat; }
		boolean kislikMi() { return kislik; }
	}

	public static void main(String[] args) {
		Parca p = new Lastik("Petlas", "XYZ-123", "225/45R17", true);
		System.out.println(p.seriNumarasi());   // XYZ-123   (izin verilir)
		// p.kislikMi()                         // izin verilmez
		// derleme hatasi: cannot find symbol
		//   symbol:   method kislikMi()
		//   location: variable p of type Parca

		// once tip kontrolu, sonra asagi donusum
		if (p instanceof Lastik) {
			Lastik l = (Lastik) p;
			System.out.println(l.kislikMi() + " " + l.getEbat());   // true 225/45R17
		}
	}
}
