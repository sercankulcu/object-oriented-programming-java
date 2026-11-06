import java.awt.*;
import javax.swing.*;

// ParaUstuHesaplama'yi pencere acmadan izler: miktar alanina "93" yazilir,
// DocumentListener raporuGuncelle'yi cagirir ve rapor yazdirilir.
public class ParaUstuIzleme {
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> {
			var frame = new ParaUstuHesaplama();
			Container icerik = frame.getContentPane();
			JPanel ustPanel = (JPanel) icerik.getComponent(0);
			JTextField miktarAlani = (JTextField) ustPanel.getComponent(1);
			JScrollPane kaydirma = (JScrollPane) icerik.getComponent(1);
			JTextArea rapor = (JTextArea) kaydirma.getViewport().getView();

			miktarAlani.setText("93");
			System.out.print(rapor.getText());
			// 93 kurus yapmak icin kullanilacaklar:
			// 1 50 kurus
			// 1 25 kurus
			// 1 10 kurus
			// 1 5 kurus
			// 3 1 kurus
			miktarAlani.setText("12a");
			System.out.println(rapor.getText());  // Tam sayi degil veya aralik disinda
			frame.dispose();
		});
	}
}
