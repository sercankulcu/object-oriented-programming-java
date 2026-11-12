import java.io.*;

// Serilestirme: Serializable bir nesne ObjectOutputStream ile dosyaya yazilir,
// ObjectInputStream ile geri okunur.
class Ogrenci implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ad;
	private int yas;

	public Ogrenci(String ad, int yas) {
		this.ad = ad;
		this.yas = yas;
	}

	public String toString() {
		return "Ogrenci [ad=" + ad + ", yas=" + yas + "]";
	}
}

public class NesneSerilestirme {
	public static void main(String[] args) {
		// Serilestirme islemi
		try (ObjectOutputStream cikti = new ObjectOutputStream(
				new FileOutputStream("ogrenci.ser"))) {
			Ogrenci ogrenci = new Ogrenci("Ahmet", 20);
			cikti.writeObject(ogrenci);
			System.out.println("Serilestirme basarili.");   // Serilestirme basarili.
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ogrenci.ser: " + new File("ogrenci.ser").length() + " byte");   // ogrenci.ser: 72 byte
		// Seriyi okuma islemi
		try (ObjectInputStream girdi = new ObjectInputStream(
				new FileInputStream("ogrenci.ser"))) {
			Ogrenci ogrenci = (Ogrenci) girdi.readObject();
			System.out.println("Ogrenci: " + ogrenci);      // Ogrenci: Ogrenci [ad=Ahmet, yas=20]
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		new File("ogrenci.ser").delete();
	}
}

/* Beklenen cikti:
Serilestirme basarili.
ogrenci.ser: 72 byte
Ogrenci: Ogrenci [ad=Ahmet, yas=20]
*/
