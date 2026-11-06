// Sicaklik Donusumu: Tek Deger. Celsius degerini Fahrenheit ve Kelvin'e cevirir.
// Derece isareti ASCII kaynak icin unicode kacisiyla yazilir.
public class Program {
	public static void main(String[] args) {
		double celsius = 25.0;
		double fahrenheit = (celsius * 1.8) + 32;
		double kelvin = celsius + 273.15;
		System.out.println(celsius + " \u00b0C = " + fahrenheit + " \u00b0F = " + kelvin + " K");
		// 25.0 derece C = 77.0 derece F = 298.15 K
	}
}
