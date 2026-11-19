// GUI: pencere acar
// Ilk pencere: JFrame olusturma, boyut, kapatma davranisi ve gorunurluk.
// Pencere olay is parcaciginda (EDT) SwingUtilities.invokeLater ile kurulur.
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameOrnegi {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame pencere = new JFrame("Java JFrame Ornegi");
			pencere.setSize(400, 300);
			pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pencere.setVisible(true);
		});
	}
}
