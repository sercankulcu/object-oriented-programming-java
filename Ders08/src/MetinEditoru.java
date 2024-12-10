import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;

public class MetinEditoru extends JFrame implements ActionListener {
	
    private static final long serialVersionUID = 1L;
    
    JTextArea metinAlani; // Metin alanini tanimlar
    
    JFrame pencere; // Pencere nesnesi tanimlar

    // Constructor: Editor arayuzunu olusturur
    public MetinEditoru() {
        pencere = new JFrame("Metin Editoru"); // Pencere basligi
        try {
            // Metal tema ayari
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        metinAlani = new JTextArea(); // Metin alani olusturulur
        JMenuBar menuCubugu = new JMenuBar(); // Menu cubugu olusturulur

        // Dosya menusunu olustur
        JMenu dosyaMenusu = new JMenu("Dosya");

        // Dosya menusune ait menu elemanlari
        JMenuItem yeniMenu = new JMenuItem("Yeni");
        JMenuItem acMenu = new JMenuItem("Ac");
        JMenuItem kaydetMenu = new JMenuItem("Kaydet");
        JMenuItem yazdirMenu = new JMenuItem("Yazdir");

        // Menu elemanlarina tiklama islemleri eklenir
        yeniMenu.addActionListener(this);
        acMenu.addActionListener(this);
        kaydetMenu.addActionListener(this);
        yazdirMenu.addActionListener(this);

        // Dosya menusune elemanlar eklenir
        dosyaMenusu.add(yeniMenu);
        dosyaMenusu.add(acMenu);
        dosyaMenusu.add(kaydetMenu);
        dosyaMenusu.add(yazdirMenu);

        // Duzenleme menusunu olustur
        JMenu duzenleMenusu = new JMenu("Duzenle");

        // Duzenleme menusune ait elemanlar
        JMenuItem kesMenu = new JMenuItem("Kes");
        JMenuItem kopyalaMenu = new JMenuItem("Kopyala");
        JMenuItem yapistirMenu = new JMenuItem("Yapistir");

        // Tiklama islemleri eklenir
        kesMenu.addActionListener(this);
        kopyalaMenu.addActionListener(this);
        yapistirMenu.addActionListener(this);

        // Duzenleme menusune elemanlar eklenir
        duzenleMenusu.add(kesMenu);
        duzenleMenusu.add(kopyalaMenu);
        duzenleMenusu.add(yapistirMenu);

        // Cikis menusunu olustur
        JMenuItem cikisMenu = new JMenuItem("Cikis");
        cikisMenu.addActionListener(this);

        // Menu cubuguna menu elemanlari eklenir
        menuCubugu.add(dosyaMenusu);
        menuCubugu.add(duzenleMenusu);
        menuCubugu.add(cikisMenu);

        // Pencereye menu cubugu ve metin alani eklenir
        pencere.setJMenuBar(menuCubugu);
        pencere.add(new JScrollPane(metinAlani));
        pencere.setSize(500, 500); // Pencere boyutu
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setVisible(true); // Pencere gorunur hale getirilir
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String komut = e.getActionCommand(); // Tetiklenen komut belirlenir

        if (komut.equals("Kes")) {
            metinAlani.cut(); // Metni kes
        } else if (komut.equals("Kopyala")) {
            metinAlani.copy(); // Metni kopyala
        } else if (komut.equals("Yapistir")) {
            metinAlani.paste(); // Metni yapistir
        } else if (komut.equals("Kaydet")) {
            // Dosya kaydetme islemi
            JFileChooser dosyaSecici = new JFileChooser(System.getProperty("user.dir"));
            int sonuc = dosyaSecici.showSaveDialog(null);

            if (sonuc == JFileChooser.APPROVE_OPTION) {
                File dosya = new File(dosyaSecici.getSelectedFile().getAbsolutePath());
                try (BufferedWriter yazici = new BufferedWriter(new FileWriter(dosya, false))) {
                    yazici.write(metinAlani.getText());
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(pencere, "Dosya kaydedilemedi: " + evt.getMessage());
                }
            }
        } else if (komut.equals("Yazdir")) {
            // Metni yazdirma islemi
            try {
                metinAlani.print();
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(pencere, "Yazdirma hatasi: " + evt.getMessage());
            }
        } else if (komut.equals("Ac")) {
            // Dosya acma islemi
            JFileChooser dosyaSecici = new JFileChooser(System.getProperty("user.dir"));
            int sonuc = dosyaSecici.showOpenDialog(null);

            if (sonuc == JFileChooser.APPROVE_OPTION) {
                File dosya = new File(dosyaSecici.getSelectedFile().getAbsolutePath());
                try (BufferedReader okuyucu = new BufferedReader(new FileReader(dosya))) {
                    metinAlani.read(okuyucu, null);
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(pencere, "Dosya acilamadi: " + evt.getMessage());
                }
            }
        } else if (komut.equals("Yeni")) {
            metinAlani.setText(""); // Metin alanini bosalt
        } else if (komut.equals("Cikis")) {
            pencere.dispose(); // Pencereyi kapat
        }
    }

    public static void main(String[] args) {
        new MetinEditoru(); // Uygulamayi baslat
    }
}
