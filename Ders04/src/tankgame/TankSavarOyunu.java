package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class TankSavarOyunu extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 600;

    // Tanklar ve top listeleri
    private ArrayList<Tank> tanklar;
    private ArrayList<Top> toplar;
    private Tanksavar tanksavar;  // Sadece 1 tane tanksavar

    // Oyun durumu
    private boolean sol = false, sag = false;
    private boolean atesEt = false;  // Ates etme durumu

    // Rastgele sayi ureteci
    private Random rastgele;

    // Skor
    private int score;

    public TankSavarOyunu() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.GRAY);
        tanklar = new ArrayList<>();
        toplar = new ArrayList<>();
        rastgele = new Random();
        score = 0;  // Skor baslangicta 0

        // Zamanlayici (Oyunun surekli guncellenmesi icin)
        Timer zamanlayici = new Timer(1000 / 60, this);  // 60 FPS
        zamanlayici.start();

        // Her saniye yeni tank uretecek zamanlayici
        Timer tankZamanlayici = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = rastgele.nextInt(PANEL_WIDTH - 50); // Tanklarin x pozisyonu
                int y = 0; // Tanklarin y pozisyonu en ustte olacak sekilde 0
                int tankType = rastgele.nextInt(2);  // Rastgele tank turu sec (0: T-90MS, 1: Leopard 2A4)
                if (tankType == 0) {
                    tanklar.add(new TankT90MS(x, y));  // T-90MS tanki
                } else {
                    tanklar.add(new TankLeopard2A4(x, y));  // Leopard 2A4 tanki
                }
            }
        });
        tankZamanlayici.start();

        // Oyun basinda yalnizca 1 tane tanksavar olusturulur
        int x = rastgele.nextInt(PANEL_WIDTH - 50); // Tanksavarin yerlestirilecegi x pozisyonu
        int y = PANEL_HEIGHT - 60;  // Tanksavari ekranin alt kismina yerlestir

        tanksavar = new TanksavarJawelin(x, y);  // Jawelin tanksavari

        // Klavye girdileri icin dinleyici
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    sol = true;
                } else if (key == KeyEvent.VK_RIGHT) {
                    sag = true;
                } else if (key == KeyEvent.VK_SPACE && !atesEt) {
                    atesEt = true;  // Space tusuna basildiginda ates etme islemi baslar
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    sol = false;
                } else if (key == KeyEvent.VK_RIGHT) {
                    sag = false;
                } else if (key == KeyEvent.VK_SPACE) {
                    atesEt = false;  // Space tusu birakildiginda ates etme islemi biter
                }
            }
        });
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Tanksavarin hareketi
        if (sol) {
            tanksavar.x -= 5;  // Sol tusuna basildiginda sola hareket et
        }
        if (sag) {
            tanksavar.x += 5;  // Sag tusuna basildiginda saga hareket et
        }

        // Tanklarin hareketi
        for (Tank tank : tanklar) {
            tank.tankKonum.y += tank.hiz;  // Tanklari hizlarina gore asagiya hareket ettir
        }

        // Toplarin hareketi
        ArrayList<Top> toplarSilinecek = new ArrayList<>();
        for (Top top : toplar) {
            top.topKonum.y -= 10;  // Topu yukariya hareket ettir
            if (top.topKonum.y < 0) {
                toplarSilinecek.add(top);  // Top ekranin disina cikarsa sil
            }
        }
        toplar.removeAll(toplarSilinecek);

        // Ates etme islemi (space tusuna basildiginda top eklenir)
        if (atesEt) {
            // Tanksavara uygun topu ekle
            toplar.add(tanksavar.topAt());
            atesEt = false;  // Ates ettikten sonra ates etme durumu sifirlanir
        }

        // Carpisma kontrolu: Toplar tanklarla carpisiyor mu?
        ArrayList<Tank> tanklarSilinecek = new ArrayList<>();

        for (Top top : toplar) {
            for (Tank tank : tanklar) {
                if (top.topKonum.intersects(tank.tankKonum)) {  // Carpisma tespiti
                    tanklarSilinecek.add(tank);  // Carpisan tanki silmek icin isaretle
                    toplarSilinecek.add(top);  // Carpisan topu silmek icin isaretle
                    score++;  // Skoru bir arttir
                }
            }
        }
        
        if(score % 10 == 0) {
        	if(tanksavar instanceof TanksavarJawelin) {
        		tanksavar = new TanksavarTow2A(tanksavar.x, tanksavar.y);  // Tow2A tanksavari
        	} else if(tanksavar instanceof TanksavarTow2A){
        		tanksavar = new TanksavarJawelin(tanksavar.x, tanksavar.y);  // Jawelin tanksavari
        	}
        	score++;
        }

        // Carpisan tanklari ve toplari listeden sil
        tanklar.removeAll(tanklarSilinecek);
        toplar.removeAll(toplarSilinecek);

        // Paneli yeniden ciz
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Tanklari ciz
        for (Tank tank : tanklar) {
            g.setColor(tank.renk);
            g.fillRect(tank.tankKonum.x, tank.tankKonum.y, tank.tankKonum.width, tank.tankKonum.height);
        }

        // Tanksavari ciz
        g.setColor(tanksavar.renk);
        g.fillRect(tanksavar.x, tanksavar.y, tanksavar.genislik, tanksavar.yukseklik);

        // Toplari ciz
        for (Top top : toplar) {
            g.setColor(top.renk);  // Toplarin kendine ait rengini kullan
            g.fillRect(top.topKonum.x, top.topKonum.y, top.topKonum.width, top.topKonum.height);
        }

        // Skoru ekranda goster
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Skor: " + score, 10, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank Savar Oyunu");
        TankSavarOyunu oyun = new TankSavarOyunu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(oyun);
        frame.pack();
        frame.setVisible(true);
    }
}
