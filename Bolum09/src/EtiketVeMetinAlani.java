// GUI: pencere acar
// JLabel ve JTextField: yazi tipi ve rengi verilmis etiket; Enter'a basilinca
// metin alanindaki ad okunup selam etiketine yazilir.
import java.awt.*;
import javax.swing.*;

public class EtiketVeMetinAlani {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JLabel etiket = new JLabel("Adiniz:");
			etiket.setFont(new Font("SansSerif", Font.BOLD, 14));
			etiket.setForeground(Color.BLUE);
			JTextField adAlani = new JTextField(12);
			JLabel selam = new JLabel(" ");
			adAlani.addActionListener(e -> selam.setText(
					"Merhaba, " + adAlani.getText() + "!"));

			JPanel panel = new JPanel();
			panel.add(etiket);
			panel.add(adAlani);
			panel.add(selam);
			JFrame pencere = new JFrame("JLabel ve JTextField");
			pencere.add(panel);
			pencere.setSize(420, 100);
			pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pencere.setVisible(true);
		});
	}
}

/* Bu program bir pencere acar; ciktisi ekrandadir, konsola bir sey yazmaz. Ekransiz ortamda (ornegin CI) calistirilamaz. */
