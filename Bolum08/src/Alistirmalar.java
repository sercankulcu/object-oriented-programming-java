import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

// Alistirmalar 1-3: satir/kelime/karakter sayaci, kareler dosyasi, int dizisini serilestirme.
public class Alistirmalar {

	// (1) metin.txt: "Java ile dosya / okuma ve yazma / (bos satir) / cok kolay" (c-cedilla ile)
	static void alistirma1() throws IOException {
		Files.writeString(Path.of("metin.txt"), "Java ile dosya\nokuma ve yazma\n\n\u00e7ok kolay\n");

		int satirSayisi = 0, kelimeSayisi = 0, karakterSayisi = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("metin.txt"))) {
			String satir;
			while ((satir = br.readLine()) != null) {
				satirSayisi++;
				karakterSayisi += satir.length();
				String temiz = satir.trim();
				if (!temiz.isEmpty()) kelimeSayisi += temiz.split("\\s+").length;
			}
		} catch (IOException e) {
			System.err.println("Hata: " + e.getMessage());
		}
		System.out.println(satirSayisi + " satir, " + kelimeSayisi + " kelime, "
				+ karakterSayisi + " karakter");   // 4 satir, 8 kelime, 37 karakter

		Files.delete(Path.of("metin.txt"));
	}

	// (2) n = 5 icin "i i*i" satirlari yazilir, sonra kareler toplanir
	static void alistirma2() throws IOException {
		Scanner klavye = new Scanner("5\n");   // sunumda: new Scanner(System.in)
		try (PrintWriter pw = new PrintWriter(new FileWriter("kareler.txt"))) {
			int n = klavye.nextInt();
			for (int i = 1; i <= n; i++) {
				pw.println(i + " " + i * i);
			}
		}
		int toplam = 0;
		try (Scanner dosya = new Scanner(new File("kareler.txt"))) {
			while (dosya.hasNextInt()) {
				dosya.nextInt();               // i
				toplam += dosya.nextInt();     // i * i
			}
		}
		System.out.println("Kareler toplami: " + toplam);   // Kareler toplami: 55

		Files.delete(Path.of("kareler.txt"));
	}

	// (3) int dizisi de bir nesnedir: dogrudan serilestirilebilir
	static void alistirma3() throws IOException, ClassNotFoundException {
		int[] dizi = {3, 1, 4, 1, 5};
		try (ObjectOutputStream c = new ObjectOutputStream(new FileOutputStream("dizi.ser"))) {
			c.writeObject(dizi);
		}
		try (ObjectInputStream g = new ObjectInputStream(new FileInputStream("dizi.ser"))) {
			int[] okunan = (int[]) g.readObject();
			int toplam = 0;
			for (int x : okunan) toplam += x;
			System.out.println(okunan.length + " eleman, toplam " + toplam);   // 5 eleman, toplam 14
		}

		Files.delete(Path.of("dizi.ser"));
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		alistirma1();
		alistirma2();
		alistirma3();
	}
}

/* Beklenen cikti:
4 satir, 8 kelime, 37 karakter
Kareler toplami: 55
5 eleman, toplam 14
*/
