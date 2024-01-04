import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasitCizimPaneli extends JPanel {
	private static final long serialVersionUID = -3630443364990545965L;
	private List<List<Point>> egriler = new ArrayList<>();
	public BasitCizimPaneli() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				egriler.get(egriler.size() - 1).add(new Point(e.getX(), e.getY()));
				repaint(0, 0, getWidth(), getHeight());
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				var yeniEgri = new ArrayList<Point>();
				yeniEgri.add(new Point(e.getX(), e.getY()));
				egriler.add(yeniEgri);
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
			var frame = new JFrame("Basit Çizim Programı");
			frame.getContentPane().add(new BasitCizimPaneli(), BorderLayout.CENTER);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setSize(400, 300);
			frame.setVisible(true);
		});
	}
}
