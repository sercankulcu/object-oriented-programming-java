
public class Ornek5 {
	private static int i = 1;
	public static void main(String argv[]) {
		System.out.println(i);
		int i = 2; 
		Ornek5 ornek = new Ornek5();
		System.out.println(i);
		ornek.yazdir();
	} 
	public static void yazdir() {
		System.out.println(i);
	} 
}