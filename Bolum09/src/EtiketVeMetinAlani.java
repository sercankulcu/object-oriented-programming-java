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

/* Beklenen cikti:
Exception in thread "AWT-EventQueue-0" java.awt.HeadlessException
	at java.desktop/java.awt.GraphicsEnvironment.checkHeadless(GraphicsEnvironment.java:166)
	at java.desktop/java.awt.Window.<init>(Window.java:553)
	at java.desktop/java.awt.Frame.<init>(Frame.java:428)
	at java.desktop/javax.swing.JFrame.<init>(JFrame.java:224)
	at EtiketVeMetinAlani.lambda$main$1(EtiketVeMetinAlani.java:22)
	at java.desktop/java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:318)
	at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:773)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:720)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:714)
	at java.base/java.security.AccessController.doPrivileged(AccessController.java:400)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:87)
	at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:742)
	at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)
*/
