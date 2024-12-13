package tankgame;

import java.awt.Color;
import java.awt.Rectangle;

//Tank sinifi
public class Tank {
    Rectangle tankKonum;  // Tankin dikdortgeni (boyut ve pozisyon)
    Color renk;  // Tankin rengi
    int hiz;  // Tankin hizi

    public Tank(int x, int y, int genislik, int yukseklik, Color renk, int hiz) {
        this.tankKonum = new Rectangle(x, y, genislik, yukseklik);
        this.renk = renk;
        this.hiz = hiz;
    }

    public void hareketEt() {
        tankKonum.y += hiz;  // Tanklari hizlarina gore asagiya hareket ettir
    }
}