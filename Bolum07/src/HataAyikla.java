// Hata ayiklayici ile izleme: enb = 0 ile baslamak negatif dizide yanlis sonuc verir.
// Kesme noktasini enb = dizi[i] satirina koyup degiskenleri izleyin.
public class HataAyikla {
	public static int enBuyuk(int[] dizi) {
		int enb = 0;
		for (int i = 0; i < dizi.length; i++) {
			if (dizi[i] > enb) {
				enb = dizi[i];
			}
		}
		return enb;
	}

	public static void main(String[] args) {
		int[] sicaklik = {-5, -2, -8};
		int sonuc = enBuyuk(sicaklik);
		System.out.println("En yuksek: " + sonuc);   // En yuksek: 0
	}
}

/* Beklenen cikti:
En yuksek: 0
*/
