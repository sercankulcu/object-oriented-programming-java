
public class Ornek8 {

	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) { 
			if(i == 3) {
				break;
			}
			for (int j = 1; j <= 4; j++) { 
				if (j == 3) { 
					continue; 
				} 
				System.out.println("i: " + i + " j: " + j); 
			} 
		} 
	}
}
