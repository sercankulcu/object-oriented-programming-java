package tankgame;

import java.awt.Color;

//Jawelin Tanksavar sinifi
public class TanksavarJawelin extends Tanksavar {
    public TanksavarJawelin(int x, int y) {
        super(x, y, Color.RED); 
        top = new Top37mm(x + genislik / 2 - 5, y - 20);
    }

	@Override
	public Top topAt() {
		// TODO Auto-generated method stub
		return new Top37mm(x + genislik / 2 - 5, y - 20);
	}
}