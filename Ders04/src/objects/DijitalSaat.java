package objects;

public class DijitalSaat {
	
	private int saat = 0;         // Saat degerini tutar
	private int dakika = 0;       // Dakika degerini tutar
	private int saniye = 0;       // Saniye degerini tutar
	
	// Saniye degerini donduren metod
	public int getSaniye() {
		return this.saniye;
	}
	
	// Saniye degerini ayarlayan metod (0-59 arasinda olmali)
	public void setSaniye(int saniye) {
		if(saniye >= 0 && saniye < 60) {
			this.saniye = saniye;
		}
	}
	
	// Saati, dakikayi ve saniyeyi gosteren metod
	public void goster() {
		System.out.println(saat + ":" + dakika + ":" + saniye);
	}
	
	// Saati arttiran metod (0-23 arasinda doner)
	private void saatiArttir() {
		saat++;
		if(saat > 23) {
			saat = 0;   // Saat 23'ten sonra 0'a doner
		}
	}
	
	// Dakikayi arttiran metod (0-59 arasinda doner)
	private void dakikayiArttir() {
		dakika++;
		if(dakika > 59) {
			dakika = 0;  // Dakika 59'dan sonra 0'a doner
			saatiArttir();  // Her dakika arttiginda saati de arttirir
		}
	}
	
	// Saniyeyi arttiran metod (0-59 arasinda doner)
	public void saniyeyiArttir() {
		saniye++;
		if(saniye > 59) {
			saniye = 0;   // Saniye 59'dan sonra 0'a doner
			dakikayiArttir();  // Her saniye arttiginda dakikayi arttirir
		}
	}
	
	// Saatin guncellenmesini saglayan metod
	public void saatiGuncelle(int saat, int dakika, int saniye) {
		this.saat = saat;
		this.dakika = dakika;
		this.saniye = saniye;
	}

	// Ana metod (main method) icinde kullanimi
	public static void main(String[] args) {
		// Dijital saat nesnesi olusturuluyor
		DijitalSaat saat = new DijitalSaat();
		
		// Baslangic saati, dakika ve saniye ayarlari
		saat.saatiGuncelle(10, 58, 50);
		System.out.println("Baslangic saati:");
		saat.goster();  // ilk gosterim

		// 70 saniye boyunca saniye arttirma islemi
		for(int i = 0; i < 70; i++) {
			saat.saniyeyiArttir();  // Saniyeyi arttir
			System.out.print("Saniye " + (i + 1) + ": ");
			saat.goster();  // Guncellenmis saati goster
		}
		
		// 120 saniye ekleyerek saati bir saat ileri alalim
		System.out.println("\nSaati bir saat ileri aliyoruz...");
		for(int i = 0; i < 120; i++) {
			saat.saniyeyiArttir();  // Yine saniyeleri arttir
		}
		System.out.print("Yeni saat: ");
		saat.goster();  // Guncellenmis saati goster
	}
}
