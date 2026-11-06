package canli;

// protected: isim alt siniflara (baska paketteki Kedi'ye de) aciktir;
// saglik private oldugu icin yalnizca Hayvan'in kendi kodunda kullanilir.
// "protected Erisimin Ince Kurali" slaytindaki Hayvan bu sinifin alt kumesidir.
public class Hayvan {
	protected String isim;  // alt siniflar
	private double saglik;  // yalnizca Hayvan

	public Hayvan(String isim) {
		this.isim = isim;
		saglik = 100.0;
	}
	public double getSaglik() { return saglik; }
	protected void saglikEkle(double miktar) {
		saglik += miktar;
	}
}
