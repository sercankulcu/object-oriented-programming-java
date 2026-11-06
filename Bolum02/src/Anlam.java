// Anlam (semantics): soz dizimi dogru ama anlam yanlis olabilir.
// Tamsayi bolmesi ve islec onceligi (Tam Sayi Bolmesi: Kod Izleme).
public class Anlam {
	public static void main(String[] args) {
		int a = 7, b = 8;
		int ortalama = (a + b) / 2;
		System.out.println(ortalama);       // 7.5 beklenirken -> 7
		System.out.println(a + b / 2);      // oncelik -> 11
		System.out.println((a + b) / 2.0);  // dogru -> 7.5
	}
}
