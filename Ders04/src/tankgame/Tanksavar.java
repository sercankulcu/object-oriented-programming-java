// Tanksavar sinifi
package tankgame;

import java.awt.Color;

public abstract class Tanksavar {
	int x, y, width, height;
	Color renk;

	public Tanksavar(int x, int y, Color renk) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 30;
		this.renk = renk;
	}
}