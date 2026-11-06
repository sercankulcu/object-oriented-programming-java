package nesnesinif;

// null ve NullPointerException: null bir referansin alanina
// erismek calisma zamaninda hata firlatir.
public class Bos {
	String ad;

	public static void main(String[] args) {
		Bos b = null;
		try {
			System.out.println(b.ad.length());
		} catch (NullPointerException e) {
			// java.lang.NullPointerException: Cannot read field "ad" because "<local1>" is null
			System.out.println(e);
		}
	}
}
