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

/* Bu program bir pencere acar; ciktisi ekrandadir, konsola bir sey yazmaz. Ekransiz ortamda (ornegin CI) calistirilamaz. */
