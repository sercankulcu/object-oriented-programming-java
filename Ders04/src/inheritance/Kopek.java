// Kopek sinifi - Hayvan sinifindan miras alir
package inheritance;

public class Kopek extends Hayvan {

	public Kopek(String isim, int yas) {
		super(isim, yas);
	}

	@Override
	public void konus() {
		System.out.println(getIsim() + " havlar.");
	}

	public void topOyna() {
		System.out.println(getIsim() + " top oynuyor!");
	}
}