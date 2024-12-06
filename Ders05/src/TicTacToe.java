import java.util.Scanner; 

public class TicTacToe {

	public static void main(String[] args) {

		char[][] tahta = new char[3][3]; // 3x3'luk oyun tahtasi
		char oyuncu = 'X'; // ilk oyuncu X ile baslar
		boolean oyunDevamEdiyor = true; // Oyun devam ediyor mu kontrolu
		tahtayiDoldur(tahta); // Tahtayi baslangic durumuyla doldur
		while (oyunDevamEdiyor) {
			tahtayiGoster(tahta); // Tahtayi ekrana yazdir
			hamleYap(tahta, oyuncu); // Oyuncunun hamlesini al
			oyunDevamEdiyor = oyunDevamEdiyorMu(tahta, oyuncu); // Oyun durumunu kontrol et
			oyuncu = (oyuncu == 'X') ? 'O' : 'X'; // Oyuncu degisimi
		}
		tahtayiGoster(tahta); // Oyunun bitiminde tahtayi goster
	}

	// Tahtayi baslangicta bosluklarla doldur
	public static void tahtayiDoldur(char[][] tahta) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tahta[i][j] = ' '; // Her hucreyi boslukla doldur
			}
		}
	}

	// Tahtayi ekrana yazdir
	public static void tahtayiGoster(char[][] tahta) {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(tahta[i][j] + " | "); // Her hucreyi ekrana yazdir
			}
			System.out.println("\n-------------");
		}
	}

	// Oyuncunun hamlesini yap
	public static void hamleYap(char[][] tahta, char oyuncu) {
		Scanner scanner = new Scanner(System.in);
		int satir = 0;
		int sutun = 0;
		do {
			// Kullanicidan satir ve sutun bilgisini al
			System.out.print("Sira " + oyuncu + " oyuncusunda. Satir ve sutun secin (1-3): ");
			satir = scanner.nextInt() - 1; // Kullanicidan alinan satir degerini 0 tabanli yap
			sutun = scanner.nextInt() - 1; // Kullanicidan alinan sutun degerini 0 tabanli yap
		} while (satir < 0 || satir > 2 || sutun < 0 || sutun > 2 || tahta[satir][sutun] != ' '); // Gecersiz secim kontrolu
		tahta[satir][sutun] = oyuncu; // Hamleyi tahta uzerine yap
	}

	// Oyun durumunu kontrol et
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
			System.out.println("Tebrikler, " + oyuncu + " oyuncusu kazandi!"); // Kazanan oyuncuyu bildir
			return false; // Oyun sonlanir
		}

		// Beraberlik durumunu kontrol et
		boolean berabere = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tahta[i][j] == ' ') {
					berabere = false; // Eger bos alan varsa oyun devam ediyor demektir
					break;
				}
			}
			if (!berabere) {
				break; // Oyun devam ediyor
			}
		}
		if (berabere) {
			System.out.println("Oyun berabere bitti."); // Oyun berabere bitti
			return false; // Oyun sonlanir
		}
		return true; // Oyun devam ediyor
	}
}
