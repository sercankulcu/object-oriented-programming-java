import javax.swing.*;
import java.awt.*;

public class HanoiKuleleri extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int PENCERE_GENISLIGI = 600; // Pencere genisligi
    private static final int PENCERE_YUKSEKLIGI = 400; // Pencere yuksekligi

    private static final int CUBUK_GENISLIGI = 100; // cubuk genisligi (daha genis)
    private static final int CUBUK_YUKSEKLIGI = 300; // cubuk yuksekligi
    
    private static final int DISK_YUKSEKLIGI = 20; // Disk yuksekligi
    private static final int DISK_SAYISI = 4; // Disk sayisi
    private static final int CUBUK_SAYISI = 3; // cubuk sayisi

    private int[] cubukYukseklikleri; // cubuklarin yukseklikleri
    private JPanel[] cubuklar; // cubuklar
    private JPanel[] diskler; // Diskler

    public HanoiKuleleri() {
        cubukYukseklikleri = new int[CUBUK_SAYISI];

        // cubuklari dikey paneller olarak olustur
        cubuklar = new JPanel[CUBUK_SAYISI];
        for (int i = 0; i < CUBUK_SAYISI; i++) {
            cubuklar[i] = new JPanel();
            cubuklar[i].setPreferredSize(new Dimension(CUBUK_GENISLIGI, CUBUK_YUKSEKLIGI));
            cubuklar[i].setBackground(new Color(144, 238, 144)); // cubugun rengi acik yesil
        }

        // Diskleri yatay paneller olarak olustur, genisliklerini farkli yap
        diskler = new JPanel[DISK_SAYISI];
        for (int i = 0; i < DISK_SAYISI; i++) {
            // ilk disk daha dar, son disk daha genis olacak sekilde genislik ayarlandi
            int diskWidth = (DISK_SAYISI - i + 1) * DISK_YUKSEKLIGI; // Genislik, her bir disk icin farkli olacak
            diskler[i] = new JPanel();
            diskler[i].setPreferredSize(new Dimension(diskWidth, DISK_YUKSEKLIGI)); // Farkli genislikte diskler
            diskler[i].setBackground(Color.RED); // Disklerin rengi kirmizi
        }

        // Diskleri ilk cubuga ekle
        cubukYukseklikleri[0] = DISK_SAYISI;
        for (int i = 0; i < DISK_SAYISI; i++) {
            cubuklar[0].add(diskler[i]);
        }

        // cubuklari ana panele ekle
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        for (int i = 0; i < CUBUK_SAYISI; i++) {
            mainPanel.add(cubuklar[i]);
        }

        // Ana pencereyi ayarla
        setTitle("Tower of Hanoi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(PENCERE_GENISLIGI, PENCERE_YUKSEKLIGI);
        setLocationRelativeTo(null);
        setResizable(false); // Pencereyi yeniden boyutlandirilamaz yap
        add(mainPanel);
    }

    // Diski bir cubuktan digerine tasiyan metod
    public void moveDisk(int kaynak, int hedef) {
        // "kaynak" cubugundaki en ust diski cikar
        JPanel disk = (JPanel) cubuklar[kaynak].getComponent(--cubukYukseklikleri[kaynak]);
        cubuklar[kaynak].remove(disk);

        // Diski "hedef" cubuguna ekle
        cubuklar[hedef].add(disk, cubukYukseklikleri[hedef]++);

        // Ekrani guncelle
        revalidate();
        repaint();
    }

    // Ana metod
    public static void main(String[] args) throws InterruptedException {
    	HanoiKuleleri gui = new HanoiKuleleri();
        gui.setVisible(true);

        // Rekursif algoritma ile bulmacayi coz
        coz(DISK_SAYISI, 0, 2, 1, gui);
    }

    // Tower of Hanoi'yu cozmek icin rekursif metod
    public static void coz(int diskSayisi, int kaynak, int hedef, int yardimci, HanoiKuleleri gui) throws InterruptedException {
        if (diskSayisi == 1) {
            // En ust diski "kaynak" cubugundan "hedef" cubuguna tasi
            gui.moveDisk(kaynak, hedef);
            Thread.sleep(500); // 1 saniye bekle
        } else {
            // "kaynak" cubugundaki diskSayisi - 1 diski "yardimci" cubuguna tasi, "hedef" cubugunu yardimci olarak kullan
        	coz(diskSayisi - 1, kaynak, yardimci, hedef, gui);
            
            // Kalan diski "kaynak" cubugundan "hedef" cubuguna tasi
            gui.moveDisk(kaynak, hedef);
            
            Thread.sleep(500); // 1 saniye bekle
            
            // diskSayisi - 1 diski "yardimci" cubugundan "hedef" cubuguna tasi, "kaynak" cubugunu yardimci olarak kullan
            coz(diskSayisi - 1, yardimci, hedef, kaynak, gui);
        }
    }
}
