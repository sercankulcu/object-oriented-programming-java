import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class ParaUstuHesaplama extends JFrame {
	private static final long serialVersionUID = 1912881839758209062L;

	private JTextField miktarAlani = new JTextField(12);
	private Document metin = miktarAlani.getDocument();
	private JTextArea rapor = new JTextArea(8, 40);

	public ParaUstuHesaplama() {
		var ustPanel = new JPanel();
		ustPanel.add(new JLabel("Miktar:"));
		ustPanel.add(miktarAlani);
		getContentPane().add(ustPanel, BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(rapor), BorderLayout.CENTER);
		setBackground(Color.LIGHT_GRAY);
		rapor.setEditable(false);
		metin.addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent e) {
				raporuGuncelle();
			}

			public void insertUpdate(DocumentEvent e) {
				raporuGuncelle();
			}

			public void removeUpdate(DocumentEvent e) {
				raporuGuncelle();
			}
		});
	}

	void raporuGuncelle() {
		try {
			var miktar = Integer.parseInt(metin.getText(0, metin.getLength()));
			int dizi[] = {50, 25, 10, 5, 1};
			rapor.setText(miktar + " kuruş yapmak için kullanılacaklar:\n");
			for(int x: dizi) {
				rapor.append(miktar / x + " " + x + " kuruş\n");
				miktar %= x;
			}
		} catch (NumberFormatException e) {
			rapor.setText("Tam sayı değil veya aralık dışında");
		} catch (Exception e) {
			rapor.setText(e.toString());
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var frame = new ParaUstuHesaplama();
			frame.setTitle("Para Üstü Hesaplama");
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
