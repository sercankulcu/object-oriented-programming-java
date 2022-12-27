import java.util.Base64;

public class Base64EncodeDecode {
	
	public static String encodeBase64(String input) {
    return Base64.getEncoder().encodeToString(input.getBytes());
  }
	
	public static String decodeBase64(String input) {
    return new String(Base64.getDecoder().decode(input.getBytes()));
  }
	
	public static void main(String[] args) {
		
		String encoded = Base64EncodeDecode.encodeBase64("Object Oriented Programming");
		System.out.println(encoded);
		String decoded = Base64EncodeDecode.decodeBase64(encoded);
		System.out.println(decoded);
	}

}
