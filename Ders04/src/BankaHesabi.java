
public class BankaHesabi {
	private double hesapBakiyesi;
	private String hesapSahibi;

	// Hesap Bakiyesi Erişimcisi
	public double getHesapBakiyesi() {
		return hesapBakiyesi;
	}

	// Hesap Sahibi Erişimcisi
	public String getHesapSahibi() {
		return hesapSahibi;
	}

	// Hesap Bakiyesi Değiştirici
	public void setHesapBakiyesi(double yeniBakiye) {
		hesapBakiyesi = yeniBakiye;
	}

	// Para Yatır metodu - Dışarıdan para yatırmak için kullanılır
	public void paraYatir(double miktar) {
		hesapBakiyesi += miktar;
	}

	// Para Çek metodu - Dışarıdan para çekmek için kullanılır
	public void paraCek(double miktar) {
		if (miktar <= hesapBakiyesi) {
			hesapBakiyesi -= miktar;
		}
	}

	// Ana metod (main method) içinde kullanımı
	public static void main(String[] args) {
		BankaHesabi hesap = new BankaHesabi();

		hesap.setHesapBakiyesi(5000.0);  // Hesap bakiyesini ayarlar
		double bakiye = hesap.getHesapBakiyesi(); // Hesap bakiyesini okur
		System.out.println("Hesap Bakiyesi: " + bakiye);
		
		hesap.paraYatir(1000.0);
		bakiye = hesap.getHesapBakiyesi(); // Hesap bakiyesini okur
		System.out.println("Hesap Bakiyesi: " + bakiye);
		
		hesap.paraCek(2000.0);
		bakiye = hesap.getHesapBakiyesi(); // Hesap bakiyesini okur
		System.out.println("Hesap Bakiyesi: " + bakiye);
	}
}
