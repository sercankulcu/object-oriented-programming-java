import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GirisYasaktirIsareti extends JPanel {
	private static final long serialVersionUID = 7148504528835036003L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		var c = new Point(getWidth() / 2, getHeight() / 2); // merkez
		var r = Math.min(getWidth() / 2, getHeight() / 2) - 5; //yarıçap
		var r2 = (int)(r * 0.9); // iç yarıçap
		var bw = (int)(r2 * 1.4); // bar genişlik
		var bh = (int)(r2 * 0.35); // bar yükseklik
		g.setColor(Color.WHITE);
		g.fillOval(c.x - r, c.y - r, 2*r, 2*r);
		g.setColor(Color.RED);
		g.fillOval(c.x - r2, c.y - r2, r2 * 2, r2 * 2);
		g.setColor(Color.WHITE);
		g.fillRect(c.x - bw/2, c.y - bh/2, bw, bh);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var panel = new GirisYasaktirIsareti();
			panel.setBackground(Color.GREEN.darker());
			var frame = new JFrame("Basit bir grafik programı");
			frame.setSize(400, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			frame.setVisible(true);
		});
	}
}
