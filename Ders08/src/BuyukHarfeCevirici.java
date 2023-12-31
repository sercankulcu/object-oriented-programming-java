import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BuyukHarfeCevirici {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var alan = new JTextArea("Java Programlama", 8, 50);
			var kucukHarfButton = new JButton("Küçük Harfe Çevir");
			var buyukHarfButton = new JButton("Büyük Harfe Çevir");
			kucukHarfButton.addActionListener(e -> alan.setText(alan.getText().toLowerCase()));
			buyukHarfButton.addActionListener(e -> alan.setText(alan.getText().toUpperCase()));
			var buttonPanel = new JPanel();
			buttonPanel.add(kucukHarfButton);
			buttonPanel.add(buyukHarfButton);
			
			var frame = new JFrame("BuyukHarfeCevirici");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(new JScrollPane(alan), BorderLayout.CENTER);
			frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			frame.pack();
			frame.setVisible(true);
		});
	}
}
