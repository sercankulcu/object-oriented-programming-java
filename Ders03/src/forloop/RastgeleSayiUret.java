package forloop;
import java.util.Random;

public class RastgeleSayiUret {

	public static void main(String[] args) {
		
		Random rastgele = new Random();
		int otuzbesdenkucukler = 0;
		int otuzbesdenbuyukler = 0;
		
		for(int i = 0; i < 10000; i++)
		{
			int sayi = rastgele.nextInt(100);
			System.out.print(sayi + " ");
			if(sayi < 35) {
				otuzbesdenkucukler++;
			} else {
				otuzbesdenbuyukler++;
			}
		}
		System.out.println("\nkucukler: " + otuzbesdenkucukler + 
				" buyukler: " + otuzbesdenbuyukler);
	}
}
