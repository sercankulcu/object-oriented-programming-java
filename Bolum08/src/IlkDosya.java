import java.io.*;

// Ilk dosya programi: FileWriter ile metin, FileOutputStream ile tek bayt yazma ve geri okuma.
// "Merhaba, dunya!" metnindeki u-umlaut UTF-8'de 2 bayt tuttugu icin dosya 16 bayttir.
public class IlkDosya {
	public static void main(String[] args) throws IOException {
		// Metin dosyasina yazma
		FileWriter writer = new FileWriter("dosya.txt");
		writer.write("Merhaba, d\u00fcnya!");
		writer.close();
		// Ikili dosyaya bir byte yazma
		FileOutputStream cikis = new FileOutputStream("veri.dat");
		cikis.write(127);
		cikis.close();
		// Ikili dosyadan okuma
		FileInputStream stream = new FileInputStream("veri.dat");
		int veri = stream.read();
		stream.close();
		System.out.println("Okunan byte: " + veri);                    // Okunan byte: 127
		File metin = new File("dosya.txt");
		System.out.println("dosya.txt: " + metin.length() + " byte");   // dosya.txt: 16 byte

		// Olusturulan dosyalari sil
		metin.delete();
		new File("veri.dat").delete();
	}
}

/* Beklenen cikti:
Okunan byte: 127
dosya.txt: 16 byte
*/
