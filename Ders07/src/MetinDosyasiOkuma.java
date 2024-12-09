import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Bu ornekte, BufferedReader ve BufferedWriter siniflari kullanilarak metin dosyalari 
 * okunur ve yazilir. FileReader ve FileWriter siniflari, okuyucu ve yazicilari olusturmak 
 * icin kullanilirken, readLine() ve write() metodlari dosyalara veri yazma ve okuma icin 
 * kullanilir.
 */

public class MetinDosyasiOkuma {

	public static void main(String[] args) {

		// Dosya yollarini tanimla
		String girisDosyaYolu = "girdi.txt";
		String cikisDosyaYolu = "cikti.txt";

		// Giris dosyasindan oku
		try (BufferedReader okuyucu = new BufferedReader(new FileReader(girisDosyaYolu))) {
			String satir;
			while ((satir = okuyucu.readLine()) != null) {
				System.out.println(satir);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Cikis dosyasina yaz
		try (BufferedWriter yazici = new BufferedWriter(new FileWriter(cikisDosyaYolu))) {
			yazici.write("Bu bir metin satiridir.");
			yazici.newLine();
			yazici.write("Bu da baska bir metin satiridir.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
