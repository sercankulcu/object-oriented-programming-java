// Kedi sinifi - Hayvan sinifindan miras alir
package inheritance;

public class Kedi extends Hayvan {

	public Kedi(String isim, int yas) {
		super(isim, yas);
	}

	@Override
	public void konus() {
		System.out.println(getIsim() + " miyavlar.");
	}

	public void avlan() {
		System.out.println(getIsim() + " avlandi!");
	}
}