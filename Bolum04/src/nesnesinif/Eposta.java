package nesnesinif;

// Metot ornegi: parametre alan ve boolean donduren gonder metodu.
public class Eposta {
	public boolean gonder(String alici, String konu,
						  String icerik) {
		// Gercek gonderim yerine bir benzetim
		if (alici == null || !alici.contains("@")) {
			return false;               // basarisiz
		}
		System.out.println(alici + " <- " + konu);
		return true;                    // basarili
	}

	public static void main(String[] args) {
		Eposta e = new Eposta();
		boolean s1 = e.gonder("ali@ornek.com", "Odev", "Ek");   // ali@ornek.com <- Odev
		boolean s2 = e.gonder("ali.ornek.com", "Odev", "Ek");
		System.out.println(s1 + " " + s2);                      // true false
	}
}
