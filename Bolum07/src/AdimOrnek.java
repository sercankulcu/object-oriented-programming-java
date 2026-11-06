// Step Into / Over / Out denemesi: kareToplam icinden kare cagrilir.
public class AdimOrnek {
	static int kare(int x) {
		return x * x;
	}

	static int kareToplam(int a, int b) {
		int k1 = kare(a);
		int k2 = kare(b);
		return k1 + k2;
	}

	public static void main(String[] args) {
		int s = kareToplam(3, 4);
		System.out.println("s = " + s);   // s = 25
	}
}
