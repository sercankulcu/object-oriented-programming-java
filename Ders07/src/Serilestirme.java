import java.io.*;

/*
 * 
 * Bu ornekte, Calisan adinda bir sinif Serializable arayuzunu gerceklemektedir.
 * Bu sayede Calisan sinifindan olusturulan bir nesne ObjectOutputStream sinifi 
 * kullanilarak bir dosyaya serilestirilebilir. Daha sonra bu nesne, 
 * ObjectInputStream sinifi kullanilarak deserialization yoluyla dosyadan okunabilir.
 * Deserialization sonucu nesnenin orijinal durumu geri yuklenmektedir.
 * 
 */

public class Serilestirme {

	public static void main(String[] args) {

		// Yeni bir Calisan nesnesi olustur
		Calisan calisan = new Calisan("Ahmet Yilmaz", 54321, "Yazilim Muhendisi");

		// Nesneyi serilestir
		try {
			FileOutputStream dosyaCikisi = new FileOutputStream("calisan.ser");
			ObjectOutputStream cikisAkimi = new ObjectOutputStream(dosyaCikisi);
			cikisAkimi.writeObject(calisan);
			cikisAkimi.close();
			dosyaCikisi.close();
			System.out.println("Calisan nesnesi calisan.ser dosyasina serilestirildi.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Nesneyi deserializasyon ile geri yukle
		Calisan geriYuklenenCalisan = null;
		try {
			FileInputStream dosyaGirisi = new FileInputStream("calisan.ser");
			ObjectInputStream girisAkimi = new ObjectInputStream(dosyaGirisi);
			geriYuklenenCalisan = (Calisan) girisAkimi.readObject();
			girisAkimi.close();
			dosyaGirisi.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Calisan sinifi bulunamadi.");
			c.printStackTrace();
			return;
		}

		// Geri yuklenen calisan bilgilerini yazdir
		System.out.println("Geri Yuklenen Calisan...");
		System.out.println("Isim: " + geriYuklenenCalisan.getIsim());
		System.out.println("ID: " + geriYuklenenCalisan.getID());
		System.out.println("Unvan: " + geriYuklenenCalisan.getUnvan());
	}
}

class Calisan implements Serializable {

	private static final long serialVersionUID = 1L;
	private String isim;
	private int ID;
	private String unvan;

	public Calisan(String isim, int ID, String unvan) {
		this.isim = isim;
		this.ID = ID;
		this.unvan = unvan;
	}

	public String getIsim() {
		return isim;
	}

	public int getID() {
		return ID;
	}

	public String getUnvan() {
		return unvan;
	}
}
