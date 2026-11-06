package kalitim;

// Metodu gecersiz kilma (overriding) ve asiri yukleme (overloading),
// @Override etiketi ile yakalanan hatalar.
public class GecersizKilma {

	static class Sekil {
		public void ciz() {
			System.out.println("Sekil ciziliyor.");
		}
	}

	static class Dikdortgen extends Sekil {
		// miras alinan metodu gecersiz kil
		@Override
		public void ciz() {             // gecersiz kilma
			System.out.println("Dikdortgen ciziliyor.");
		}
		public void ciz(String renk) {  // asiri yukleme
			System.out.println(renk + " dikdortgen ciziliyor.");
		}

		// alt sinifta: void ciz()
		// derleme hatasi: ciz() in Dikdortgen cannot override
		//   ciz() in Sekil
		//   attempting to assign weaker access
		//   privileges; was public

		// alt sinifta: public int ciz()
		// derleme hatasi: ciz() in Dikdortgen cannot override
		//   ciz() in Sekil
		//   return type int is not compatible
		//   with void

		//     @Override
		//     public void Ciz() { ... }
		// derleme hatasi: method does not override or implement
		//   a method from a supertype
	}

	public static void main(String[] args) {
		new Sekil().ciz();        // Sekil ciziliyor.
		new Dikdortgen().ciz();   // Dikdortgen ciziliyor.

		Dikdortgen d = new Dikdortgen();
		d.ciz("Mavi");            // Mavi dikdortgen ciziliyor.
	}
}
