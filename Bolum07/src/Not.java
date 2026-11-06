// Sinir degerleri: harf notu araliklarinin sinirlari (0, 49/50, 59/60, 89/90, 100)
// testlerin en cok hata yakaladigi yerlerdir.
public class Not {
	public static String harfNotu(int puan) {
		if (puan < 0 || puan > 100) {
			throw new IllegalArgumentException("Gecersiz puan: " + puan);
		}
		if (puan >= 90) return "AA";
		if (puan >= 80) return "BA";
		if (puan >= 70) return "BB";
		if (puan >= 60) return "CB";
		if (puan >= 50) return "CC";
		return "FF";
	}

	public static void main(String[] args) {
		System.out.println(harfNotu(49) + " " + harfNotu(50) + " " + harfNotu(90));   // FF CC AA
		try {
			harfNotu(101);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());   // Gecersiz puan: 101
		}
	}
}
