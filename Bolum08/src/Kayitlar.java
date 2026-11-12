import java.io.*;

// RandomAccessFile ile sabit uzunluklu kayitlar: her not 4 baytlik bir int, i. kayit (i - 1) * 4'te.
public class Kayitlar {
	public static void main(String[] args) throws IOException {
		RandomAccessFile f = new RandomAccessFile("n.dat", "rw");
		int[] notlar = {70, 85, 90, 45, 60};
		for (int n : notlar)
			f.writeInt(n);              // her kayit 4 byte
		System.out.println("Uzunluk: " + f.length());          // Uzunluk: 20
		f.seek(2 * 4);                  // 3. kayda git
		System.out.println("3. not: " + f.readInt());          // 3. not: 90
		System.out.println("Konum: " + f.getFilePointer());    // Konum: 12
		f.seek(3 * 4);                  // 4. kayit
		f.writeInt(50);                 // 45 yerine 50
		f.seek(0);
		int toplam = 0;
		while (f.getFilePointer() < f.length())
			toplam += f.readInt();
		System.out.println("Toplam: " + toplam);               // Toplam: 355
		f.close();

		new File("n.dat").delete();
	}
}

/* Beklenen cikti:
Uzunluk: 20
3. not: 90
Konum: 12
Toplam: 355
*/
