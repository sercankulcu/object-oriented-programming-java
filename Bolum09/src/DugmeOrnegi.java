// GUI: pencere acar
// JButton ve ActionListener: sayac paneli; dinleyici anonim sinif ve lambda ile yazilir,
// tek ifadelik lambda ile programdan cikan dugme.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")  // Swing alt siniflari: serilestirme kullanilmiyor
public class DugmeOrnegi {

	// JButton Sinifi
	static class SayacPaneli extends JPanel {
		private int sayac = 0;
		private JLabel etiket = new JLabel("Henuz tiklanmadi");

		SayacPaneli() {
			JButton dugme = new JButton("Tikla");
			dugme.addActionListener(e -> {
				sayac++;
				etiket.setText(sayac + " kez tiklandi");
			});
			add(dugme);
			add(etiket);
		}
	}

	// ActionListener: Anonim Sinif
	static class AnonimPanel extends JPanel {
		private int sayac = 0;
		private JLabel etiket = new JLabel("Sayi: 0");

		AnonimPanel() {
			JButton dugme = new JButton("Anonim");
			dugme.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sayac++;
					etiket.setText("Sayi: " + sayac);
				}
			});
			add(dugme);
			add(etiket);
		}
	}

	// ActionListener: Lambda
	static class LambdaPanel extends JPanel {
		private int sayac = 0;
		private JLabel etiket = new JLabel("Sayi: 0");

		LambdaPanel() {
			JButton dugme = new JButton("Lambda");
			dugme.addActionListener(e -> {
				sayac++;
				etiket.setText("Sayi: " + sayac);
			});
			// tek ifade ise suslu parantez gerekmez:
			JButton cikis = new JButton("Cikis");
			cikis.addActionListener(e -> System.exit(0));
			add(dugme);
			add(etiket);
			add(cikis);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JPanel govde = new JPanel(new GridLayout(3, 1));
			govde.add(new SayacPaneli());
			govde.add(new AnonimPanel());
			govde.add(new LambdaPanel());
			JFrame pencere = new JFrame("Dugme Ornegi");
			pencere.add(govde);
			pencere.setSize(360, 180);
			pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pencere.setVisible(true);
		});
	}
}

/* Bu program bir pencere acar; ciktisi ekrandadir, konsola bir sey yazmaz. Ekransiz ortamda (ornegin CI) calistirilamaz. */
