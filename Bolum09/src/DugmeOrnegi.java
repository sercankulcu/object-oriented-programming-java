// GUI: pencere acar
// JButton ve ActionListener: sayac paneli; dinleyici anonim sinif ve lambda ile yazilir,
// tek ifadelik lambda ile programdan cikan dugme.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")  // Swing alt siniflari: serilestirme kullanilmiyor
public class DugmeOrnegi {

	// JButton Sinifi
	static class SayacPaneli extends JPanel {
		private int sayac = 0;
		private JLabel etiket = new JLabel("Henuz tiklanmadi");

		SayacPaneli() {
			JButton dugme = new JButton("Tikla");
			dugme.addActionListener(e -> {
				sayac++;
				etiket.setText(sayac + " kez tiklandi");
			});
			add(dugme);
			add(etiket);
		}
	}

	// ActionListener: Anonim Sinif
	static class AnonimPanel extends JPanel {
		private int sayac = 0;
		private JLabel etiket = new JLabel("Sayi: 0");

		AnonimPanel() {
			JButton dugme = new JButton("Anonim");
			dugme.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sayac++;
					etiket.setText("Sayi: " + sayac);
				}
			});
			add(dugme);
			add(etiket);
		}
	}

	// ActionListener: Lambda
	static class LambdaPanel extends JPanel {
		private int sayac = 0;
		private JLabel etiket = new JLabel("Sayi: 0");

		LambdaPanel() {
			JButton dugme = new JButton("Lambda");
			dugme.addActionListener(e -> {
				sayac++;
				etiket.setText("Sayi: " + sayac);
			});
			// tek ifade ise suslu parantez gerekmez:
			JButton cikis = new JButton("Cikis");
			cikis.addActionListener(e -> System.exit(0));
			add(dugme);
			add(etiket);
			add(cikis);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JPanel govde = new JPanel(new GridLayout(3, 1));
			govde.add(new SayacPaneli());
			govde.add(new AnonimPanel());
			govde.add(new LambdaPanel());
			JFrame pencere = new JFrame("Dugme Ornegi");
			pencere.add(govde);
			pencere.setSize(360, 180);
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
	at DugmeOrnegi.lambda$main$0(DugmeOrnegi.java:72)
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
