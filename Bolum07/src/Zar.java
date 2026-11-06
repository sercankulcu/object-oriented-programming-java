import java.util.Random;

// Belirleyici testler: Random disaridan verilirse ayni tohum hep ayni zarlari uretir.
public class Zar {
	private final Random rastgele;

	public Zar(Random rastgele) {      // disaridan verilir
		this.rastgele = rastgele;
	}

	public int at() {
		return rastgele.nextInt(6) + 1;
	}

	public static void main(String[] args) {
		Zar zar = new Zar(new Random(42));
		for (int i = 0; i < 5; i++) {
			System.out.print(zar.at() + " ");
		}
		System.out.println();   // 3 4 1 3 1
	}
}
