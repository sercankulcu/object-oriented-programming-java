// Hata Mesajlarini Okumak: eksik noktali virgul derleme hatasi verir.
// Hatali satir yorumda; duzeltilmis hali calisir.
public class Selam {
	public static void main(String[] args) {
		// derleme hatasi: System.out.println("Merhaba")
		// Selam.java:3: error: ';' expected
		System.out.println("Merhaba");  // Merhaba
	}
}
