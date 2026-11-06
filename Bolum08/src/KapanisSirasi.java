// try-with-resources: kaynaklar acilis sirasinin tersine kapanir, sonra catch ve finally calisir.
class Kaynak implements AutoCloseable {
	String ad;
	Kaynak(String ad) { this.ad = ad; System.out.println(ad + " acildi"); }
	public void close() { System.out.println(ad + " kapandi"); }
}
public class KapanisSirasi {
	@SuppressWarnings("try")   // a ve b govdede kullanilmiyor: bilerek
	public static void main(String[] args) {
		try (Kaynak a = new Kaynak("A"); Kaynak b = new Kaynak("B")) {
			System.out.println("blok calisiyor");
			throw new IllegalStateException("hata!");
		} catch (IllegalStateException e) {
			System.out.println("yakalandi: " + e.getMessage());
		} finally { System.out.println("finally"); }
		// A acildi
		// B acildi
		// blok calisiyor
		// B kapandi
		// A kapandi
		// yakalandi: hata!
		// finally
	}
}
