// return ve void: void metotta return, metottan erken cikar.
public class Erken {
	static void bolumYazdir(int bolunen, int bolen) {
		if (bolen == 0) {
			System.out.println("Sifira bolunemez!");
			return;                      // metottan hemen cik
		}
		System.out.println(bolunen / bolen);
	}
	public static void main(String[] args) {
		bolumYazdir(10, 2);                  // 5
		bolumYazdir(7, 0);                   // Sifira bolunemez!
	}
}

/* Beklenen cikti:
5
Sifira bolunemez!
*/
