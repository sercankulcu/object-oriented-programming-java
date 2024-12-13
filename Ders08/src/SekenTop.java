// Gerekli Java kutuphaneleri iceri aktar
import java.awt.Graphics; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

// Topun bir pencere icinde seker gibi hareket etmesini simule eden bir program
public class SekenTop extends JPanel implements ActionListener {

    private static final long serialVersionUiD = -6368396547703393842L;

    // Pencere boyutlari
    private static final int GENiSLiK = 600;
    private static final int YUKSEKLiK = 400;

    // Topun baslangic konumu
    private static final int BASLANGiC_X = 50;
    private static final int BASLANGiC_Y = 50;

    // Hareketin hizini belirleyen sure (milisaniye)
    private static final int GECiKME = 10;

    // Topun konumu ve hareket yonu
    private int x;
    private int y;
    private int dx;
    private int dy;

    // Constructor - Topun baslangic durumu ve zamanlayici ayarlanir
    public SekenTop() {
        x = BASLANGiC_X;
        y = BASLANGiC_Y;
        dx = 2; // X ekseninde hareket hizi
        dy = 2; // Y ekseninde hareket hizi

        // Zamanlayici olusturulur ve baslatilir
        Timer zamanlayici = new Timer(GECiKME, this);
        zamanlayici.start();
    }

    // Panel icinde cizim islemini yapar
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Topu cizer (50x50 boyutunda bir daire)
        g.fillOval(x, y, 50, 50);
    }

    // Her GECiKME milisaniyede bir cagrilir
    @Override
    public void actionPerformed(ActionEvent e) {
        // Topun konumunu gunceller
        x += dx;
        y += dy;

        // Top pencerenin sol/sag kenarina carparsa yonu ters cevir
        if (x < 0 || x > GENiSLiK - 60) {
            dx *= -1;
        }

        // Top pencerenin ust/alt kenarina carparsa yonu ters cevir
        if (y < 0 || y > YUKSEKLiK - 75) {
            dy *= -1;
        }

        // Paneli yeniden ciz
        repaint();
    }

    // Programin giris noktasi
    public static void main(String[] args) {
        // Pencere olustur ve ayarlarini yap
        JFrame pencere = new JFrame("Seken Top");
        pencere.add(new SekenTop()); // Cizim panelini ekle
        pencere.setSize(GENiSLiK, YUKSEKLiK); // Pencere boyutlarini ayarla
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Kapatma islemini ayarla
        pencere.setVisible(true); // Pencereyi gorunur yap
    }
}
