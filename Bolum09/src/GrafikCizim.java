// GUI: pencere acar
// paintComponent ile cizim: dikdortgen, cizgi, oval, yazi; Color ve Font kullanimi.
// Uc panel yan yana bir pencerede gosterilir.
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")  // Swing alt siniflari: serilestirme kullanilmiyor
public class GrafikCizim {

	// paintComponent ile Cizim
	static class CizimPaneli extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);     // zemini temizle
			g.setColor(Color.BLUE);
			g.drawRect(20, 30, 50, 70);  // x, y, en, boy
			g.drawString("Merhaba, Java Grafik!", 100, 100);
		}
	}

	// Sekiller: Kod ve Sonuc
	static class SekillerPaneli extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(10, 10, 110, 60);
			g.drawRect(130, 10, 80, 50);
			g.fillRect(230, 10, 80, 50);
			g.drawOval(10, 80, 100, 60);
			g.fillOval(130, 80, 60, 60);
			g.drawString("Merhaba", 230, 115);
		}
	}

	// Font Sinifi
	static class YaziTipiPaneli extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(0, 102, 204));
			g.setFont(new Font("Serif", Font.BOLD, 24));
			g.drawString("Java", 20, 40);
			g.setFont(new Font("Monospaced", Font.PLAIN, 14));
			g.drawString("Grafik", 20, 70);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JPanel govde = new JPanel(new GridLayout(1, 3));
			govde.add(new CizimPaneli());
			govde.add(new SekillerPaneli());
			govde.add(new YaziTipiPaneli());
			JFrame pencere = new JFrame("Grafik Cizim");
			pencere.add(govde);
			pencere.setSize(1000, 200);
			pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pencere.setVisible(true);
		});
	}
}
