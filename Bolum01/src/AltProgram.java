import java.util.Scanner;

// Alt Program: ortalama hesabi ayri bir metotta (vize %40, final %60).
// Sunumdaki girdi: 40 70.
public class AltProgram {

	static double ortalama(int vize, int fin) {
		double ort = vize * 0.4 + fin * 0.6;
		return ort;
	}

	public static void main(String[] args) {
		Scanner giris = new Scanner("40 70");
		int vize = giris.nextInt();
		int fin = giris.nextInt();
		double ort = ortalama(vize, fin);
		if (ort >= 50) System.out.println(ort + " gecti");  // 58.0 gecti
		else System.out.println(ort + " kaldi");
		giris.close();
	}
}
