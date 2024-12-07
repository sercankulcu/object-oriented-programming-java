package recursive; 
import java.util.Scanner;

public class EnBuyukOrtakBolen {
	
	// Iki sayinin en buyuk ortak bolenini hesaplayan metod
	public static int ebob(int a, int b) { 
		// b sifir ise a geri don
		if (b == 0) 
			return a; 
		// Aksi halde, ebob(b, a % b) olarak tekrar cagirilir
		return ebob(b, a % b);  
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ebobu bulmak icin bir sayi girin: ");
		int sayi1 = sc.nextInt();
		System.out.print("Ebob bulmak icin bir sayi daha girin: ");
		int sayi2 = sc.nextInt();
		sc.close();
		
		// En buyuk ortak boleni hesaplamak icin ebob metodu cagrilir
		int sonuc = ebob(sayi1, sayi2);
		// Sonuc ekrana yazdirilir
		System.out.print("En buyuk ortak bolen: " + sonuc);
	}
}
