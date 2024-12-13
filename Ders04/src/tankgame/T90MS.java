package tankgame;

import java.awt.Color;

//T-90MS Tank sinifi
public class T90MS extends Tank {
    public T90MS(int x, int y) {
        super(x, y, 60, 60, Color.BLACK, 2);  // T-90MS'in boyutu, rengi ve hizi
    }
}