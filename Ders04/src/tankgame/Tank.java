package tankgame;

import java.awt.Color;
import java.awt.Rectangle;

//Tank sinifi
public class Tank {
    Rectangle tankRect;  // Tankin dikdortgeni (boyut ve pozisyon)
    Color renk;  // Tankin rengi
    int hiz;  // Tankin hizi

    public Tank(int x, int y, int width, int height, Color renk, int hiz) {
        this.tankRect = new Rectangle(x, y, width, height);
        this.renk = renk;
        this.hiz = hiz;
    }

    public void hareketEt() {
        tankRect.y += hiz;  // Tanklari hizlarina gore asagiya hareket ettir
    }
}