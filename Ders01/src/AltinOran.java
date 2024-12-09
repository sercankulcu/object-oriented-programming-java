/*
 * Kod, (1 + sqrt(5)) / 2 formulu kullanilarak altin orani hesaplar ve 
 * sonucu konsola yazdirir.
 * 
 * Altin oran, yaklasik olarak 1.61803398875'e esittir. 
 * Matematik ve sanatta sikca karsilasilan bir sabittir ve tasarim 
 * ile mimaride de kullanilir.
 * 
 */

public class AltinOran {

	public static void main(String[] args) {

		// Altin orani hesaplama
		double altinOran = (1 + Math.sqrt(5)) / 2;

		// Altin orani yazdirma
		System.out.println("Altin oran: " + altinOran);
	}
}
