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
    private Tanksavar tanksavar;  // Sadece 1 tane tanksavar olacak

    // Oyun durumu
    private boolean sol = false, sag = false;
    private boolean atesEt = false;  // Ates etme durumu

    // Rastgele sayi ureteci
    private Random random;

    public TankSavarOyunu() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.GRAY);
        tanklar = new ArrayList<>();
        toplar = new ArrayList<>();
        random = new Random();

        // Zamanlayici (Oyunun surekli guncellenmesi icin)
        Timer gameTimer = new Timer(1000 / 60, this);  // 60 FPS
        gameTimer.start();

        // Her saniye yeni tank uretecek zamanlayici
        Timer tankTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = random.nextInt(PANEL_WIDTH - 50); // Tanklarin x pozisyonu
                int y = 0; // Tanklarin y pozisyonu en ustte olacak sekilde 0
                int tankType = random.nextInt(2);  // Rastgele tank turu sec (0: T-90MS, 1: Leopard 2A4)
                if (tankType == 0) {
                    tanklar.add(new T90MS(x, y));  // T-90MS tanki
                } else {
                    tanklar.add(new Leopard2A4(x, y));  // Leopard 2A4 tanki
                }
            }
        });
        tankTimer.start();

        // Oyun basinda yalnizca 1 tane tanksavar olusturuluyor
        int x = random.nextInt(PANEL_WIDTH - 50); // Tanksavari yerlestirecegimiz x pozisyonu
        int y = PANEL_HEIGHT - 60;  // Tanksavari ekranin alt kismina yerlestir

        // Random bir tanksavar turu sec (0: Jawelin, 1: Tow2A)
        int tanksavarType = random.nextInt(2);
        if (tanksavarType == 0) {
            tanksavar = new Jawelin(x, y);  // Jawelin tanksavari
        } else {
            tanksavar = new Tow2A(x, y);  // Tow2A tanksavari
        }

        // Klavye girisleri icin dinleyici
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    sol = true;
                } else if (key == KeyEvent.VK_RIGHT) {
                    sag = true;
                } else if (key == KeyEvent.VK_SPACE && !atesEt) {
                    atesEt = true;  // Space tusuna basildiginda ates etme islemi baslasin
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
                    atesEt = false;  // Space tusu birakildiginda ates etme islemi bitiyor
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
            tank.tankRect.y += tank.hiz;  // Tanklari hizlarina gore asagiya hareket ettir
        }

        // Toplarin hareketi
        ArrayList<Top> toplarSilinecek = new ArrayList<>();
        for (Top top : toplar) {
            top.topRect.y -= 10;  // Topu yukariya hareket ettir
            if (top.topRect.y < 0) {
                toplarSilinecek.add(top);  // Top ekranin disina cikarsa sil
            }
        }
        toplar.removeAll(toplarSilinecek);

        // Ates etme islemi (space tusuna basildiginda top eklenir)
        if (atesEt) {
            // Tanksavara uygun topu ekle
        	if (tanksavar instanceof Jawelin) {
        		toplar.add(new Top37mm(tanksavar.x + tanksavar.width / 2 - 5, tanksavar.y - 20));  // Topu top listesine ekle
        	} else if (tanksavar instanceof Tow2A) {
        		toplar.add(new Top57mm(tanksavar.x + tanksavar.width / 2 - 5, tanksavar.y - 20));  // Topu top listesine ekle
        	}
            atesEt = false;  // Ates ettikten sonra ates etme durumu sifirlanir
        }
        
     // Carpisma kontrolu: Toplar tanklarla carpisiyor mu?
        ArrayList<Tank> tanklarSilinecek = new ArrayList<>();

        for (Top top : toplar) {
            for (Tank tank : tanklar) {
                if (top.topRect.intersects(tank.tankRect)) {  // Carpisma tespiti
                    tanklarSilinecek.add(tank);  // Carpisan tanki silmek icin isaretle
                    toplarSilinecek.add(top);  // Carpisan topu silmek icin isaretle
                }
            }
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
            g.fillRect(tank.tankRect.x, tank.tankRect.y, tank.tankRect.width, tank.tankRect.height);
        }

        // Tanksavari ciz
        g.setColor(tanksavar.renk);
        g.fillRect(tanksavar.x, tanksavar.y, tanksavar.width, tanksavar.height);

        // Toplari ciz
        for (Top top : toplar) {
            g.setColor(top.renk);  // Toplarin kendine ait rengini kullan
            g.fillRect(top.topRect.x, top.topRect.y, top.topRect.width, top.topRect.height);
        }
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
