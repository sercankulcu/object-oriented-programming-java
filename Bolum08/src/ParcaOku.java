import java.io.*;

// FileInputStream.read(dizi): diziye en fazla dizi.length bayt okur, okunan sayiyi dondurur.
public class ParcaOku {
	public static void main(String[] args) throws IOException {
		// Hazirlik: 12 baytlik dosya
		try (FileWriter w = new FileWriter("dosya.txt")) {
			w.write("Merhaba Java");
		}

		try (FileInputStream fis = new FileInputStream("dosya.txt")) {
			byte[] dizi = new byte[4];
			int adet;
			while ((adet = fis.read(dizi)) != -1) {
				System.out.println(adet + ": " + new String(dizi, 0, adet));
			}
		}
		// 4: Merh
		// 4: aba
		// 4: Java
		new File("dosya.txt").delete();
	}
}
