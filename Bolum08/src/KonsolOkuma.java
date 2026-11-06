import java.util.Scanner;

// Klavyeden okuma: nextLine bir satir, nextInt bir tamsayi okur.
// Klavye yerine sabit girdi: "Ayse Yilmaz" ve "19" yazilmis gibi.
public class KonsolOkuma {
	public static void main(String[] args) {
		Scanner klavye = new Scanner("Ayse Yilmaz\n19\n");   // sunumda: new Scanner(System.in)
		System.out.print("Adiniz: ");
		String ad = klavye.nextLine();
		System.out.print("Yasiniz: ");
		int yas = klavye.nextInt();
		int seneye = yas + 1;
		System.out.println("Merhaba " + ad + "!");                // Adiniz: Yasiniz: Merhaba Ayse Yilmaz!
		System.out.println("Seneye " + seneye + " yasindasin.");  // Seneye 20 yasindasin.
		klavye.close();
		// Girdi ekranda yankilanmadigi icin ilk satir "Adiniz: Yasiniz: Merhaba Ayse Yilmaz!" olur.
	}
}
