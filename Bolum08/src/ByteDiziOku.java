import java.io.*;

// ByteArrayInputStream bellekteki bayt dizisinden okur, ByteArrayOutputStream bellege yazar.
public class ByteDiziOku {
	public static void main(String[] args) throws IOException {
		byte[] dizi = {74, 97, 118, 97};           // "Java"
		ByteArrayInputStream bais = new ByteArrayInputStream(dizi);
		int b;
		while ((b = bais.read()) != -1) {
			System.out.print(b + "=" + (char) b + " ");
		}
		System.out.println();                      // 74=J 97=a 118=v 97=a
		// Bellege yazma: ByteArrayOutputStream
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(dizi);
		baos.write('!');
		byte[] sonuc = baos.toByteArray();
		System.out.println(sonuc.length + " byte: " + baos);   // 5 byte: Java!
	}
}
