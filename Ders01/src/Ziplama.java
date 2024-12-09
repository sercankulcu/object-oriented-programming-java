import java.util.Scanner;

/*
 * Bu program, bir topun ziplamasini simule eder ve her saniyede yuksekligini hesaplar:
 * 
 * Topun hizi, yer cekimi ivmesine ve gecen zamana orantili olarak azalir. 
 * Topun yuksekligi negatif oldugunda, program topun hizini ters cevirir 
 * ve hizini %50 azaltarak ziplamayi simule eder.
 * 
 */

public class Ziplama {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    // Kullanıcıdan ilk hizi girmesi istenir
    System.out.print("Ilk hizi giriniz: ");
    double hiz = sc.nextDouble();
    sc.close();

    // Baslangic yuksekligi 0 olarak ayarlanir
    double yukseklik = 0;

    // Baslangic zamani 0 olarak ayarlanir
    double zaman = 0;

    // Ziplamalari saymak icin sayaç
    int ziplama = 0;

    // Topun besinci ziplamasina kadar simule edilir
    while (ziplama < 5) {
      // Mevcut zaman, yukseklik ve hiz yazdirilir
      System.out.println("Zaman: " + zaman + " saniye " + " Yukseklik: " + yukseklik + " feet " + " Hiz: " + hiz);

      // Yukseklik ve hiz guncellenir
      yukseklik += hiz;
      hiz -= 32;

      // Topun yere carpip carpamadigi kontrol edilir
      if (yukseklik < 0) {
        // Hiz ters cevrilir ve %50 azaltilir
        hiz *= -0.5;

        // Yukseklik sifira resetlenir
        yukseklik = 0;

        // Ziplama sayaci bir artirilir
        ziplama++;
      }

      // Zaman bir artirilir
      zaman++;
    }
  }
}
