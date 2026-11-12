// GUI: pencere acar
// Basit cizim programi: fareye basinca yeni egri baslar, surukledikce noktalar eklenir,
// paintComponent butun egrileri ardisik noktalari birlestirerek cizer.
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings({"serial", "this-escape"})  // Swing alt sinifi: serilestirme kullanilmiyor
public class BasitCizimPaneli extends JPanel {
	private List<List<Point>> egriler = new ArrayList<>();

	public BasitCizimPaneli() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				var yeniEgri = new ArrayList<Point>();
				yeniEgri.add(new Point(e.getX(), e.getY()));
				egriler.add(yeniEgri);
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				egriler.get(egriler.size() - 1)
						.add(new Point(e.getX(), e.getY()));
				repaint(0, 0, getWidth(), getHeight());
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (var egri : egriler) {
			var onceki = egri.get(0);
			for (var nokta : egri) {
				g.drawLine(onceki.x, onceki.y, nokta.x, nokta.y);
				onceki = nokta;
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var frame = new JFrame("Basit Cizim Programi");
			frame.getContentPane().add(new BasitCizimPaneli(),
					BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 300);
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
	at BasitCizimPaneli.lambda$main$0(BasitCizimPaneli.java:47)
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
