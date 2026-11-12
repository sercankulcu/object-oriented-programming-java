package sarmalama;

// Tavsiyeler: yardimci metotlar private olur; disaridan yalnizca
// public setNot kullanilir.
public class Tavsiyeler {

	static class Ogrenci {
		private int not;
		private boolean gecerliMi(int deger) {
			return deger >= 0 && deger <= 100;
		}
		public void setNot(int not) {
			if (gecerliMi(not)) this.not = not;
		}
	}

	public static void main(String[] args) {
		Ogrenci o = new Ogrenci();
		o.setNot(120);                 // reddedilir
		System.out.println(o.not);     // 0
		o.setNot(75);
		System.out.println(o.not);     // 75
		// baska bir siniftan: o.gecerliMi(50);
		// derleme hatasi: gecerliMi(int) has private access in Ogrenci
	}
}

/* Beklenen cikti:
0
75
*/
