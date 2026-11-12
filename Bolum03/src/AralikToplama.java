import java.util.Scanner;

// Aralik Toplama: a'dan b'ye kadar sayilarin toplami (for). a > b ise dongu hic donmez.
// Sunumdaki iki girdi (3 7 ve 7 3) sabit dizgilerden okunur.
public class AralikToplama {

	// Sunumdaki main govdesi; Scanner klavye yerine verilen dizgiden okur
	static void calistir(String girdi) {
		Scanner klavye = new Scanner(girdi);
		System.out.print("Baslangic degeri (a): ");
		int a = klavye.nextInt();
		System.out.print("Bitis degeri (b): ");
		int b = klavye.nextInt();
		int toplam = 0;
		for (int i = a; i <= b; i++) {
			toplam += i;
		}
		System.out.println("Sayilarin toplami: " + toplam);
		klavye.close();
	}

	public static void main(String[] args) {
		calistir("3 7");   // Baslangic degeri (a): Bitis degeri (b): Sayilarin toplami: 25
		calistir("7 3");   // Baslangic degeri (a): Bitis degeri (b): Sayilarin toplami: 0
	}
}

/* Beklenen cikti:
Baslangic degeri (a): Bitis degeri (b): Sayilarin toplami: 25
Baslangic degeri (a): Bitis degeri (b): Sayilarin toplami: 0
*/
