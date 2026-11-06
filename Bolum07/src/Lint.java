public class Lint { // -Xlint uyarilari: fall-through ve sifira bolme; satir numaralari sunumdakiyle ayni
	public static void main(String[] args) {
		int gun = 2;
		switch (gun) {
			case 1:
				System.out.println("Pazartesi");
			case 2:
				System.out.println("Sali");        // Sali
			case 3:
				System.out.println("Carsamba");    // Carsamba (break yok: fall-through)
				break;
		}
		try { int x = 10 / 0; } catch (ArithmeticException e) { System.out.println("yakalandi: " + e); }
	}
}
// Sunumdaki satir 13: int x = 10 / 0;  -> calisma zamaninda ArithmeticException: / by zero
// javac -Xlint:all Lint.java -> [divzero] satir 13, [fallthrough] satir 7 ve 9 (bilerek)
// Cikti: yakalandi: java.lang.ArithmeticException: / by zero
