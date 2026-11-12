package kalitim;

// Object sinifi ve toString: her sinif Object'ten turer. toString yazilmazsa
// Object'in surumu "SinifAdi@hash" verir; yazilinca nesne okunur bicimde yazdirilir.
public class ToStringMetodu {

	// Object Sinifi
	static class Bos {
		static class Nokta { }
		// derleyicinin gordugu:
		// class Nokta extends Object { }
	}

	// toString yazilmamis Nokta
	static class Yalin {
		static class Nokta {
			private int x, y;
			Nokta(int x, int y) {
				this.x = x; this.y = y;
			}
			int getX() { return x; }
			int getY() { return y; }
		}
	}

	static class Nokta {
		private int x, y;
		Nokta(int x, int y) {
			this.x = x; this.y = y;
		}
		@Override
		public String toString() {
			return "Nokta[x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) {
		System.out.println(Bos.Nokta.class.getSuperclass().getSimpleName());   // Object

		System.out.println(new Yalin.Nokta(3, 4));
		// kalitim.ToStringMetodu$Yalin$Nokta@28a418fc   (sunumda Nokta@28a418fc;
		// paket ve dis sinif adi eklenir, @'ten sonraki deger her calismada degisebilir)

		Nokta n = new Nokta(3, 4);
		System.out.println(n);                 // Nokta[x=3, y=4]
		System.out.println("Konum: " + n);     // Konum: Nokta[x=3, y=4]
	}
}

/* Beklenen cikti:
Object
kalitim.ToStringMetodu$Yalin$Nokta@28a418fc
Nokta[x=3, y=4]
Konum: Nokta[x=3, y=4]
*/
