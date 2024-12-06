// At sinifi - Hayvan sinifindan miras alir
package inheritance;

public class At extends Hayvan {

	public At(String isim, int yas) {
		super(isim, yas);
	}

	@Override
	public void konus() {
		System.out.println(getIsim() + " hirildar.");
	}

	public void kos() {
		System.out.println(getIsim() + " kosuyor!");
	}
}