// Bir Program Nedir? Sira Onemlidir: iki degiskeni takas etmek icin
// gecici degisken gerekir; yoksa ilk deger kaybolur.
public class SiraOnemlidir {
	public static void main(String[] args) {
		int a = 3, b = 5;
		a = b;
		b = a;
		System.out.println(a + " " + b);  // 5 5

		int c = 3, d = 5;
		int gecici = c;
		c = d;
		d = gecici;
		System.out.println(c + " " + d);  // 5 3
	}
}
