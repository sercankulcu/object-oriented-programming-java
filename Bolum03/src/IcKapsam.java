// Yerel ve Global Kapsam: sinif alani her yerde, blok degiskeni yalnizca blogun icinde gorunur.
public class IcKapsam {
	static int globalDegisken = 10; // global (sinif alani)
	static void fonksiyon() {
		int disDegisken = 10;       // yerel kapsam
		{
			int icDegisken = 5;
			// disDegisken ve icDegisken burada erisilebilir
			System.out.println(disDegisken + icDegisken
					+ globalDegisken);                       // 25
		}
		// icDegisken burada YOK
	}
	public static void main(String[] args) {
		fonksiyon();
	}
}
