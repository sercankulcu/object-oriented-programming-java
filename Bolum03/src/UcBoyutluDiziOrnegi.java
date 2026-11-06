// Ornek: UcBoyutluDiziOrnegi. 3x3x3 diziyi uc ic ice donguyle doldurur ve katman katman yazdirir.
public class UcBoyutluDiziOrnegi {
	public static void main(String[] args) {
		int[][][] ucBoyutluDizi = new int[3][3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				for (int z = 0; z < 3; z++) {
					ucBoyutluDizi[x][y][z] = x * 9 + y * 3 + z + 1;
				}
			}
		}
		System.out.println("Uc Boyutlu Dizinin Icerigi:");
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				for (int z = 0; z < 3; z++) {
					System.out.print(ucBoyutluDizi[x][y][z] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		// 1 2 3 / 4 5 6 / 7 8 9
		// 10 11 12 / 13 14 15 / 16 17 18
		// 19 20 21 / 22 23 24 / 25 26 27
	}
}
