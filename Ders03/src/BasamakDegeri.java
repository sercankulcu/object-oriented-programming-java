
public class BasamakDegeri {

	public static void main(String[] args) {

		for (int onlar = 0; onlar <= 4; onlar++) {
			for (int birler = 1; birler <= 9; birler++) {
				int sayi = onlar * 10 + birler;
				System.out.println("Onlar basamağı: " + onlar + ", Birler basamağı: " + birler + " --> " + sayi);
			}
		}
	}

}
