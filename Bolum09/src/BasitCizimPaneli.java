// GUI: pencere acar
// Basit cizim programi: fareye basinca yeni egri baslar, surukledikce noktalar eklenir,
// paintComponent butun egrileri ardisik noktalari birlestirerek cizer.
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings({"serial", "this-escape"})  // Swing alt sinifi: serilestirme kullanilmiyor
public class BasitCizimPaneli extends JPanel {
	private List<List<Point>> egriler = new ArrayList<>();

	public BasitCizimPaneli() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				var yeniEgri = new ArrayList<Point>();
				yeniEgri.add(new Point(e.getX(), e.getY()));
				egriler.add(yeniEgri);
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				egriler.get(egriler.size() - 1)
						.add(new Point(e.getX(), e.getY()));
				repaint(0, 0, getWidth(), getHeight());
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (var egri : egriler) {
			var onceki = egri.get(0);
			for (var nokta : egri) {
				g.drawLine(onceki.x, onceki.y, nokta.x, nokta.y);
				onceki = nokta;
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var frame = new JFrame("Basit Cizim Programi");
			frame.getContentPane().add(new BasitCizimPaneli(),
					BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 300);
			frame.setVisible(true);
		});
	}
}
