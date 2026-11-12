package cokbicimlilik;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

// Ornek: Tanksavar oyunu (pencere acmayan model). Oyun dongusu yalnizca Tanksavar
// tipini bilir; topAt() hangi topu uretecegini nesneye gore secer (dinamik baglama).
public class TanksavarOyunu {

	static class Top {
		Rectangle topKonum;
		Color renk;
		Top(int x, int y, int genislik, int yukseklik, Color renk) {
			topKonum = new Rectangle(x, y, genislik, yukseklik);
			this.renk = renk;
		}
		@Override public String toString() {
			return getClass().getSimpleName() + ", yukseklik " + topKonum.height;
		}
	}

	static class Top37mm extends Top {
		Top37mm(int x, int y) { super(x, y, 6, 30, Color.ORANGE); }
	}

	static class Top57mm extends Top {
		Top57mm(int x, int y) { super(x, y, 8, 40, Color.RED); }
	}

	abstract static class Tanksavar {
		int x, y;
		Color renk;
		Tanksavar(int x, int y, Color renk) {
			this.x = x;
			this.y = y;
			this.renk = renk;
		}
		abstract Top topAt();
	}

	static class TanksavarJawelin extends Tanksavar {
		TanksavarJawelin(int x, int y) { super(x, y, Color.GREEN); }
		@Override Top topAt() { return new Top37mm(x, y); }
	}

	static class TanksavarTow2A extends Tanksavar {
		TanksavarTow2A(int x, int y) { super(x, y, Color.BLUE); }
		@Override Top topAt() { return new Top57mm(x, y); }
	}

	public static void main(String[] args) {
		int x = 100, y = 540;
		List<Top> toplar = new ArrayList<>();
		Tanksavar tanksavar = new TanksavarJawelin(x, y);
		for (int skor = 0; skor <= 20; skor += 10) {
			// hangi top? nesneye bagli (dinamik baglama)
			toplar.add(tanksavar.topAt());
			// skor 10'un katiysa tanksavar turu degisir
			if (skor == 10 && tanksavar instanceof TanksavarJawelin) {
				tanksavar = new TanksavarTow2A(tanksavar.x, tanksavar.y);
			}
		}
		System.out.println(toplar);   // [Top37mm, yukseklik 30, Top37mm, yukseklik 30, Top57mm, yukseklik 40]

		// Sinama ciktisi
		tanksavar = new TanksavarJawelin(x, y);
		Top t1 = tanksavar.topAt(); // Jawelin
		System.out.println(t1);     // Top37mm, yukseklik 30
		tanksavar = new TanksavarTow2A(100, 540);
		Top t2 = tanksavar.topAt();
		System.out.println(t2);     // Top57mm, yukseklik 40
	}
}

/* Beklenen cikti:
[Top37mm, yukseklik 30, Top37mm, yukseklik 30, Top57mm, yukseklik 40]
Top37mm, yukseklik 30
Top57mm, yukseklik 40
*/
