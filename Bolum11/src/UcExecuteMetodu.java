// Uc execute metodu: execute (CREATE), executeUpdate (INSERT/UPDATE/DELETE -> satir sayisi),
// executeQuery (SELECT -> ResultSet). Sunumdaki gibi programlar ayni sample.db uzerinde
// sirayla calistirilir; sonda dosya silinir.
public class UcExecuteMetodu {
	public static void main(String[] args) {
		Baglan.dosyayiSil();        // temiz baslangic
		Baglan.calistir();          // Baglanti basarili!
		TabloOlustur.calistir();    // Tablo olusturuldu!
		VeriEkle.calistir();        // Veri eklendi! (1 satir)
		VeriOku.calistir();         // ID: 1, Ad: Ahmet Yilmaz, E-posta: ahmet@example.com
		VeriGuncelle.calistir();    // Veri guncellendi! (1 satir)
		VeriOku.calistir();         // ID: 1, Ad: Mehmet Akdeniz, E-posta: ahmet@example.com
		VeriSil.calistir();         // Veri silindi! (1 satir)
		VeriOku.calistir();         // (bos: satir yok)
		VeriSil.calistir();         // Veri silindi! (0 satir)
		Baglan.dosyayiSil();
	}
}
