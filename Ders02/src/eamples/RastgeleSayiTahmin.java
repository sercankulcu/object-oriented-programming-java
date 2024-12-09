package eamples;
import java.util.Random; // Rastgele sayilar uretmek icin Random sinifini ice aktarir.
import java.util.Scanner; // Kullanicidan giris almak icin Scanner sinifini ice aktarir.

public class RastgeleSayiTahmin { // Ana sinif

    public static void main(String[] args) { // Programin calismaya basladigi ana fonksiyon

        // Random sinifindan bir nesne olusturur, bu nesne ile rastgele sayilar uretilir.
        Random rastgele = new Random();

        // 1 ile 100 arasinda rastgele bir sayi uretir. 'nextInt(100)' ifadesi 0-99 arasinda bir sayi uretir,
        // bu yuzden sonuca 1 eklenir ve 1-100 araliginda bir sayi elde edilir.
        int sayi = rastgele.nextInt(100) + 1; 

        // Kullanicidan giris almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in);

        // Kullanicinin dogru tahmini yapana kadar donecek sonsuz bir dongu baslatilir.
        while(true) {

            // Kullanicinin girdigi sayiyi okur ve 'girilen' degiskenine atar.
            int girilen = scanner.nextInt();

            // Rastgele uretilen sayi ve kullanicinin girdigi sayiyi ekrana yazdirir.
            System.out.println("Rastgele = " + sayi + " Girilen = " + girilen);

            // Eger kullanicinin girdigi sayi, rastgele uretilen sayiya esitse, donguden cikilir.
            if(sayi == girilen) {
                // Tahmin dogru, dongu sonlanir.
                break;
            } 
            // Eger girilen sayi, rastgele sayidan kucukse, kullaniciya daha buyuk bir sayi girmesi gerektigini soyler.
            else if(girilen < sayi) {
                System.out.println("Daha buyuk bir sayi giriniz (yukari).");
            } 
            // Eger girilen sayi, rastgele sayidan buyukse, kullaniciya daha kucuk bir sayi girmesi gerektigini soyler.
            else {
                System.out.println("Daha kucuk bir sayi giriniz (asagi).");
            }
        }
        // Program burada sonlanir, scanner nesnesini kapatmayi unutmamak gerekir.
        scanner.close(); 
    }
}
