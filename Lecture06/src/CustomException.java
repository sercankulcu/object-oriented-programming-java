
public class CustomException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    public static void main(String[] args) {
      try {
          throw new CustomException("This is a custom exception");
      } catch (CustomException e) {
          System.out.println(e.getMessage());
      }
  }
}
