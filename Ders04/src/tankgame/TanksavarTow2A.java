// Tow2A Tanksavar sinifi
package tankgame;

import java.awt.Color;

public class TanksavarTow2A extends Tanksavar {
	public TanksavarTow2A(int x, int y) {
		super(x, y, Color.BLUE);  // Tow2A tanksavari mavi renkte
		top = new Top57mm(x + genislik / 2 - 5, y - 20);
	}

	@Override
	public Top topAt() {
		// TODO Auto-generated method stub
		return new Top57mm(x + genislik / 2 - 5, y - 20);
	}
}