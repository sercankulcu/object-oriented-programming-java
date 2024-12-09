package forloop;

public class OnaKadarToplama {
    
    public static void main(String[] args) {
    	
    	// 1'den 10'a kadar olan sayilari ekrana yazdirma
        System.out.print("1'den 10'a kadar olan sayilar: ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " "); // Sayilari ekrana yazdir
        }
        System.out.println(); // Yeni satir
        
        int toplam = 0; // Toplam degiskeni baslangicta 0 olarak tanimlanir

        // 1'den 10'a kadar sayilarin toplami icin dongu
        for (int i = 1; i <= 10; i++) {
            toplam += i; // Her bir sayi toplama eklenir
        }

        // Toplam sonucu ekrana yazdirilir
        System.out.println("1'den 10'a kadar olan sayilarin toplami: " + toplam);
        
        // Kullanici girisi ile belirli bir sayi kadar toplama islemi yapma
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Toplamak istediginiz sayiyi girin: ");
        int n = scanner.nextInt(); // Kullanici girisi alinir

        int kullaniciToplam = 0; // Kullanici toplami baslangicta 0 olarak atanir
        for (int i = 1; i <= n; i++) {
            kullaniciToplam += i; // Her bir sayi kullanici toplamina eklenir
        }

        // Kullanici toplami ekrana yazdirilir
        System.out.println("1'den " + n + "'a kadar olan sayilarin toplami: " + kullaniciToplam);
        
        scanner.close(); // Scanner kapatilir
    }
}
