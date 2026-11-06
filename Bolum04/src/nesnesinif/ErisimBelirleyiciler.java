package nesnesinif;

// Erisim belirleyiciler: private alan disaridan yalnizca
// public get/set metotlariyla okunur ve degistirilir.
public class ErisimBelirleyiciler {

	static class BankaHesabi {
		private double hesapBakiyesi;   // gizli alan
		public double getHesapBakiyesi() {
			return hesapBakiyesi;
		}
		public void setHesapBakiyesi(double b) {
			if (b >= 0) hesapBakiyesi = b;  // gecersizi reddet
		}
	}

	public static void main(String[] args) {
		BankaHesabi hesap = new BankaHesabi();
		// baska bir sinifta:
		// hesap.hesapBakiyesi = -500;
		// derleme hatasi: hesapBakiyesi has private access in BankaHesabi
		hesap.setHesapBakiyesi(1000);
		hesap.setHesapBakiyesi(-500);                  // reddedilir
		System.out.println(hesap.getHesapBakiyesi());  // 1000.0
	}
}
