import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// 127 sayisi metin olarak (karakter basina 1 ya da 2 bayt) ve ikili olarak (1, 2, 4 bayt)
// yazildiginda dosya boyutlari.
public class Sayi127 {
	static void metinYaz(String ad, Charset kod) throws IOException {
		Writer w = new OutputStreamWriter(new FileOutputStream(ad), kod);
		w.write(String.valueOf(127));            // "127": 3 karakter
		w.close();
	}
	static void ikiliYaz(String ad, int boyut) throws IOException {
		FileOutputStream fos = new FileOutputStream(ad);
		DataOutputStream d = new DataOutputStream(fos);
		if (boyut == 1) d.writeByte(127);        // 01111111
		else if (boyut == 2) d.writeShort(127);  // 00000000 01111111
		else d.writeInt(127);                    // 4 byte
		d.close();
	}
	public static void main(String[] args) throws IOException {
		metinYaz("metin.txt", StandardCharsets.US_ASCII);
		metinYaz("metin16.txt", StandardCharsets.UTF_16BE);
		ikiliYaz("b.dat", 1);  ikiliYaz("s.dat", 2);  ikiliYaz("i.dat", 4);
		String[] adlar = {"metin.txt", "metin16.txt",
						 "b.dat", "s.dat", "i.dat"};
		for (String ad : adlar)
			System.out.println(ad + ": " + new File(ad).length());
		// metin.txt: 3
		// metin16.txt: 6
		// b.dat: 1
		// s.dat: 2
		// i.dat: 4

		// Olusturulan dosyalari sil
		for (String ad : adlar)
			new File(ad).delete();
	}
}

/* Beklenen cikti:
metin.txt: 3
metin16.txt: 6
b.dat: 1
s.dat: 2
i.dat: 4
*/
