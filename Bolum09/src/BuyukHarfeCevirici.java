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

/* Beklenen cikti:
Exception in thread "AWT-EventQueue-0" java.awt.HeadlessException
	at java.desktop/java.awt.GraphicsEnvironment.checkHeadless(GraphicsEnvironment.java:166)
	at java.desktop/java.awt.Window.<init>(Window.java:553)
	at java.desktop/java.awt.Frame.<init>(Frame.java:428)
	at java.desktop/javax.swing.JFrame.<init>(JFrame.java:224)
	at BuyukHarfeCevirici.lambda$main$2(BuyukHarfeCevirici.java:19)
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
