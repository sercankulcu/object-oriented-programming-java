package objects;

public class RasyonelSayi {
	
	private int pay;        // Rasyonel sayinin payini temsil eder
	private int payda;      // Rasyonel sayinin paydasini temsil eder

	public RasyonelSayi(int pay, int payda) {
		this.pay = pay;        // Pay ve payda degerlerini ayarlar
		this.payda = payda;
	}

	// Rasyonel sayiyi basitlestiren metod
	private void basitlestir() {
		int ebob = findEBOB(pay, payda);  // Pay ve payda icin en buyuk ortak boleni hesaplar
		pay /= ebob;        // Pay ve paydayi en buyuk ortak bolen ile bolerek basitlestirir
		payda /= ebob;
	}

	// En buyuk ortak boleni bulan metod
	private int findEBOB(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;   // En buyuk ortak boleni dondurur
	}

	// Iki rasyonel sayiyi toplayan metod
	public RasyonelSayi topla(RasyonelSayi digerSayi) {
		int yeniPay = (this.pay * digerSayi.payda) + (digerSayi.pay * this.payda);  // Iki rasyonel sayiyi toplar
		int yeniPayda = this.payda * digerSayi.payda;
		return new RasyonelSayi(yeniPay, yeniPayda);   // Yeni rasyonel sayiyi dondurur
	}

	// Iki rasyonel sayiyi carpan metod
	public RasyonelSayi carp(RasyonelSayi digerSayi) {
		int yeniPay = this.pay * digerSayi.pay;   // Iki rasyonel sayiyi carpar
		int yeniPayda = this.payda * digerSayi.payda;
		return new RasyonelSayi(yeniPay, yeniPayda);   // Yeni rasyonel sayiyi dondurur
	}

	// Rasyonel sayiyi metinsel olarak temsil eden metod
	public String toString() {
		return pay + "/" + payda;   // Rasyonel sayiyi metinsel olarak temsil eder
	}

	// Main metodunda rasyonel sayilari kullanma
	public static void main(String[] args) {
		
		// Kullaniciya sayi girmesi icin bir mesaj
		System.out.println("Iki rasyonel sayi girin:");
		RasyonelSayi sayi1 = new RasyonelSayi(8, 10);  // Ilk rasyonel sayiyi olusturur
		RasyonelSayi sayi2 = new RasyonelSayi(2, 3);  // Ikinci rasyonel sayiyi olusturur
		RasyonelSayi sayi3 = new RasyonelSayi(9, 3);

		// Rasyonel sayilarin toplami
		RasyonelSayi toplam = sayi1.topla(sayi2);  
		System.out.println("Rasyonel sayilarin toplami: " + toplam);

		// Rasyonel sayilarin carpimi
		RasyonelSayi carpim = sayi1.carp(sayi2);  
		System.out.println("Rasyonel sayilarin carpimi: " + carpim);

		// Pay ve payda degerlerinin kontrol edilmesi
		System.out.println("Sayi 1 - Pay: " + sayi1.pay + ", Payda: " + sayi1.payda);
		System.out.println("Sayi 2 - Pay: " + sayi2.pay + ", Payda: " + sayi2.payda);

		// Bir sayinin negatif olup olmadigini kontrol etme
		if (sayi1.pay < 0 || sayi1.payda < 0) {
			System.out.println("Sayi 1 negatif degerlere sahip.");
		}

		// Toplam ve carpim sayilarinin basitlestirilmis halleri
		RasyonelSayi basitToplam = new RasyonelSayi(toplam.pay, toplam.payda);
		RasyonelSayi basitCarpim = new RasyonelSayi(carpim.pay, carpim.payda);

		System.out.println("Basitlestirilmis Toplam: " + basitToplam);
		System.out.println("Basitlestirilmis Carpim: " + basitCarpim);
		
		// Ekstra islemler
		int pay1 = sayi3.pay;
		int payda1 = sayi3.payda;

		if (pay1 % payda1 == 0) {
			System.out.println("Sayi 3 bir tam sayidir.");
		} else {
			System.out.println("Sayi 3 bir kesirli sayidir.");
		}
		
		sayi1.basitlestir();
		sayi2.basitlestir();
		// Kullaniciya basitlestirilmis hali gosterme
		System.out.println("Sayi 1'in basitlestirilmis hali: " + sayi1);
		System.out.println("Sayi 2'nin basitlestirilmis hali: " + sayi2);
	}
}
