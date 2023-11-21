
public class Ornek11 {

	public static void main(String[] args) {
		int x = 5; 
		int y = 10;
		x = x + y;
		System.out.println("x: " + x + " y: " + y); 
		int z = x++;
		System.out.println("x: " + x + " z: " + z); 
		y -= 3;
		System.out.println("x: " + x + " y: " + y); 
		x *= y;
		System.out.println("x: " + x + " y: " + y); 
		x /= 4;
		System.out.println("x: " + x + " y: " + y); 
	}

}
