import java.awt.BorderLayout; 
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
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

	private JTextField miktarAlani = new JTextField(12); // Miktar girisi icin text field
	private transient Document metin = miktarAlani.getDocument(); // Text alaninin dokumani
	private JTextArea rapor = new JTextArea(8, 40); // Raporu gosterecek text area

	public ParaUstuHesaplama() {
		var ustPanel = new JPanel(); // Ust panel olustur
		ustPanel.add(new JLabel("Miktar:")); // Miktar label'ini ekle
		ustPanel.add(miktarAlani); // Miktar giris alanini ekle
		getContentPane().add(ustPanel, BorderLayout.NORTH); // Ust paneli ekle
		getContentPane().add(new JScrollPane(rapor), BorderLayout.CENTER); // Raporu ekle
		setBackground(Color.LIGHT_GRAY); // Arka plan rengini ayarla
		rapor.setEditable(false); // Raporu degistirilemez hale getir
		metin.addDocumentListener(new DocumentListener() { // Miktar alanina dinleyici ekle

			public void changedUpdate(DocumentEvent e) {
				raporuGuncelle(); // Raporu guncelle
			}

			public void insertUpdate(DocumentEvent e) {
				raporuGuncelle(); // Raporu guncelle
			}

			public void removeUpdate(DocumentEvent e) {
				raporuGuncelle(); // Raporu guncelle
			}
		});
	}

	void raporuGuncelle() {
		try {
			var miktar = Integer.parseInt(metin.getText(0, metin.getLength())); // Miktari al
			int[] dizi = {50, 25, 10, 5, 1}; // Kurus degerleri
			rapor.setText(miktar + " kurus yapmak icin kullanilacaklar:\n"); // Raporun basligini yaz
			for(int eleman: dizi) { // Her kurus degeri icin
				rapor.append(miktar / eleman + " " + eleman + " kurus\n"); // Kac tane kullanilacagini yaz
				miktar %= eleman; // Kalan miktari hesapla
			}
		} catch (NumberFormatException e) {
			rapor.setText("Tam sayi degil veya aralik disinda"); // Hatali girdi
		} catch (Exception e) {
			rapor.setText(e.toString()); // Diger hatalari yaz
		}
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> { // GUi'yi ana thread uzerinde baslat
			var frame = new ParaUstuHesaplama();
			frame.setTitle("Para ustu Hesaplama"); // Pencere basligini ayarla
			frame.pack(); // Pencereyi boyutlandir
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cikis islemi
			frame.setVisible(true); // Pencereyi gorunur yap
		});
	}
}
