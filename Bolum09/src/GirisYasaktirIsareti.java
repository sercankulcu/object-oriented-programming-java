// GUI: pencere acar
// Giris yasak isareti: panelin boyutuna gore merkez ve yaricap hesaplanip
// beyaz cember, kirmizi daire ve beyaz bar cizilir.
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")  // Swing alt sinifi: serilestirme kullanilmiyor
public class GirisYasaktirIsareti extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		var c = new Point(getWidth() / 2, getHeight() / 2); // merkez
		var r = Math.min(getWidth() / 2, getHeight() / 2) - 5; // yaricap
		var r2 = (int) (r * 0.9);   // ic yaricap
		var bw = (int) (r2 * 1.4);  // bar genisligi
		var bh = (int) (r2 * 0.35); // bar yuksekligi
		g.setColor(Color.WHITE);
		g.fillOval(c.x - r, c.y - r, 2 * r, 2 * r);
		g.setColor(Color.RED);
		g.fillOval(c.x - r2, c.y - r2, r2 * 2, r2 * 2);
		g.setColor(Color.WHITE);
		g.fillRect(c.x - bw / 2, c.y - bh / 2, bw, bh);
		// 400 x 300 pencerede panel 384 x 261: c = (192, 130), r = 125, r2 = 112, bw = 156, bh = 39
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var panel = new GirisYasaktirIsareti();
			panel.setBackground(Color.GREEN.darker());
			var frame = new JFrame("Basit bir grafik programi");
			frame.setSize(400, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			frame.setVisible(true);
		});
	}
}
