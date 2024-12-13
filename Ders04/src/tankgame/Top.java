// Top sinifi
package tankgame;

import java.awt.Color;
import java.awt.Rectangle;

public class Top {
	Rectangle topRect;
	Color renk;  // Topun rengi

	public Top(int x, int y, int width, int height, Color renk) {
		this.topRect = new Rectangle(x, y, width, height);
		this.renk = renk;
	}
}