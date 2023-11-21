
public class BasamakDegeri {

	public static void main(String[] args) {

		for (int onlar = 0; onlar <= 4; onlar++) {
			for (int birler = 1; birler <= 9; birler++) {
				int sayi = onlar * 10 + birler;
				System.out.println("Onlar basamağı: " + onlar + ", Birler basamağı: " + birler + " --> " + sayi);
			}
		}
	}
	
	public int rakamlarToplami(int sayi) {
		int toplam = 0;
		while (sayi > 0) {
			int kalan = sayi % 10;
			toplam += kalan;
			sayi /= 10;
		}
		return toplam;
	}

}
