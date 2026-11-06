import java.io.*;

// Satir satir kopyalama: BufferedReader.readLine ile oku, PrintWriter.println ile yaz.
public class SatirKopya {
	public static void main(String[] args) throws IOException {
		// Hazirlik: kaynak dosya
		try (FileWriter w = new FileWriter("dosya.txt")) {
			w.write("Birinci satir\nIkinci satir\nUcuncu satir\n");
		}

		File dosya = new File("dosya.txt");
		File dosya2 = new File("dosya2.txt");
		FileReader fr = new FileReader(dosya);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(dosya2);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		String satir;
		// dosya sonuna kadar bir satir oku
		while ((satir = br.readLine()) != null)
			pw.println(satir);    // satiri yaz
		pw.close();
		br.close();
		System.out.println("Kopyalandi: " + dosya2.getName());   // Kopyalandi: dosya2.txt

		dosya.delete();
		dosya2.delete();
	}
}
