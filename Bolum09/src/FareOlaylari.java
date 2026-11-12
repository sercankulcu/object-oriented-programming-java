import java.awt.event.*;
import javax.swing.*;

// Fare olaylari: MouseListener arayuzu, MouseAdapter ve MouseEvent bilgileri.
// Pencere acilmaz; olaylar elle uretilip dinleyicilere verilir (tiklama benzetimi).
public class FareOlaylari {

	// 1) Arayuzu uygulayan dinleyici: bes metodun hepsi yazilmali
	static class ArayuzIle {
		static class Dinleyici implements MouseListener {
			public void mouseClicked(MouseEvent e) {
				System.out.println("tik");
			}
			public void mousePressed(MouseEvent e) { }
			public void mouseReleased(MouseEvent e) { }
			public void mouseEntered(MouseEvent e) { }
			public void mouseExited(MouseEvent e) { }
		}
	}

	// 2) Adaptorden tureyen dinleyici: yalnizca gereken metot yazilir
	static class AdaptorIle {
		static class Dinleyici extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("tik");
			}
		}
	}

	// Elle fare olayi uretip paneldeki butun dinleyicilere iletir
	static void bas(JPanel panel, int x, int y, int dugme, int degistirici) {
		MouseEvent e = new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, 0L,
				degistirici, x, y, 1, false, dugme);
		for (MouseListener l : panel.getMouseListeners())
			l.mousePressed(e);
	}

	static void tikla(JPanel panel, int x, int y) {
		MouseEvent e = new MouseEvent(panel, MouseEvent.MOUSE_CLICKED, 0L,
				0, x, y, 1, false, MouseEvent.BUTTON1);
		for (MouseListener l : panel.getMouseListeners())
			l.mouseClicked(e);
	}

	public static void main(String[] args) {
		JPanel p1 = new JPanel();
		p1.addMouseListener(new ArayuzIle.Dinleyici());
		tikla(p1, 10, 10);                         // tik
		JPanel p2 = new JPanel();
		p2.addMouseListener(new AdaptorIle.Dinleyici());
		tikla(p2, 10, 10);                         // tik

		// MouseEvent Sinifi
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String dugme = "sol";
				if (e.getButton() == MouseEvent.BUTTON3) {
					dugme = "sag";
				}
				System.out.println(dugme + " (" + e.getX()
						+ ", " + e.getY() + ")"
						+ (e.isShiftDown() ? " + Shift" : ""));
			}
		});
		bas(panel, 40, 120, MouseEvent.BUTTON1, 0);                           // sol (40, 120)
		bas(panel, 200, 50, MouseEvent.BUTTON3, 0);                           // sag (200, 50)
		bas(panel, 75, 30, MouseEvent.BUTTON1, InputEvent.SHIFT_DOWN_MASK);   // sol (75, 30) + Shift
	}
}

/* Beklenen cikti:
tik
tik
sol (40, 120)
sag (200, 50)
sol (75, 30) + Shift
*/
