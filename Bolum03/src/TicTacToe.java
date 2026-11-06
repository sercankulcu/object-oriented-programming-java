import java.util.Scanner;

// Tic Tac Toe: char[][] tahta, hamle alma, kazanan ve berabere kontrolu.
// Hamleler sunumdaki ornek oyundan (1 1, 1 2, 2 2, 2 2, 1 3, 3 3) sabit dizgiyle okunur;
// O'nun ikinci 2 2 hamlesi dolu hucre oldugu icin yeniden sorulur.
public class TicTacToe {
	static Scanner scanner = new Scanner("1 1   1 2   2 2   2 2   1 3   3 3");

	public static void main(String[] args) {
		char[][] tahta = new char[3][3]; // 3x3'luk tahta
		char oyuncu = 'X'; // Ilk oyuncu X
		boolean oyunDevamEdiyor = true;
		tahtaDoldur(tahta); // Tum hucreler bos
		while (oyunDevamEdiyor) {
			tahtayiGoster(tahta);
			hamleYap(tahta, oyuncu);
			oyunDevamEdiyor = oyunDevamEdiyorMu(tahta, oyuncu);
			// Oyuncu degisimi
			oyuncu = (oyuncu == 'X') ? 'O' : 'X';
		}
		tahtayiGoster(tahta);
		// Tebrikler, X oyuncusu kazandi!
		// -------------
		// | X | O | O |
		// -------------
		// |   | X |   |
		// -------------
		// |   |   | X |
		// -------------
		// Metotlar static olmalidir; degilse:
		// derleme hatasi: non-static method tahtaDoldur(char[][]) cannot be referenced from a static context

		beraberKontroluIzleme();
	}

	public static void tahtaDoldur(char[][] tahta) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tahta[i][j] = ' ';
			}
		}
	}

	public static void tahtayiGoster(char[][] tahta) {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(tahta[i][j] + " | ");
			}
			System.out.println("\n-------------");
		}
	}

	public static void hamleYap(char[][] tahta, char oyuncu) {
		int satir, sutun;
		do {
			System.out.print("Sira " + oyuncu
					+ " oyuncusunda. Satir ve sutun secin (1-3): ");
			satir = scanner.nextInt() - 1;
			sutun = scanner.nextInt() - 1;
		} while (satir < 0 || satir > 2 || sutun < 0 || sutun > 2
				|| tahta[satir][sutun] != ' ');
		tahta[satir][sutun] = oyuncu;
	}

	public static boolean oyunDevamEdiyorMu(char[][] tahta, char oyuncu) {
		// Kazanan durumlarini kontrol et
		if ((tahta[0][0] == oyuncu && tahta[0][1] == oyuncu && tahta[0][2] == oyuncu) ||
			(tahta[1][0] == oyuncu && tahta[1][1] == oyuncu && tahta[1][2] == oyuncu) ||
			(tahta[2][0] == oyuncu && tahta[2][1] == oyuncu && tahta[2][2] == oyuncu) ||
			(tahta[0][0] == oyuncu && tahta[1][0] == oyuncu && tahta[2][0] == oyuncu) ||
			(tahta[0][1] == oyuncu && tahta[1][1] == oyuncu && tahta[2][1] == oyuncu) ||
			(tahta[0][2] == oyuncu && tahta[1][2] == oyuncu && tahta[2][2] == oyuncu) ||
			(tahta[0][0] == oyuncu && tahta[1][1] == oyuncu && tahta[2][2] == oyuncu) ||
			(tahta[0][2] == oyuncu && tahta[1][1] == oyuncu && tahta[2][0] == oyuncu)) {
			System.out.println("Tebrikler, " + oyuncu + " oyuncusu kazandi!");
			return false;
		}
		// Berabere durumunu kontrol et
		boolean berabere = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tahta[i][j] == ' ') {
					berabere = false;
					break;
				}
			}
			if (!berabere) {
				break;
			}
		}
		if (berabere) {
			System.out.println("Oyun berabere bitti.");
			return false;
		}
		return true;
	}

	// Berabere Kontrolu: Kod Izleme (bos hucresi olan bir tahta)
	static void beraberKontroluIzleme() {
		char[][] tahta = {
			{'X', 'O', 'X'},
			{'O', ' ', 'X'},
			{'O', 'X', 'O'}
		};
		boolean berabere = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tahta[i][j] == ' ') {
					berabere = false;
					break;
				}
			}
			if (!berabere) {
				break;
			}
		}
		System.out.println(berabere ? "berabere" : "devam");   // devam
	}
}
