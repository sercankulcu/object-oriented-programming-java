// Test edilecek sinif: gecersiz islemlerde istisna firlatan banka hesabi.
public class BankaHesabi {
	private double bakiye;
	public BankaHesabi(double bakiye) {
		this.bakiye = bakiye;
	}
	public void yatir(double miktar) {
		if (miktar <= 0) {
			throw new IllegalArgumentException("Gecersiz miktar");
		}
		bakiye += miktar;
	}
	public void cek(double miktar) {
		if (miktar > bakiye) {
			throw new IllegalStateException("Yetersiz bakiye");
		}
		bakiye -= miktar;
	}
	public double getBakiye() {
		return bakiye;
	}

	public static void main(String[] args) {
		BankaHesabi hesap = new BankaHesabi(100);
		hesap.yatir(50);
		hesap.cek(30);
		System.out.println(hesap.getBakiye());   // 120.0
		try {
			hesap.cek(500);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());    // Yetersiz bakiye
		}
		try {
			hesap.yatir(-10);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());    // Gecersiz miktar
		}
	}
}
