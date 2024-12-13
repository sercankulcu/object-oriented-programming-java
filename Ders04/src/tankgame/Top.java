// Top sinifi
package tankgame;

import java.awt.Color;
import java.awt.Rectangle;

public class Top {
	Rectangle topKonum;
	Color renk;  // Topun rengi

	public Top(int x, int y, int genislik, int yukseklik, Color renk) {
		this.topKonum = new Rectangle(x, y, genislik, yukseklik);
		this.renk = renk;
	}
}