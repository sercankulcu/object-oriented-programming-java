// Ozel istisna sinifi: Exception'dan turetilir, mesaji super'e iletir.
public class OzelHata extends Exception {
	private static final long serialVersionUID = 1L;   // -Xlint serial uyarisi icin eklendi

	// Constructor
	public OzelHata(String message) {
		super(message);
	}
}
