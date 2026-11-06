package nesnesinif;

// enum (numaralandirma tipi): sabit degerler kumesi; values(),
// valueOf() ve ordinal() metotlari.
public class GunTesti {

	enum HaftaGunleri {
		PAZARTESI, SALI, CARSAMBA, PERSEMBE,
		CUMA, CUMARTESI, PAZAR
	}

	public static void main(String[] args) {
		HaftaGunleri[] tumGunler = HaftaGunleri.values();
		HaftaGunleri persembe = HaftaGunleri.valueOf("PERSEMBE");
		System.out.println(tumGunler.length + " gun");              // 7 gun
		System.out.println(persembe + " " + persembe.ordinal());    // PERSEMBE 3
		for (HaftaGunleri gun : tumGunler) {
			boolean haftaSonu = gun == HaftaGunleri.CUMARTESI
					|| gun == HaftaGunleri.PAZAR;
			if (haftaSonu) {
				System.out.println(gun + ": hafta sonu");
			}
		}
		// CUMARTESI: hafta sonu
		// PAZAR: hafta sonu
	}
}
