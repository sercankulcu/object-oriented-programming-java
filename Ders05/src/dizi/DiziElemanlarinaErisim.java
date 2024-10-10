package dizi;

public class DiziElemanlarinaErisim {

	static void yazdir1(int[] dizi) {
		for (int i = 0; i < dizi.length; i++) {
			if (i % 2 == 0) {
				System.out.print(dizi[i] + ",");
			}
		}
		System.out.println();
	}

	static void yazdir2(int[] dizi) {
		for (int i = 1; i < dizi.length; i += i) {
			System.out.print(dizi[i] + ",");
		}
		System.out.println();
	}
	
	static void yazdir3(int[] dizi) {
		for (int i = 1; i < dizi.length; i++) {
			if(dizi[i] % 2 == 0)
				continue;
			System.out.print(dizi[i] + ",");
		}
		System.out.println();
	}
	
	static void yazdir4(int[] dizi) {
		for (int i = 1; i < dizi.length; i++) {
			if(dizi[i] % 3 == 0)
				break;
			System.out.print(dizi[i] + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// Örnek bir dizi
		int[] dizi = {5, 7, 10, 13, 12, 9, 9, 21, 22, 11, 17, 6, 5, 2, 44, 3};

		yazdir1(dizi);
		yazdir2(dizi);
		yazdir3(dizi);
		yazdir4(dizi);

	}
}
