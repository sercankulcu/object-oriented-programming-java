// Uygun tipi secmek: kontrol edilen kendi istisna sinifimiz.
// serialVersionUID, Exception Serializable oldugu icin eklendi (-Xlint uyarisi).
class CustomException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomException(String mesaj) {
		super(mesaj);
	}
}
