package forloop;

public class SicaklikDonusumu {

    public static void main(String[] args) {

        // Tek bir sicaklik degeri icin donusum
        {
            double celsius = 25.0; // Celsius degeri
            double fahrenheit = (celsius * 1.8) + 32; // Fahrenheit'e donusum
            double kelvin = celsius + 273.15; // Kelvin'e donusum

            // Sonuclari ekrana yazdir
            System.out.println(celsius + " °C = " + fahrenheit + " °F = " + kelvin + " °K");
        }

        // Bir dizi sicaklik degerleri icin donusum
        {
            // Sicaklik degerleri dizisi
            double[] celsiuses = {-40, 0, 25, 100}; 

            // Her bir sicaklik degeri icin donusum yap
            for (double celsius : celsiuses) {
                double fahrenheit = (celsius * 1.8) + 32; // Fahrenheit'e donusum
                double kelvin = celsius + 273.15; // Kelvin'e donusum

                // Sonuclari ekrana yazdir
                System.out.println(celsius + " °C = " + fahrenheit + " °F = " + kelvin + " °K");
            }
        }
    }
}
