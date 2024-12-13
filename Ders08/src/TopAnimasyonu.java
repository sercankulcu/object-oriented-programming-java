import java.awt.Color; 
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class TopAnimasyonu extends JFrame {

	private static final long serialVersionUID = 3305372670620496856L;
	private static final int GENISLIK = 600; // Pencere genisligi
	private static final int YUKSEKLIK = 400; // Pencere yuksekligi
	private static final int TOP_YARICAPI = 20; // Top yaricapi
	Random rastgele = new Random(); // Rastgele sayilar uretmek icin

	private transient List<Top> toplar = new ArrayList<>(); // Toplarin listesini tutan liste

	// Top sinifi, bir topun konumu ve yonunu tutar
	private static class Top {
		int x; // X koordinati
		int y; // Y koordinati
		int xYon; // X yonu
		int yYon; // Y yonu

		public Top(int x, int y, int xYon, int yYon) {
			this.x = x;
			this.y = y;
			this.xYon = xYon;
			this.yYon = yYon;
		}

		// Topu hareket ettiren metod
		public void hareketEt() {
			x += xYon;
			y += yYon;

			// Duvarlardan sekmesi
			if (x <= 0 || x >= GENISLIK - 2 * TOP_YARICAPI + 10) {
				xYon *= -1; // X yonunu ters cevir
			}
			if (y <= 0 || y >= YUKSEKLIK - 2 * TOP_YARICAPI + 10) {
				yYon *= -1; // Y yonunu ters cevir
			}
		}
	}

	public TopAnimasyonu() {
		setTitle("Top Animasyonu"); // Pencere basligi
		setSize(GENISLIK, YUKSEKLIK); // Pencere boyutunu ayarla
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Pencereyi kapatmak icin

		// Toplari olustur
		topOlustur();

		// Animasyon icin zamanlayici
		Timer zamanlayici = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toplariHareketEttir(); // Toplari hareket ettir
				repaint(); // Ekrani yeniden ciz
			}
		});
		zamanlayici.start(); // Zamanlayiciyi baslat
	}

	// Toplari olusturan metod
	private void topOlustur() {
		for (int i = 0; i < 5; i++) {
			// Rastgele yer ve yon ile 5 top olustur
			toplar.add(new Top(rastgele.nextInt(getWidth() - 2 * TOP_YARICAPI), rastgele.nextInt(YUKSEKLIK - 2 * TOP_YARICAPI),
					rastgele.nextInt(5) + 1, rastgele.nextInt(5) + 1));
		}
	}

	// Tum toplari hareket ettiren metod
	private void toplariHareketEttir() {
		for (Top top : toplar) {
			top.hareketEt(); // Her topu hareket ettir
		}
	}

	// Ekrani cizme metodu
	@Override
	public void paint(Graphics g) {
		super.paint(g); // Ekrani yenile
		for (Top top : toplar) {
			g.setColor(Color.BLUE); // Topun rengini mavi yap
			g.fillOval(top.x, top.y, 2 * TOP_YARICAPI, 2 * TOP_YARICAPI); // Topu ciz
		}
	}

	// Ana metod
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// SwingTopAnimasyonu penceresini baslat
				new TopAnimasyonu().setVisible(true);
			}
		});
	}
}
