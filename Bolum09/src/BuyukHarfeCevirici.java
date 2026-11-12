// GUI: pencere acar
// Metin donusturucu: iki dugme metin alanindaki yaziyi kucuk ya da buyuk harfe cevirir.
import java.awt.BorderLayout;
import javax.swing.*;

public class BuyukHarfeCevirici {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var alan = new JTextArea("Java Programlama", 8, 50);
			var kucukHarfButton = new JButton("Kucuk Harfe Cevir");
			var buyukHarfButton = new JButton("Buyuk Harfe Cevir");
			kucukHarfButton.addActionListener(e ->
					alan.setText(alan.getText().toLowerCase()));
			buyukHarfButton.addActionListener(e ->
					alan.setText(alan.getText().toUpperCase()));
			var panel = new JPanel();
			panel.add(kucukHarfButton);
			panel.add(buyukHarfButton);
			var frame = new JFrame("BuyukHarfeCevirici");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(new JScrollPane(alan),
					BorderLayout.CENTER);
			frame.getContentPane().add(panel, BorderLayout.SOUTH);
			frame.pack();
			frame.setVisible(true);
		});
	}
}

/* Bu program bir pencere acar; ciktisi ekrandadir, konsola bir sey yazmaz. Ekransiz ortamda (ornegin CI) calistirilamaz. */
