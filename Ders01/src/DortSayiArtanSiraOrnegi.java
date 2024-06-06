import java.util.Scanner;

public class DortSayiArtanSiraOrnegi {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Birinci sayıyı girin: ");
		int sayi1 = scanner.nextInt();

		System.out.print("İkinci sayıyı girin: ");
		int sayi2 = scanner.nextInt();

		System.out.print("Üçüncü sayıyı girin: ");
		int sayi3 = scanner.nextInt();

		System.out.print("Dördüncü sayıyı girin: ");
		int sayi4 = scanner.nextInt();

		scanner.close();

	// Basit karşılaştırmalar kullanarak sayıları sıralama
    int temp;
    
    // sayi1 ve sayi2'yi gerekirse takas et
    if (sayi1 > sayi2) {
        temp = sayi1;
        sayi1 = sayi2;
        sayi2 = temp;
    }
    // sayi1 ve sayi3'ü gerekirse takas et
    if (sayi1 > sayi3) {
        temp = sayi1;
        sayi1 = sayi3;
        sayi3 = temp;
    }
    // sayi1 ve sayi4'ü gerekirse takas et
    if (sayi1 > sayi4) {
        temp = sayi1;
        sayi1 = sayi4;
        sayi4 = temp;
    }
    // sayi2 ve sayi3'ü gerekirse takas et
    if (sayi2 > sayi3) {
        temp = sayi2;
        sayi2 = sayi3;
        sayi3 = temp;
    }
    // sayi2 ve sayi4'ü gerekirse takas et
    if (sayi2 > sayi4) {
        temp = sayi2;
        sayi2 = sayi4;
        sayi4 = temp;
    }
    // sayi3 ve sayi4'ü gerekirse takas et
    if (sayi3 > sayi4) {
        temp = sayi3;
        sayi3 = sayi4;
        sayi4 = temp;
    }

		System.out.println("Artan sırayla: " + sayi1 + ", " + sayi2 + ", " + sayi3 + ", " + sayi4);
	}
}
