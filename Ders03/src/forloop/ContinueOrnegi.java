package forloop;

public class ContinueOrnegi {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 10; i++) {
			
			if (i % 2 == 0) {
				System.out.println("Cift sayi: " + i);
				continue;
			}
			System.out.println("Tek sayi: " + i);
		}
	}
}
