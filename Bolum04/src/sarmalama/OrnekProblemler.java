package sarmalama;

import sarmalama.BankaHesabiOrnegi.BankaHesabi;
import sarmalama.DegistirilemezPara.Para;
import sarmalama.ErisimMetotlari.DijitalSaat;
import sarmalama.SizanReferans.Karne;

// Ornek problemler: DijitalSaat, BankaHesabi, Karne ve Para
// siniflarinin sunumdaki sorulari.
public class OrnekProblemler {

	static void problem1() {
		DijitalSaat t = new DijitalSaat();
		t.setSaat(25);
		t.setDakika(30);
		t.setSaniye(-1);
		t.setSaniye(59);
		t.goster();                  // 00:30:59

		DijitalSaat a = new DijitalSaat();
		DijitalSaat b = a;
		a.setDakika(15);
		b.setDakika(45);
		b = new DijitalSaat();
		b.setDakika(10);
		System.out.println(a.getDakika() + " " + b.getDakika());   // 45 10
	}

	static class Test {
		public static void main(String[] args) {
			DijitalSaat s = new DijitalSaat();
			s.setSaniye(30);                    // A
			// int x = s.saniye;                // B: saniye has private access in DijitalSaat
			System.out.println(s.getSaniye());  // C   -> 30
			// s.getSaniye() = 10;              // D: unexpected type, required: variable, found: value
			// s.setSaniye("40");               // E: incompatible types: String cannot be converted to int
		}
	}

	static void problem3() {
		BankaHesabi h = new BankaHesabi(111, 1000.0, "Vadesiz");
		h.paraCek(5000.0);           // Yetersiz bakiye.
		h.paraYatir(-50.0);          // Yatirilan miktar gecersiz.
		h.faizEkle(3.0);             // Faiz yalnizca vadeli hesaplarda uygulanabilir.
		h.paraCek(250.0);            // 250.0 TL cekildi. Kalan bakiye: 750.0
		BankaHesabi v = new BankaHesabi(222, 100.0, "Vadeli");
		h.transfer(v, 1000.0);       // Yetersiz bakiye veya gecersiz miktar.
		h.transfer(v, 750.0);        // 750.0 TL yatirildi. Yeni bakiye: 850.0
									 // 750.0 TL transfer edildi. Yeni bakiye: 0.0
		System.out.println(h.getBakiye() + " " + v.getBakiye());   // 0.0 850.0
	}

	static void problem4() {
		int[] d = {50, 60};
		Karne k = new Karne(d);
		int[] g = k.getNotlar();
		g[0] = 100;
		d[1] = 100;
		System.out.println(k.ortalama());   // 100.0

		// ayni adimlar savunmaci kopyalayan Karne ile
		int[] d2 = {50, 60};
		SavunmaciKopyalama.Karne k2 = new SavunmaciKopyalama.Karne(d2);
		int[] g2 = k2.getNotlar();
		g2[0] = 100;
		d2[1] = 100;
		System.out.println(k2.ortalama());  // 55.0

		Para p = new Para(100, "TL");
		p.ekle(p);
		p = p.ekle(p);
		p.ekle(new Para(1, "TL"));
		System.out.println(p);              // 2,00 TL
	}

	public static void main(String[] args) {
		problem1();
		Test.main(args);
		problem3();
		problem4();
	}
}

/* Beklenen cikti:
00:30:59
45 10
30
Yetersiz bakiye.
Yatirilan miktar gecersiz.
Faiz yalnizca vadeli hesaplarda uygulanabilir.
250.0 TL cekildi. Kalan bakiye: 750.0
Yetersiz bakiye veya gecersiz miktar.
750.0 TL yatirildi. Yeni bakiye: 850.0
750.0 TL transfer edildi. Yeni bakiye: 0.0
0.0 850.0
100.0
55.0
2,00 TL
*/
