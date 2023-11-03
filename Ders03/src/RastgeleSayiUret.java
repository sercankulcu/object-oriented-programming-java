import java.util.Random;

public class RastgeleSayiUret {

	public static void main(String[] args) {
		
		Random rastgele = new Random();
		
		for(int i = 0; i < 100; i++)
		{
			System.out.println(rastgele.nextInt(10));
		}
	
	}

}
