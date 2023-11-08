public class Araba {
	private String marka;

	public Araba(String marka) {
		this.marka = marka;
	}

	public String getMarka() {
		return marka;
	}

	public static void main(String[] args) {
		Araba araba1 = new Araba("Toyota"); // araba1 referansı oluşturuluyor
		Araba araba2 = araba1; // araba2, araba1'i işaret ediyor

		System.out.println("Araba 1 Markası: " + araba1.getMarka());
		System.out.println("Araba 2 Markası: " + araba2.getMarka());
	}
}
