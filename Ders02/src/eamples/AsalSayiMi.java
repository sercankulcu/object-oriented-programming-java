package eamples;
import java.util.Scanner; // Kullanicidan veri girisi almak icin Scanner sinifini ice aktarir.

public class AsalSayiMi { // Ana sinif

    public static void main(String[] args) {

        // Kullanicidan bir sayi almak icin Scanner nesnesi olusturur.
        Scanner scanner = new Scanner(System.in);

        // Kullanicidan bir sayi girmesini ister. Bu sayi, asal olup olmadigini kontrol edilir.
        System.out.println("Bir sayi giriniz:");
        int sayi = scanner.nextInt(); // Kullanicinin girdigi sayiyi okur ve 'sayi' degiskenine atar.

        // Asal olup olmadigini kontrol etmek icin 'asal' adinda bir boolean degiskeni tanimlanir.
        // Baslangicta sayinin asal oldugu varsayilir.
        boolean asal = true;

        // 'for' dongusu, sayinin asal olup olmadigini kontrol etmek icin kullanilir.
        // Dongu 2'den baslayarak (cunku asal sayi 1 ve kendisi disinda tam boleni olmayan sayidir)
        // girilen sayiya kadar devam eder.
        for(int i = 2; i < sayi; i++) {

            // Eger sayi, 2 ile 'sayi' arasindaki herhangi bir sayiya tam bolunurse, asal degildir.
            // Tam bolunebilme kontrolu icin sayi % i == 0 ifadesi kullanilir.
            if(sayi % i == 0) {

                // Eger sayinin bir boleni bulunursa, ekrana "sayi asal degil" yazdirilir.
                System.out.println("Sayi asal degil.");

                // Sayinin asal olmadigini belirtmek icin 'asal' degiskeni false yapilir.
                asal = false;

                // Ilk boleni bulduktan sonra kontrol etmeye gerek olmadigi icin donguden cikilir (break).
                break;
            }
        }

        // Eger dongu tamamlandiysa ve hicbir bolen bulunmadiysa (asal degiskeni hala true ise),
        // sayinin asal oldugu kabul edilir ve ekrana "sayi asal" yazdirilir.
        if(asal == true) {
            System.out.println("Sayi asal.");
        }

        // Scanner nesnesini kapatir. Kaynak yonetimi acisindan onemli bir adimdir.
        scanner.close();
    }
}
