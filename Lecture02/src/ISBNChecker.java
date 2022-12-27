/*
 * Here is a Java code example that checks whether a given string is a valid ISBN 
 * (International Standard Book Number) code:
 * 
 * */

public class ISBNChecker {
	
  public static boolean isValidISBN(String isbn) {
  	
    if (isbn == null || isbn.length() != 10) {
      return false;
    }
    int sum = 0;
    for (int i = 0; i < 9; i++) {
      char c = isbn.charAt(i);
      if (!Character.isDigit(c)) {
        return false;
      }
      sum += (i + 1) * (c - '0');
    }
    char lastChar = isbn.charAt(9);
    if (lastChar == 'X') {
      sum += 10;
    } else if (Character.isDigit(lastChar)) {
      sum += lastChar - '0';
    } else {
      return false;
    }
    return sum % 11 == 0;
  }

  public static void main(String[] args) {
    String isbn = "0-201-31452-5";
    if (isValidISBN(isbn)) {
      System.out.println(isbn + " is a valid ISBN.");
    } else {
      System.out.println(isbn + " is not a valid ISBN.");
    }
  }
}
