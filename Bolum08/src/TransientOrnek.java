import java.io.*;

// transient alan serilestirilmez (geri okununca null), static alan sinifa aittir ve dosyaya yazilmaz.
class Kullanici implements Serializable {
	private static final long serialVersionUID = 1L;
	static int sayac;
	private String ad;
	private transient String sifre;   // yazilmaz

	Kullanici(String ad, String sifre) {
		this.ad = ad;
		this.sifre = sifre;
	}

	public String toString() {
		return "Kullanici [ad=" + ad + ", sifre=" + sifre + "]";
	}
}

public class TransientOrnek {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Kullanici k = new Kullanici("ayse", "gizli123");
		Kullanici.sayac = 5;
		ObjectOutputStream c = new ObjectOutputStream(
				new FileOutputStream("k.ser"));
		c.writeObject(k);
		c.close();
		Kullanici.sayac = 99;        // static: sinifa ait
		ObjectInputStream g = new ObjectInputStream(
				new FileInputStream("k.ser"));
		Kullanici okunan = (Kullanici) g.readObject();
		g.close();
		System.out.println(okunan);                                // Kullanici [ad=ayse, sifre=null]
		System.out.println("sayac = " + Kullanici.sayac);          // sayac = 99
		System.out.println("ayni nesne mi? " + (okunan == k));     // ayni nesne mi? false

		new File("k.ser").delete();
	}
}
