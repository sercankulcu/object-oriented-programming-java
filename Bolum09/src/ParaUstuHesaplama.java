// GUI: pencere acar
// Para ustu hesaplama: miktar alanina her yazilista DocumentListener raporu gunceller;
// miktar 50, 25, 10, 5 ve 1 kurusluklara bolunur.
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

@SuppressWarnings({"serial", "this-escape"})  // Swing alt sinifi: serilestirme kullanilmiyor
public class ParaUstuHesaplama extends JFrame {
	private JTextField miktarAlani = new JTextField(12);
	private Document metin = miktarAlani.getDocument();
	private JTextArea rapor = new JTextArea(8, 40);

	public ParaUstuHesaplama() {
		var ustPanel = new JPanel();
		ustPanel.add(new JLabel("Miktar:"));
		ustPanel.add(miktarAlani);
		getContentPane().add(ustPanel, BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(rapor),
				BorderLayout.CENTER);
		setBackground(Color.LIGHT_GRAY);
		rapor.setEditable(false);
		metin.addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) { raporuGuncelle(); }
			public void removeUpdate(DocumentEvent e) { raporuGuncelle(); }
			public void changedUpdate(DocumentEvent e) { raporuGuncelle(); }
		});
	}

	void raporuGuncelle() {
		try {
			var miktar = Integer.parseInt(
					metin.getText(0, metin.getLength()));
			int[] dizi = {50, 25, 10, 5, 1};
			rapor.setText(miktar
					+ " kurus yapmak icin kullanilacaklar:\n");
			for (int x : dizi) {
				rapor.append(miktar / x + " " + x + " kurus\n");
				miktar %= x;
			}
		} catch (NumberFormatException e) {
			rapor.setText("Tam sayi degil veya aralik disinda");
		} catch (Exception e) {
			rapor.setText(e.toString());
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var frame = new ParaUstuHesaplama();
			frame.setTitle("Para Ustu Hesaplama");
			frame.pack();
			frame.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

/* Beklenen cikti:
Exception in thread "AWT-EventQueue-0" java.awt.HeadlessException
	at java.desktop/java.awt.GraphicsEnvironment.checkHeadless(GraphicsEnvironment.java:166)
	at java.desktop/java.awt.Window.<init>(Window.java:553)
	at java.desktop/java.awt.Frame.<init>(Frame.java:428)
	at java.desktop/java.awt.Frame.<init>(Frame.java:393)
	at java.desktop/javax.swing.JFrame.<init>(JFrame.java:180)
	at ParaUstuHesaplama.<init>(ParaUstuHesaplama.java:16)
	at ParaUstuHesaplama.lambda$main$0(ParaUstuHesaplama.java:52)
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
