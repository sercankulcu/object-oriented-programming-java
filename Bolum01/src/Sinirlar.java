// Sinirlar Java'da: tasma, ondalik duyarlik ve tamsayi bolmesi.
public class Sinirlar {
	public static void main(String[] args) {
		int enBuyuk = Integer.MAX_VALUE;
		System.out.println(enBuyuk);      // 2147483647
		System.out.println(enBuyuk + 1);  // tasma -> -2147483648
		System.out.println(0.1 + 0.2);    // duyarlik -> 0.30000000000000004
		System.out.println(5 / 2);        // tamsayi bolmesi -> 2
	}
}
