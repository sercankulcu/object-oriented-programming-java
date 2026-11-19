// GUI: pencere acar
// JPanel ornegi: arka plan rengi verilmis bir panele dugme eklenip pencereye konur.
// Pencere olay is parcaciginda (EDT) SwingUtilities.invokeLater ile kurulur.
import java.awt.Color;
import javax.swing.*;

public class PanelOrnegi {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.add(new JButton("Tikla"));
			JFrame pencere = new JFrame("JPanel Ornegi");
			pencere.add(panel);
			pencere.setSize(300, 150);
			pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pencere.setVisible(true);
		});
	}
}
