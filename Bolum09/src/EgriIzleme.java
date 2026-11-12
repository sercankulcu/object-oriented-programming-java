import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

// BasitCizimPaneli'ni pencere acmadan izler: fare basma/surukleme olaylari elle uretilir,
// paintComponent'e her drawLine cagrisini yazdiran bir Graphics verilir.
public class EgriIzleme {

	// Yalnizca drawLine cagrilarini yazdiran, digerlerinde bir sey yapmayan Graphics
	static class KayitGrafik extends Graphics {
		private Color renk = Color.BLACK;
		private Font yazi = new Font("Dialog", Font.PLAIN, 12);

		@Override public void drawLine(int x1, int y1, int x2, int y2) {
			System.out.println("drawLine(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")");
		}

		@Override public Graphics create() { return this; }
		@Override public void dispose() { }
		@Override public void translate(int x, int y) { }
		@Override public Color getColor() { return renk; }
		@Override public void setColor(Color c) { renk = c; }
		@Override public void setPaintMode() { }
		@Override public void setXORMode(Color c) { }
		@Override public Font getFont() { return yazi; }
		@Override public void setFont(Font f) { yazi = f; }
		@Override public FontMetrics getFontMetrics(Font f) { return null; }
		@Override public Rectangle getClipBounds() { return null; }
		@Override public void clipRect(int x, int y, int w, int h) { }
		@Override public void setClip(int x, int y, int w, int h) { }
		@Override public Shape getClip() { return null; }
		@Override public void setClip(Shape s) { }
		@Override public void copyArea(int x, int y, int w, int h, int dx, int dy) { }
		@Override public void fillRect(int x, int y, int w, int h) { }
		@Override public void clearRect(int x, int y, int w, int h) { }
		@Override public void drawRoundRect(int x, int y, int w, int h, int aw, int ah) { }
		@Override public void fillRoundRect(int x, int y, int w, int h, int aw, int ah) { }
		@Override public void drawOval(int x, int y, int w, int h) { }
		@Override public void fillOval(int x, int y, int w, int h) { }
		@Override public void drawArc(int x, int y, int w, int h, int b, int a) { }
		@Override public void fillArc(int x, int y, int w, int h, int b, int a) { }
		@Override public void drawPolyline(int[] xs, int[] ys, int n) { }
		@Override public void drawPolygon(int[] xs, int[] ys, int n) { }
		@Override public void fillPolygon(int[] xs, int[] ys, int n) { }
		@Override public void drawString(String s, int x, int y) { }
		@Override public void drawString(AttributedCharacterIterator it, int x, int y) { }
		@Override public boolean drawImage(Image i, int x, int y, ImageObserver o) { return true; }
		@Override public boolean drawImage(Image i, int x, int y, int w, int h, ImageObserver o) { return true; }
		@Override public boolean drawImage(Image i, int x, int y, Color c, ImageObserver o) { return true; }
		@Override public boolean drawImage(Image i, int x, int y, int w, int h, Color c, ImageObserver o) { return true; }
		@Override public boolean drawImage(Image i, int dx1, int dy1, int dx2, int dy2,
				int sx1, int sy1, int sx2, int sy2, ImageObserver o) { return true; }
		@Override public boolean drawImage(Image i, int dx1, int dy1, int dx2, int dy2,
				int sx1, int sy1, int sx2, int sy2, Color c, ImageObserver o) { return true; }
	}

	static void bas(BasitCizimPaneli p, int x, int y) {
		MouseEvent e = new MouseEvent(p, MouseEvent.MOUSE_PRESSED, 0L, 0, x, y, 1, false, MouseEvent.BUTTON1);
		for (MouseListener l : p.getMouseListeners())
			l.mousePressed(e);
	}

	static void surukle(BasitCizimPaneli p, int x, int y) {
		MouseEvent e = new MouseEvent(p, MouseEvent.MOUSE_DRAGGED, 0L, 0, x, y, 0, false, MouseEvent.NOBUTTON);
		for (MouseMotionListener l : p.getMouseMotionListeners())
			l.mouseDragged(e);
	}

	public static void main(String[] args) {
		var panel = new BasitCizimPaneli();
		panel.setSize(400, 300);
		bas(panel, 40, 120);       // egri 0 baslar
		surukle(panel, 60, 60);
		surukle(panel, 80, 120);
		bas(panel, 50, 95);        // egri 1 baslar
		surukle(panel, 70, 95);

		panel.paintComponent(new KayitGrafik());
		// drawLine(40, 120, 40, 120)
		// drawLine(40, 120, 60, 60)
		// drawLine(60, 60, 80, 120)
		// drawLine(50, 95, 50, 95)
		// drawLine(50, 95, 70, 95)
	}
}

/* Beklenen cikti:
drawLine(40, 120, 40, 120)
drawLine(40, 120, 60, 60)
drawLine(60, 60, 80, 120)
drawLine(50, 95, 50, 95)
drawLine(50, 95, 70, 95)
*/
