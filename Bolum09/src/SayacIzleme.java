import javax.swing.*;

// SayacPaneli'ni pencere acmadan izler: doClick() dugmeye tiklamayi benzetir,
// her tiklamada dinleyici sayaci artirip etiketi gunceller.
public class SayacIzleme {
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> {
			var panel = new DugmeOrnegi.SayacPaneli();
			JButton dugme = (JButton) panel.getComponent(0);
			JLabel etiket = (JLabel) panel.getComponent(1);
			System.out.println(dugme.getActionListeners().length);  // 1  (dinleyici sayisi)
			System.out.println(panel.getComponentCount());          // 2  (bilesen sayisi)
			System.out.println(etiket.getText());                   // Henuz tiklanmadi
			dugme.doClick();
			System.out.println(etiket.getText());                   // 1 kez tiklandi
			dugme.doClick();
			System.out.println(etiket.getText());                   // 2 kez tiklandi
		});
	}
}

/* Beklenen cikti:
1
2
Henuz tiklanmadi
1 kez tiklandi
2 kez tiklandi
*/
