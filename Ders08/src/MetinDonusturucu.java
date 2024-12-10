// Gerekli Java kutuphaneleri iceri aktar
import java.awt.BorderLayout; 
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// Kullanici metni kucuk veya buyuk harfe ceviren bir uygulama
public class MetinDonusturucu {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Metin alani olustur
            var metinAlani = new JTextArea("Java Programlama", 8, 50);

            // Kucuk harfe cevirme dugmesi
            var kucukHarfButton = new JButton("Kucuk Harfe Cevir");
            kucukHarfButton.addActionListener(e -> 
                metinAlani.setText(metinAlani.getText().toLowerCase())
            );

            // Buyuk harfe cevirme dugmesi
            var buyukHarfButton = new JButton("Buyuk Harfe Cevir");
            buyukHarfButton.addActionListener(e -> 
                metinAlani.setText(metinAlani.getText().toUpperCase())
            );

            // Dugmeler icin bir panel olustur
            var dugmePaneli = new JPanel();
            dugmePaneli.add(kucukHarfButton);
            dugmePaneli.add(buyukHarfButton);

            // Ana pencere olustur
            var pencere = new JFrame("Metin Donusturucu");
            pencere.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // Metin alani pencereye ekle
            pencere.getContentPane().add(new JScrollPane(metinAlani), BorderLayout.CENTER);
            // Dugme paneli pencereye ekle
            pencere.getContentPane().add(dugmePaneli, BorderLayout.SOUTH);
            pencere.pack(); // Pencere boyutu otomatik ayarla
            pencere.setVisible(true); // Pencere gorunur yap
        });
    }
}
