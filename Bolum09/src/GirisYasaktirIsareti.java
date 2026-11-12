// GUI: pencere acar
// Giris yasak isareti: panelin boyutuna gore merkez ve yaricap hesaplanip
// beyaz cember, kirmizi daire ve beyaz bar cizilir.
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")  // Swing alt sinifi: serilestirme kullanilmiyor
public class GirisYasaktirIsareti extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		var c = new Point(getWidth() / 2, getHeight() / 2); // merkez
		var r = Math.min(getWidth() / 2, getHeight() / 2) - 5; // yaricap
		var r2 = (int) (r * 0.9);   // ic yaricap
		var bw = (int) (r2 * 1.4);  // bar genisligi
		var bh = (int) (r2 * 0.35); // bar yuksekligi
		g.setColor(Color.WHITE);
		g.fillOval(c.x - r, c.y - r, 2 * r, 2 * r);
		g.setColor(Color.RED);
		g.fillOval(c.x - r2, c.y - r2, r2 * 2, r2 * 2);
		g.setColor(Color.WHITE);
		g.fillRect(c.x - bw / 2, c.y - bh / 2, bw, bh);
		// 400 x 300 pencerede panel 384 x 261: c = (192, 130), r = 125, r2 = 112, bw = 156, bh = 39
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var panel = new GirisYasaktirIsareti();
			panel.setBackground(Color.GREEN.darker());
			var frame = new JFrame("Basit bir grafik programi");
			frame.setSize(400, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(panel, BorderLayout.CENTER);
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
	at GirisYasaktirIsareti.lambda$main$0(GirisYasaktirIsareti.java:30)
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
