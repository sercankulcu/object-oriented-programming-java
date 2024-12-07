package forloop;

public class SicaklikDonusum {

	public static void main(String[] args)
	{
		{
			double celsius = 25.0;
			double fahrenheit = (celsius * 1.8) + 32;
			double kelvin = celsius + 273.15;
			System.out.println(celsius + "�C = " + fahrenheit + "�F = " + kelvin + "�K");
		}
		{
			double[] celsiuses = {-40, 0, 25, 100};
			for (double celsius : celsiuses) {
				double fahrenheit = (celsius * 1.8) + 32;
				double kelvin = celsius + 273.15;
				System.out.println(celsius + "�C = " + fahrenheit + "�F = " + kelvin + "�K");
			}
		}
	}
}