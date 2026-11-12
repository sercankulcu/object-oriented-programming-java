import java.awt.*;
import javax.swing.*;

// FlowLayout: dugmeler satira sigdigi kadar dizilir, satir ortalanir, sigmayan alt satira gecer.
// Pencere acilmaz; doLayout() konumlari hesaplar.
public class FlowLayoutIzleme {
	public static void main(String[] args) {
		int[] gen = {90, 60, 110, 70, 80};
		JPanel panel = new JPanel();   // FlowLayout(CENTER, 5, 5)
		panel.setSize(260, 120);
		for (int i = 0; i < gen.length; i++) {
			JButton b = new JButton("B" + i);
			b.setPreferredSize(new Dimension(gen[i], 30));
			panel.add(b);
		}
		panel.doLayout();              // konumlari hesapla
		for (Component c : panel.getComponents())
			System.out.println(c.getX() + ", " + c.getY());
		// 52, 5
		// 147, 5
		// 37, 40
		// 152, 40
		// 90, 75
	}
}

/* Beklenen cikti:
52, 5
147, 5
37, 40
152, 40
90, 75
*/
