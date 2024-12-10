// Gerekli Java kutuphaneleri iceri aktar
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Basit bir cizim paneli olusturan sinif
public class BasitCizimPaneli extends JPanel {
    private static final long serialVersionUID = -3630443364990545965L;

    // Kullanici tarafindan cizilen egri listesi
    private List<List<Point>> egriler = new ArrayList<>();

    // Constructor - panelin olay dinleyicilerini ayarlar
    public BasitCizimPaneli() {
        // Fare hareketlerini dinler (surukleme islemi)
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Mevcut egrinin sonuna yeni noktayi ekler
                egriler.get(egriler.size() - 1).add(new Point(e.getX(), e.getY()));
                // Paneli yeniden cizer
                repaint(0, 0, getWidth(), getHeight());
            }
        });

        // Fare tiklamalarini dinler
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Yeni bir egri olusturur ve ilk noktayi ekler
                var yeniEgri = new ArrayList<Point>();
                yeniEgri.add(new Point(e.getX(), e.getY()));
                egriler.add(yeniEgri);
            }
        });
    }

    // Panelin icerigini cizer
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Her bir egriyi ciz
        for (var egri : egriler) {
            var onceki = egri.get(0); // Ilk noktayi al
            for (var nokta : egri) {
                // Iki nokta arasinda bir cizgi ciz
                g.drawLine(onceki.x, onceki.y, nokta.x, nokta.y);
                onceki = nokta; // Onceki noktayi guncelle
            }
        }
    }

    // Programin giris noktasi
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Uygulama icin bir pencere olustur
            var frame = new JFrame("Basit Cizim Programi");
            // Cizim panelini pencereye ekle
            frame.getContentPane().add(new BasitCizimPaneli(), BorderLayout.CENTER);
            // Kapatma islemini ayarla
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // Pencere boyutunu ayarla
            frame.setSize(400, 300);
            // Pencereyi gorunur yap
            frame.setVisible(true);
        });
    }
}
