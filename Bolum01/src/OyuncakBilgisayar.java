// Oyuncak Bilgisayar: Izleme. Sunumdaki makine dili programini (LOAD, ADD,
// STORE, HALT) bir bellek dizisi ve R1 yazmaciyla adim adim calistirir.
public class OyuncakBilgisayar {

	public static void main(String[] args) {
		String[] bellek = new String[256];
		// 200: LOAD  R1, [205] ; R1 <- bellek[205]
		// 201: ADD   R1, [206] ; R1 <- R1 + bellek[206]
		// 202: STORE R1, [207] ; bellek[207] <- R1
		// 203: HALT            ; dur
		bellek[200] = "LOAD 205";
		bellek[201] = "ADD 206";
		bellek[202] = "STORE 207";
		bellek[203] = "HALT";
		bellek[205] = "102";  // veri
		bellek[206] = "25";   // veri
		bellek[207] = "0";    // sonuc buraya

		int pc = 200;  // program sayaci
		int r1 = 0;    // yazmac R1
		boolean calisiyor = true;
		while (calisiyor) {
			String[] komut = bellek[pc].split(" ");
			pc++;
			switch (komut[0]) {
				case "LOAD" -> r1 = Integer.parseInt(bellek[Integer.parseInt(komut[1])]);
				case "ADD" -> r1 = r1 + Integer.parseInt(bellek[Integer.parseInt(komut[1])]);
				case "STORE" -> bellek[Integer.parseInt(komut[1])] = String.valueOf(r1);
				default -> calisiyor = false;  // HALT
			}
			System.out.println(komut[0] + " -> R1 = " + r1 + ", bellek[207] = " + bellek[207]);
		}
		// LOAD -> R1 = 102, bellek[207] = 0
		// ADD -> R1 = 127, bellek[207] = 0
		// STORE -> R1 = 127, bellek[207] = 127
		// HALT -> R1 = 127, bellek[207] = 127
		System.out.println("bellek[207] = " + bellek[207]);  // bellek[207] = 127
	}
}

/* Beklenen cikti:
LOAD -> R1 = 102, bellek[207] = 0
ADD -> R1 = 127, bellek[207] = 0
STORE -> R1 = 127, bellek[207] = 127
HALT -> R1 = 127, bellek[207] = 127
bellek[207] = 127
*/
