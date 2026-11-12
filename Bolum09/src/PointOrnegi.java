import java.awt.Point;

// java.awt.Point: koordinatlar, uzaklik, setLocation ve translate.
public class PointOrnegi {
	public static void main(String[] args) {
		Point nokta = new Point(30, 40);
		double xKoordinati = nokta.getX();
		double yKoordinati = nokta.getY();
		System.out.println(xKoordinati + " " + yKoordinati);  // 30.0 40.0
		System.out.println(nokta.x + " " + nokta.y);          // 30 40
		System.out.println(nokta.distance(0, 0));             // 50.0
		nokta.setLocation(60, 80);
		System.out.println(nokta);                            // java.awt.Point[x=60,y=80]
		nokta.translate(5, -10);   // 5 saga, 10 yukari
		System.out.println(nokta);                            // java.awt.Point[x=65,y=70]
		System.out.println(Point.distance(0, 0, 3, 4));       // 5.0
	}
}

/* Beklenen cikti:
30.0 40.0
30 40
50.0
java.awt.Point[x=60,y=80]
java.awt.Point[x=65,y=70]
5.0
*/
