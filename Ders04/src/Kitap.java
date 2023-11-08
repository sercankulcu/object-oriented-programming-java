
public class Kitap {
	// Örnek Alanlar
	private String baslik;
	private String yazar;
	private int sayfaSayisi;

	// Sınıf Alanı
	private static int toplamKitapSayisi;

	// final Modifikatörlü Bir Alan (Sabit)
	public static final double PI = 3.14159265359;
	
	public String getBaslik() {
		return baslik;
	}
	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}
	public String getYazar() {
		return yazar;
	}
	public void setYazar(String yazar) {
		this.yazar = yazar;
	}
	public int getSayfaSayisi() {
		return sayfaSayisi;
	}
	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}
	public static int getToplamKitapSayisi() {
		return toplamKitapSayisi;
	}
	public static void setToplamKitapSayisi(int toplamKitapSayisi) {
		Kitap.toplamKitapSayisi = toplamKitapSayisi;
	}


}
