import java.io.*;

// Tamponlama ne kadar hizlandirir? 2 MB'lik dosya bayt bayt tamponsuz ve tamponlu okunur.
// Sureler makineye gore degisir.
public class TamponOlcum {
	static long oku(InputStream in) throws IOException {
		long bas = System.nanoTime();
		while (in.read() != -1) { }          // her seferinde 1 byte
		in.close();
		return (System.nanoTime() - bas) / 1_000_000;
	}
	public static void main(String[] args) throws IOException {
		File f = new File("buyuk.dat");
		try (FileOutputStream fos = new FileOutputStream(f)) {
			fos.write(new byte[2 * 1024 * 1024]);   // 2 MB
		}
		long t1 = oku(new FileInputStream(f));
		long t2 = oku(new BufferedInputStream(new FileInputStream(f)));
		System.out.println("Tamponsuz: " + t1 + " ms");   // ornek: Tamponsuz: 3151 ms
		System.out.println("Tamponlu : " + t2 + " ms");   // ornek: Tamponlu : 94 ms
		f.delete();
	}
}
