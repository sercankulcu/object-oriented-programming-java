import java.util.Random;

/*
 * Here is an example of a Java method that generates a random password with a minimum of 8 
 * characters and a maximum of 12 characters, including at least one uppercase letter, 
 * one digit, and one special character:
 * 
 * */

public class PasswordGenerator {

    public static String generatePassword() {
    	
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/\\";

        Random random = new Random();

        int length = 8 + random.nextInt(5); // generates a random length between 8 and 12
        String password = "";

        // randomly select a character from each set and add it to the password
        password += upperCase.charAt(random.nextInt(upperCase.length()));
        password += digits.charAt(random.nextInt(digits.length()));
        password += specialChars.charAt(random.nextInt(specialChars.length()));

        for (int i = 0; i < length - 3; i++) {
            String chars = upperCase + digits + specialChars;
            password += chars.charAt(random.nextInt(chars.length()));
        }

        return shuffleString(password);
    }

    public static String shuffleString(String password) {
        char[] arr = password.toCharArray();
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rand.nextInt(i);
            char temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return new String(arr);
    }
    
    public static void main(String[] args)
    {
    	System.out.println(generatePassword());
    }
}
