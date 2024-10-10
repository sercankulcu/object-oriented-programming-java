package eamples;
import java.util.Scanner; // Kullanıcıdan giriş almak için Scanner sınıfını içe aktarır.

public class UsAlma {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner objesi oluşturur.
		
		System.out.println("Tabanı gir:"); // Kullanıcıya taban değerini girmesini ister.
		int taban = scanner.nextInt(); // Girilen taban değerini okur ve 'taban' değişkenine atar.
		
		System.out.println("Üssü gir:"); // Kullanıcıya üs değerini girmesini ister.
		int us = scanner.nextInt(); // Girilen üs değerini okur ve 'us' değişkenine atar.
		
		int sonuc = 1; // Sonucu hesaplamak için başlangıç değeri 1 olan bir 'sonuc' değişkeni tanımlar.
		
		// 'us' değeri kadar döngü çalışır. Her adımda 'taban' değeri ile 'sonuc' çarpılır.
		for(int i = 0; i < us; i++) { // Döngü, üs sayısı kadar tekrar eder.
			sonuc = sonuc * taban; // Her adımda 'sonuc', 'taban' ile çarpılır.
		}
		
		// Hesaplanan üs alma işlemini kullanıcıya gösterir.
		System.out.println(taban + "^" + us + " = " + sonuc); // Sonucu ekrana yazdırır.
	}
}
