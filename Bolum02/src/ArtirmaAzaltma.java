// Artirma ve azaltma: a++ once degeri verir sonra artirir; ++a once artirir.
public class ArtirmaAzaltma {
	public static void main(String[] args) {
		int a = 5;
		int b = a++;
		System.out.println(a + " " + b);  // 6 5
		int c = ++a;
		System.out.println(a + " " + c);  // 7 7
		int d = a--;
		System.out.println(a + " " + d);  // 6 7
	}
}
