
public class Ornek1 {
	public static int sayiyaEkle(int x, int miktar) {
		x = x + miktar;
		return x;
	}

	public static void main(String[] args) {
		int a = 15;
		int b = 10;
		a = Ornek1.sayiyaEkle(a, b);
		System.out.println(a);
	}
}
