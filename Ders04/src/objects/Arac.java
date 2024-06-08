package objects;

public class Arac {
	
	private String marka;
	private String model;
	private int yil;

	// Varsayılan yapıcı metot
	public Arac() {
		marka = "Bilinmiyor";
		model = "Bilinmiyor";
		yil = 0;
	}

	// Ana metod (main method) içinde kullanımı
	public static void main(String[] args) {
				
		Arac arac = new Arac(); // Varsayılan yapıcı metot kullanılıyor

		System.out.println("Marka: " + arac.marka);
		System.out.println("Model: " + arac.model);
		System.out.println("Yıl: " + arac.yil);
	}
}
