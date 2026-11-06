import java.io.*;

// File ile dosya ve klasor islemleri: var mi, olustur, ozellikler, listele, sil.
public class DosyaBilgi {
	public static void main(String[] args) throws IOException {
		File klasor = new File("ornek");
		File dosya = new File("ornek/dosya.txt");
		System.out.println("var mi: " + dosya.exists());           // var mi: false
		System.out.println("mkdir: " + klasor.mkdir());            // mkdir: true
		System.out.println("olustu: " + dosya.createNewFile());    // olustu: true
		System.out.println("dosya mi: " + dosya.isFile());         // dosya mi: true
		System.out.println("klasor mu: " + dosya.isDirectory());   // klasor mu: false
		System.out.println("okunur: " + dosya.canRead());          // okunur: true
		System.out.println("yazilir: " + dosya.canWrite());        // yazilir: true
		System.out.println("boyut: " + dosya.length());            // boyut: 0
		String[] icerik = klasor.list();
		System.out.println("klasorde: " + icerik.length + " oge"); // klasorde: 1 oge
		long zaman = dosya.lastModified();
		System.out.println("zaman > 0: " + (zaman > 0));           // zaman > 0: true
		System.out.println("silindi: " + dosya.delete());          // silindi: true
		System.out.println("var mi: " + dosya.exists());           // var mi: false
		klasor.delete();
	}
}
