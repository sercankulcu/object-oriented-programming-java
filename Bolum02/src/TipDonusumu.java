// Atama uyumlulugu ve tip donusumu: genisletme ortuk, daraltma acik
// (cast) yapilir; cast ondalik kismi keser.
public class TipDonusumu {

	// Atama Uyumlulugu
	static void atamaUyumlulugu() {
		char karakter = 'A';
		int tamsayi;
		tamsayi = karakter;   // mumkun: 65
		System.out.println(tamsayi);  // 65
		// derleme hatasi: karakter = tamsayi;   // hata
		// Uyum.java:5: error: incompatible types: possible lossy conversion from int to char
		karakter = (char) tamsayi;
		System.out.println(karakter);  // A
	}

	// Tip Donusumu
	static void tipDonusumu() {
		double ondalikDegisken = 5;     // ortuk: 5.0
		System.out.println(ondalikDegisken);  // 5.0
		double d = 5.0;
		int tamSayiDegisken = (int) d;   // acik: 5
		System.out.println(tamSayiDegisken);  // 5
		System.out.println((int) 3.99);       // 3
		System.out.println((int) -3.99);      // -3
		System.out.println(Math.round(3.99)); // 4
		System.out.println((byte) 130);       // -126
	}

	// Tip Donusumu: Kod Izleme
	static void tipDonusumuIzleme() {
		int a = 9, b = 4;
		double d1 = a / b;
		double d2 = (double) a / b;
		double d3 = (double) (a / b);
		int k = (int) 9.75;
		long r = Math.round(9.75);
		byte y = (byte) 200;
		System.out.println(d1 + " " + d2 + " " + d3);  // 2.0 2.25 2.0
		System.out.println(k + " " + r + " " + y);     // 9 10 -56
	}

	public static void main(String[] args) {
		atamaUyumlulugu();
		tipDonusumu();
		tipDonusumuIzleme();
	}
}
