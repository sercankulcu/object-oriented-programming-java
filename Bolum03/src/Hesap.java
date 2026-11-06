// static ve Nesne Uzerinden Cagri: static olmayan metot bir nesne uzerinden cagrilir.
public class Hesap {
	int toplama(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}
	public static void main(String[] args) {
		Hesap hesap = new Hesap();
		int sonuc = hesap.toplama(5, 3);
		System.out.println(sonuc);  // 8
	}
}
