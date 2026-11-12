import java.awt.Color;

// java.awt.Color: RGB ile renk olusturma, bilesen okuma, darker().
public class ColorOrnegi {
	public static void main(String[] args) {
		Color turuncu = new Color(255, 128, 0);
		System.out.println(turuncu);              // java.awt.Color[r=255,g=128,b=0]
		System.out.println(turuncu.getGreen());   // 128
		System.out.println(Color.RED.darker());   // java.awt.Color[r=178,g=0,b=0]
	}
}

/* Beklenen cikti:
java.awt.Color[r=255,g=128,b=0]
128
java.awt.Color[r=178,g=0,b=0]
*/
