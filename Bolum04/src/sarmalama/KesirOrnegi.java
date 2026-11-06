package sarmalama;

// private sinif duzeyindedir: Kesir'in kodu, baska bir Kesir
// nesnesinin private alanlarina erisebilir.
public class KesirOrnegi {

	static class Kesir {
		private int pay, payda;
		Kesir(int pay, int payda) {
			this.pay = pay;
			this.payda = payda;
		}
		Kesir carp(Kesir diger) {
			// diger'in private alanlari: izinli
			return new Kesir(pay * diger.pay,
							 payda * diger.payda);
		}
		@Override public String toString() {
			return pay + "/" + payda;
		}
	}

	public static void main(String[] args) {
		// main icinde:
		Kesir k = new Kesir(2, 3).carp(new Kesir(3, 4));
		System.out.println(k);   // 6/12
		// Kesir disindaki bir siniftan: System.out.println(k.pay);
		// derleme hatasi: pay has private access in Kesir
	}
}
