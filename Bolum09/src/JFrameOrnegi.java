// GUI: pencere acar
// Ilk pencere: JFrame olusturma, boyut, kapatma davranisi ve gorunurluk.
// Sunumdaki kod oldugu gibi: pencere main is parcaciginda aciliyor.
import javax.swing.JFrame;

public class JFrameOrnegi {
	public static void main(String[] args) {
		JFrame pencere = new JFrame("Java JFrame Ornegi");
		pencere.setSize(400, 300);
		pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pencere.setVisible(true);
	}
}
