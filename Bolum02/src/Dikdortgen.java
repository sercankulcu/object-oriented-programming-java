// Nesne yonelimli paradigma: veri (en, boy) ve davranis (alan) bir sinifta.
// Ayni slayttaki Prolog ornegi (ebeveyn/dede kurali) mantiksal paradigmayi
// gosterir; Java karsiligi olmadigi icin burada yalnizca anilir.
public class Dikdortgen {
	double en, boy;          // veri (durum)

	Dikdortgen(double en, double boy) {
		this.en = en;
		this.boy = boy;
	}

	double alan() {          // davranis
		return en * boy;
	}

	public static void main(String[] args) {
		Dikdortgen d = new Dikdortgen(3, 4);
		System.out.println("Alan: " + d.alan());  // Alan: 12.0
	}
}
