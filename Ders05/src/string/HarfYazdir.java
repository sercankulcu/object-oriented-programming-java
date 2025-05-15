package string;

import java.util.Scanner;

public class HarfYazdir {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir kelime giriniz: ");
		String kelime = scanner.nextLine();

		for(int i = 1; i < kelime.length(); i += 2) {
			System.out.println("1. harf: " + kelime.charAt(i));
		}
		scanner.close();
	}
}
