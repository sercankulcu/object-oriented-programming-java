package array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class HazineAvcisi {
    private static final int IZGARA_BOYUTU = 10; // 10x10 izgara boyutu
    private int hazineX, hazineY; // Hazinenin konumu
    private JButton[][] dugmeler; // Izgaradaki dugmeler
    private JFrame cerceve;

    private int oyuncuX = 0; // Oyuncunun baslangic satiri
    private int oyuncuY = 0; // Oyuncunun baslangic sutunu
    private int oncekiUzaklik; // Onceki uzaklik

    public HazineAvcisi() {
        Random random = new Random();
        hazineX = random.nextInt(IZGARA_BOYUTU); // Rastgele satir
        hazineY = random.nextInt(IZGARA_BOYUTU); // Rastgele sutun

        // Baslangic uzakligini hesapla
        oncekiUzaklik = Math.abs(hazineX - oyuncuX) + Math.abs(hazineY - oyuncuY);

        // Oyun arayuzunu baslat
        cerceve = new JFrame("Hazine Avcisi");
        cerceve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cerceve.setSize(500, 500);
        cerceve.setLayout(new GridLayout(IZGARA_BOYUTU, IZGARA_BOYUTU));

        // Dugme izgarasini olustur
        dugmeler = new JButton[IZGARA_BOYUTU][IZGARA_BOYUTU];
        for (int i = 0; i < IZGARA_BOYUTU; i++) {
            for (int j = 0; j < IZGARA_BOYUTU; j++) {
                JButton dugme = new JButton();
                dugme.setBackground(Color.LIGHT_GRAY);
                dugme.setFont(new Font("Arial", Font.BOLD, 16));
                dugmeler[i][j] = dugme;
                cerceve.add(dugme);
            }
        }

        // Oyuncunun baslangic pozisyonunu isaretle
        dugmeler[oyuncuX][oyuncuY].setBackground(Color.YELLOW);
        dugmeler[oyuncuX][oyuncuY].setText("🚶");

        // Klavye dinleyicisi ekle
        cerceve.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                hareketEt(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        cerceve.setFocusable(true); // Klavye girisine odaklanmayi etkinlestir
        cerceve.setVisible(true);
    }

    // Oyuncunun hareketini isleyen metot
    private void hareketEt(int tusKodu) {
        int yeniX = oyuncuX;
        int yeniY = oyuncuY;

        // Yon tuslarina gore hareket
        switch (tusKodu) {
            case KeyEvent.VK_UP: // Yukari
                if (oyuncuX > 0) yeniX--;
                break;
            case KeyEvent.VK_DOWN: // Asagi
                if (oyuncuX < IZGARA_BOYUTU - 1) yeniX++;
                break;
            case KeyEvent.VK_LEFT: // Sol
                if (oyuncuY > 0) yeniY--;
                break;
            case KeyEvent.VK_RIGHT: // Sag
                if (oyuncuY < IZGARA_BOYUTU - 1) yeniY++;
                break;
        }

        // Oyuncu ayni yerde kalmissa islem yapma
        if (yeniX == oyuncuX && yeniY == oyuncuY) return;

        // Yeni uzakligi hesapla
        int yeniUzaklik = Math.abs(hazineX - yeniX) + Math.abs(hazineY - yeniY);

        // Eski pozisyonu sifirla
        dugmeler[oyuncuX][oyuncuY].setBackground(Color.LIGHT_GRAY);
        dugmeler[oyuncuX][oyuncuY].setText("");

        // Yeni pozisyonu isaretle
        oyuncuX = yeniX;
        oyuncuY = yeniY;
        dugmeler[oyuncuX][oyuncuY].setBackground(Color.YELLOW);
        dugmeler[oyuncuX][oyuncuY].setText("🚶");

        // Kazanma durumu
        if (oyuncuX == hazineX && oyuncuY == hazineY) {
            dugmeler[oyuncuX][oyuncuY].setBackground(Color.GREEN);
            dugmeler[oyuncuX][oyuncuY].setText("💎");
            JOptionPane.showMessageDialog(cerceve, "Tebrikler! Hazineyi buldunuz!");
            oyunuSifirla();
            return;
        }

        // Uzaklik kontrolu
        if (yeniUzaklik > oncekiUzaklik) {
            JOptionPane.showMessageDialog(cerceve, "Yanlis yondesiniz!");
        } else {
            JOptionPane.showMessageDialog(cerceve, "Hazineye yaklasiyorsunuz!");
        }

        oncekiUzaklik = yeniUzaklik; // Uzakligi guncelle
    }

    // Oyunu sifirla
    private void oyunuSifirla() {
        Random random = new Random();
        hazineX = random.nextInt(IZGARA_BOYUTU); // Yeni hazine konumu
        hazineY = random.nextInt(IZGARA_BOYUTU);

        oyuncuX = 0; // Oyuncu baslangic noktasina doner
        oyuncuY = 0;
        oncekiUzaklik = Math.abs(hazineX - oyuncuX) + Math.abs(hazineY - oyuncuY);

        // Tum dugmeleri sifirla
        for (int i = 0; i < IZGARA_BOYUTU; i++) {
            for (int j = 0; j < IZGARA_BOYUTU; j++) {
                dugmeler[i][j].setText("");
                dugmeler[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }

        // Oyuncunun baslangic pozisyonunu isaretle
        dugmeler[oyuncuX][oyuncuY].setBackground(Color.YELLOW);
        dugmeler[oyuncuX][oyuncuY].setText("🚶");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HazineAvcisi::new);
    }
}
