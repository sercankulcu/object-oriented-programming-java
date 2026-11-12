package nesnesinif;

// Parametresiz ve parametreli yapici: ayni sinifta iki yapici
// (yapici asiri yuklemesi).
public class Arac {
	private String marka;
	private String model;
	private int yil;
	public Arac() {                 // parametresiz yapici
		marka = "Bilinmiyor";
		model = "Bilinmiyor";
		yil = 0;
	}
	public Arac(String marka, String model, int yil) {
		this.marka = marka;
		this.model = model;
		this.yil = yil;
	}
	public void bilgiYazdir() {
		System.out.println(marka + " " + model + " " + yil);
	}
	public static void main(String[] args) {
		Arac a1 = new Arac();
		Arac a2 = new Arac("Renault", "Clio", 2021);
		a1.bilgiYazdir();   // Bilinmiyor Bilinmiyor 0
		a2.bilgiYazdir();   // Renault Clio 2021
	}
}

/* Beklenen cikti:
Bilinmiyor Bilinmiyor 0
Renault Clio 2021
*/
