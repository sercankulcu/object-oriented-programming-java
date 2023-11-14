
public class Ornek1 {
	public static void sayiyaEkle(int x, int miktar) {
		x = x + miktar;
	}

	public static void main(String[] args) {
		int a = 15;
		int b = 10;
		Ornek1.sayiyaEkle(a, b);
		System.out.println(a);
	}
}
