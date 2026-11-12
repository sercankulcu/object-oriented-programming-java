// Ozel istisnayi kullanmak: fonksiyon OzelHata firlatir, main yakalar.
public class OzelHataTest {
	public static void main(String[] args) {
		try {
			fonksiyon();
		} catch (OzelHata e) {
			System.out.println("Yakalandi: " + e.getMessage());   // Yakalandi: Ozel hata olustu.
		}
	}
	public static void fonksiyon() throws OzelHata {
		if (true) {
			throw new OzelHata("Ozel hata olustu.");
		}
	}
}

/* Beklenen cikti:
Yakalandi: Ozel hata olustu.
*/
