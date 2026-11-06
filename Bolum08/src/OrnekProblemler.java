import java.io.*;
import java.nio.ByteBuffer;

// Ornek problemler 1-4: metin ve ikili boyut, ustune yazma ve ekleme,
// ByteBuffer konumlari, RandomAccessFile ile seek.
public class OrnekProblemler {

	// (1) Metin olarak "12 345" 6 bayt, iki int olarak 8 bayt
	static void problem1() throws IOException {
		try (PrintWriter pw = new PrintWriter("s.txt")) {
			pw.print(12);
			pw.print(' ');
			pw.print(345);
		}
		System.out.println(new File("s.txt").length());   // 6
		try (DataOutputStream d = new DataOutputStream(new FileOutputStream("s.dat"))) {
			d.writeInt(12);
			d.writeInt(345);
		}
		System.out.println(new File("s.dat").length());   // 8
		new File("s.txt").delete();
		new File("s.dat").delete();
	}

	// (2) Ikinci FileWriter dosyayi bastan yazar, true ile acilan sona ekler
	static void problem2() throws IOException {
		try (FileWriter w = new FileWriter("a.txt")) {
			w.write("ab");
		}
		try (FileWriter w = new FileWriter("a.txt")) {
			w.write("cd");
		}
		try (FileWriter w = new FileWriter("a.txt", true)) {
			w.write("ef");
		}
		try (BufferedReader r = new BufferedReader(new FileReader("a.txt"))) {
			System.out.println(r.readLine());   // cdef
		}
		new File("a.txt").delete();
	}

	// (3) flip, get, compact ve clear sonrasi position/limit
	static void problem3() {
		ByteBuffer b = ByteBuffer.allocate(10);
		b.put((byte) 1).put((byte) 2).put((byte) 3);
		b.flip();
		b.get();
		System.out.println(b.position() + " " + b.limit() + " " + b.remaining());   // 1 3 2
		b.compact();
		System.out.println(b.position() + " " + b.limit());                         // 2 10
		b.clear();
		System.out.println(b.position() + " " + b.limit() + " " + b.get(0));        // 0 10 2
	}

	// (4) 4 int yaz (10, 20, 30, 40), 4. bayttan ve sondan 4 bayt once oku
	static void problem4() throws IOException {
		try (RandomAccessFile f = new RandomAccessFile("r.dat", "rw")) {
			for (int i = 1; i <= 4; i++) f.writeInt(i * 10);
			f.seek(4);
			int a = f.readInt();
			f.seek(f.length() - 4);
			int b = f.readInt();
			System.out.println(a + " " + b + " " + f.getFilePointer());   // 20 40 16
		}
		new File("r.dat").delete();
	}

	public static void main(String[] args) throws IOException {
		problem1();
		problem2();
		problem3();
		problem4();
	}
}
