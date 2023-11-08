
public class RasyonelSayi {
	private int pay;        // Rasyonel sayının payını temsil eder
	private int payda;      // Rasyonel sayının paydasını temsil eder

	public RasyonelSayi(int pay, int payda) {
		this.pay = pay;        // Pay ve payda değerlerini ayarlar
		this.payda = payda;
		basitlestir(); // Rasyonel sayıları basitleştir
	}

	private void basitlestir() {
		int ebob = findEBOB(pay, payda);  // Pay ve payda için en büyük ortak böleni hesaplar
		pay /= ebob;        // Pay ve payda'yı en büyük ortak bölen ile bölerek basitleştirir
		payda /= ebob;
	}

	private int findEBOB(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;   // En büyük ortak böleni döndürür
	}

	public RasyonelSayi topla(RasyonelSayi digerSayi) {
		int yeniPay = (this.pay * digerSayi.payda) + (digerSayi.pay * this.payda);  // İki rasyonel sayıyı toplar
		int yeniPayda = this.payda * digerSayi.payda;
		return new RasyonelSayi(yeniPay, yeniPayda);   // Yeni rasyonel sayıyı döndürür
	}

	public RasyonelSayi carp(RasyonelSayi digerSayi) {
		int yeniPay = this.pay * digerSayi.pay;   // İki rasyonel sayıyı çarpar
		int yeniPayda = this.payda * digerSayi.payda;
		return new RasyonelSayi(yeniPay, yeniPayda);   // Yeni rasyonel sayıyı döndürür
	}

	public String toString() {
		return pay + "/" + payda;   // Rasyonel sayıyı metinsel olarak temsil eder
	}

	public static void main(String[] args) {
		RasyonelSayi sayi1 = new RasyonelSayi(2, 3);   // İlk rasyonel sayıyı oluşturur
		RasyonelSayi sayi2 = new RasyonelSayi(1, 4);   // İkinci rasyonel sayıyı oluşturur

		RasyonelSayi toplam = sayi1.topla(sayi2);   // İki rasyonel sayıyı toplar
		System.out.println("Toplam: " + toplam);

		RasyonelSayi carpim = sayi1.carp(sayi2);   // İki rasyonel sayıyı çarpar
		System.out.println("Çarpım: " + carpim);
	}
}

