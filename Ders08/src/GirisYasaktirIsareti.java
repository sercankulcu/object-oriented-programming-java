import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GirisYasaktirIsareti extends JPanel {
   
	private static final long serialVersionUID = 1L;

    // paintComponent metodu ekrani cizmek icin kullanilir
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Merkez noktasini hesapla
        var merkez = new Point(getWidth() / 2, getHeight() / 2);
        
        // Yaricapi hesapla (panelin en ve boyunun yarisi)
        var yaricap = Math.min(getWidth() / 2, getHeight() / 2) - 5;
        
        // ic yaricapi hesapla
        var icYaricap = (int)(yaricap * 0.9);
        
        // Barin genisligini hesapla
        var barGenislik = (int)(icYaricap * 1.4);
        
        // Barin yuksekligini hesapla
        var barYukseklik = (int)(icYaricap * 0.35);
        
        // Beyaz rengini ayarla ve daire ciz
        g.setColor(Color.WHITE);
        g.fillOval(merkez.x - yaricap, merkez.y - yaricap, 2 * yaricap, 2 * yaricap);
        
        // Kirmizi rengini ayarla ve ic daireyi ciz
        g.setColor(Color.RED);
        g.fillOval(merkez.x - icYaricap, merkez.y - icYaricap, icYaricap * 2, icYaricap * 2);
        
        // Beyaz rengini tekrar ayarla ve dikdortgen (bar) ciz
        g.setColor(Color.WHITE);
        g.fillRect(merkez.x - barGenislik / 2, merkez.y - barYukseklik / 2, barGenislik, barYukseklik);
    }

    public static void main(String[] args) {
        // Swing uygulamasini baslat
        SwingUtilities.invokeLater(() -> {
            var panel = new GirisYasaktirIsareti();
            
            // Panelin arka plan rengini ayarla
            panel.setBackground(Color.GREEN.darker());
            
            // Yeni bir pencere olustur
            var pencere = new JFrame("Giris Yasaktir!");
            pencere.setSize(400, 300);
            pencere.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            
            // Paneli pencereye ekle
            pencere.getContentPane().add(panel, BorderLayout.CENTER);
            
            // Pencereyi gorunur hale getir
            pencere.setVisible(true);
        });
    }
}
