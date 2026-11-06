package kalitim;

// final ile kalitimi sinirlamak: final metot gecersiz kilinamaz,
// final siniftan alt sinif turetilemez.
public class FinalKalitim {

	static class Hayvan {
		public final void nefesAl() {
			System.out.println("Nefes aliyor");
		}
	}

	static class Kedi extends Hayvan {
		// public void nefesAl() { ... }
		// derleme hatasi: nefesAl() in Kedi cannot override
		//   nefesAl() in Hayvan
		//   overridden method is final
	}

	static final class Sabit {
		int deger() { return 42; }
	}

	// class Deneme extends Sabit { }
	// derleme hatasi: cannot inherit from final Sabit
	static class Deneme { }

	public static void main(String[] args) {
		new Kedi().nefesAl();                     // Nefes aliyor  (Hayvan'in final surumu)
		System.out.println(new Sabit().deger());  // 42
		System.out.println(new Deneme() instanceof Object);   // true
	}
}
