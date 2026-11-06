// Isimlendirilmis sabitler: public static final. Sabite yeniden deger
// atanamaz; double ifade float'a kendiliginden donusmez.
public class Sabitler {
	public static final double PI = 3.14159;
	public static final int GUNLER_HAFTADA = 7;

	public static void main(String[] args) {
		double r = 2.0;
		double alan = PI * r * r;
		System.out.println("Alan: " + alan);  // Alan: 12.56636
		int gun = 4 * GUNLER_HAFTADA;
		System.out.println(gun + " gun");     // 28 gun

		// derleme hatasi: PI = 3.14;
		// error: cannot assign a value to static final variable PI
		// derleme hatasi: float alan = PI * r * r;
		// error: incompatible types: possible lossy conversion from double to float
		float alanF = (float) (PI * r * r);
		System.out.println(alanF);            // 12.56636
	}
}
