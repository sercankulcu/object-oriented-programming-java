// Tanksavar sinifi
package tankgame;

import java.awt.Color;

public abstract class Tanksavar {
	int x, y, genislik, yukseklik;
	Color renk;
	Top top;

	public Tanksavar(int x, int y, Color renk) {
		this.x = x;
		this.y = y;
		this.genislik = 40;
		this.yukseklik = 30;
		this.renk = renk;
	}
	
	public abstract Top topAt();
}