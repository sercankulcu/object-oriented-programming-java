import java.io.*;

// BufferedReader ile satir satir okuma ve sarmalayici (decorator) akislar:
// BufferedReader(FileReader) okuma zinciri, PrintWriter(BufferedWriter(FileWriter)) yazma zinciri.
public class SatirOku {

	// Sarmalayici akislar slayti: iki zincir kurulur, satirlar bir dosyadan digerine yazilir
	static void sarmalayicilar() throws IOException {
		BufferedReader okuyucu = new BufferedReader(new FileReader("ornekDosya.txt"));
		PrintWriter yazici = new PrintWriter(new BufferedWriter(new FileWriter("dosya2.txt")));
		String s;
		while ((s = okuyucu.readLine()) != null) {
			yazici.println(s);
		}
		okuyucu.close();
		yazici.close();
		System.out.println("dosya2.txt: " + new File("dosya2.txt").length() + " byte");   // dosya2.txt: 25 byte (Windows'ta CRLF ile 28)
	}

	public static void main(String[] args) throws IOException {
		// Hazirlik: okunacak dosyayi olustur
		try (FileWriter w = new FileWriter("ornekDosya.txt")) {
			w.write("Java\nGiris Cikis\nAkislar\n");
		}

		File dosya = new File("ornekDosya.txt");
		try (BufferedReader okuyucu =
				new BufferedReader(new FileReader(dosya))) {
			String satir;
			while ((satir = okuyucu.readLine()) != null) {
				System.out.println(satir);   // Java / Giris Cikis / Akislar
			}
		} catch (IOException e) {
			System.err.println("Okuma hatasi: " + e.getMessage());
			e.printStackTrace();
		}

		sarmalayicilar();

		dosya.delete();
		new File("dosya2.txt").delete();
	}
}

/* Not: dosya boyutu isletim sistemine gore degisir: println satir sonunu Windows'ta 2 bayt (\r\n),
   Linux ve macOS'ta 1 bayt (\n) yazar; asagidaki cikti Windows'ta alinmistir (Linux'ta 25 byte). */
/* Beklenen cikti:
Java
Giris Cikis
Akislar
dosya2.txt: 28 byte
*/
