// Ornek: DiziOrnegi. Dizi tanimlama, elemanlara deger atama, erisme ve dongu ile yazdirma.
public class DiziOrnegi {
	public static void main(String[] args) {
		// Bir diziyi tanimlama: 5 elemanli bir tamsayi dizisi
		int[] sayilar = new int[5];
		// Dizinin elemanlarina deger atama
		sayilar[0] = 10;
		sayilar[1] = 20;
		sayilar[2] = 30;
		sayilar[3] = 40;
		sayilar[4] = 50;
		// Dizinin elemanlarina erisme
		System.out.println("birinci eleman: " + sayilar[0]);   // birinci eleman: 10
		System.out.println("ucuncu eleman: " + sayilar[2]);    // ucuncu eleman: 30
		// Dizinin tum elemanlarini dongu icerisinde yazdirma
		System.out.print("Elemanlar: ");
		for (int i = 0; i < sayilar.length; i++) {
			System.out.print(sayilar[i] + " ");                // Elemanlar: 10 20 30 40 50
		}
		System.out.println();
	}
}
