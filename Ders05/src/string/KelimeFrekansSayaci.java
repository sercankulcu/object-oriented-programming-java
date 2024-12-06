package string;

/*
 * Metindeki kelimelerin frekansini sayar.
 * 
 * Her kelimenin tekrar sayisini, bir dizi kullanarak hesaplar.
 */

public class KelimeFrekansSayaci {

    public static void main(String[] args) {

        // ornek bir metin tanimla
        String metin = "Hizli kahverengi tilki tembel kopegin uzerinden atlar hizli kahverengi tilki.";

        // Metni bosluklara gore kelimelere ayir
        String[] kelimeler = metin.toLowerCase().split(" ");
        
        // Frekanslari tutmak icin kontrol edilen kelimeleri isaretleyecegiz
        boolean[] kontrolEdildi = new boolean[kelimeler.length];

        // Frekanslari hesapla
        for (int i = 0; i < kelimeler.length; i++) {
            if (kontrolEdildi[i]) {
                continue; // Daha once islenmis kelimeleri atla
            }

            int frekans = 1; // ilk basta frekans 1
            for (int j = i + 1; j < kelimeler.length; j++) {
                if (kelimeler[i].equals(kelimeler[j])) {
                    frekans++;
                    kontrolEdildi[j] = true; // Ayni kelimeyi tekrar isleme
                }
            }

            // Frekansi yazdir
            System.out.println(kelimeler[i] + ": " + frekans);
        }
    }
}
