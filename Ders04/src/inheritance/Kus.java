// Kus sinifi - Hayvan sinifindan miras alir
package inheritance;

public class Kus extends Hayvan {

	public Kus(String isim, int yas) {
		super(isim, yas);
	}

	@Override
	public void konus() {
		System.out.println(getIsim() + " cikirir.");
	}

	public void ucmak() {
		System.out.println(getIsim() + " ucar!");
	}
}