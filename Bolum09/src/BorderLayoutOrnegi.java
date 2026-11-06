import java.awt.*;
import javax.swing.*;

// BorderLayout: bes bolge (kuzey, guney, bati, dogu, merkez) ve bosluklar.
// Pencere acilmaz; her dugmenin hangi bolgeye yerlestigi yazdirilir.
public class BorderLayoutOrnegi {
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		BorderLayout yerlesim = new BorderLayout();
		yerlesim.setHgap(5);
		yerlesim.setVgap(5);
		panel.setLayout(yerlesim);
		panel.add(new JButton("Kuzey"), BorderLayout.NORTH);
		panel.add(new JButton("Guney"), BorderLayout.SOUTH);
		panel.add(new JButton("Bati"), BorderLayout.WEST);
		panel.add(new JButton("Dogu"), BorderLayout.EAST);
		panel.add(new JButton("Merkez"), BorderLayout.CENTER);

		for (Component c : panel.getComponents())
			System.out.println(((JButton) c).getText() + " -> " + yerlesim.getConstraints(c));
		// Kuzey -> North
		// Guney -> South
		// Bati -> West
		// Dogu -> East
		// Merkez -> Center
		System.out.println(yerlesim.getHgap() + " " + yerlesim.getVgap());  // 5 5
	}
}
