import java.util.Scanner;

// Uc Tam Sayi: uc sayiyi kucukten buyuge yazar (sozde kodun Java hali).
// Klavye yerine sunumdaki izleme girdisi "7 3 5" okunur.
public class UcSayiSirala {
	public static void main(String[] args) {
		Scanner tarayici = new Scanner("7 3 5");
		System.out.print("Uc tamsayi girin: ");
		int birinci = tarayici.nextInt();
		int ikinci = tarayici.nextInt();
		int ucuncu = tarayici.nextInt();
		if (birinci <= ikinci && birinci <= ucuncu) {
			System.out.print(birinci + " ");
			if (ikinci <= ucuncu) System.out.println(ikinci + " " + ucuncu);
			else                  System.out.println(ucuncu + " " + ikinci);
		} else if (ikinci <= birinci && ikinci <= ucuncu) {
			System.out.print(ikinci + " ");
			if (birinci <= ucuncu) System.out.println(birinci + " " + ucuncu);
			else                   System.out.println(ucuncu + " " + birinci);
		} else {
			System.out.print(ucuncu + " ");
			if (birinci <= ikinci) System.out.println(birinci + " " + ikinci);
			else                   System.out.println(ikinci + " " + birinci);
		}
		// Uc tamsayi girin: 3 5 7
		tarayici.close();
	}
}
