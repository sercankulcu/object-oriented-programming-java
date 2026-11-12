package nesnesinif;

// Tasarim ornegi: RasyonelSayi temsili (pay, payda) gizler; yapici
// kesri ebob ile sadelestirir, gizli yardimci metot disaridan gorulmez.
public class RasyonelSayi {
	// Temsil: gizli alanlar
	private int pay, payda;
	// Tanimlama: public yapici ve metotlar
	public RasyonelSayi(int pay, int payda) {
		int e = ebob(Math.abs(pay), Math.abs(payda));
		this.pay = pay / e;
		this.payda = payda / e;
	}
	public RasyonelSayi topla(RasyonelSayi d) {
		int yeniPay = pay * d.payda + d.pay * payda;
		return new RasyonelSayi(yeniPay, payda * d.payda);
	}
	@Override
	public String toString() { return pay + "/" + payda; }
	// Gercekleme ayrintisi: gizli yardimci metot
	private static int ebob(int a, int b) {
		while (b != 0) { int k = a % b; a = b; b = k; }
		return a;
	}

	public static void main(String[] args) {
		RasyonelSayi a = new RasyonelSayi(8, 10);
		RasyonelSayi b = new RasyonelSayi(2, 3);
		System.out.println(a);              // 4/5
		System.out.println(a.topla(b));     // 22/15

		// Kod izleme:
		RasyonelSayi c = new RasyonelSayi(6, 8);
		RasyonelSayi d = new RasyonelSayi(1, 6);
		System.out.println(c.topla(d) + " " + c);   // 11/12 3/4
	}
}

/* Beklenen cikti:
4/5
22/15
11/12 3/4
*/
