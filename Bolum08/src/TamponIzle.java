import java.nio.ByteBuffer;

// Tampon islemleri izleme: put, flip, get, compact, rewind, clear sonrasi pos/lim degerleri.
public class TamponIzle {
	public static void main(String[] args) {
		ByteBuffer b = ByteBuffer.allocate(8);
		b.put((byte) 'J');
		b.put((byte) 'A');
		b.put((byte) 'V');
		b.put((byte) 'A');
		b.flip();
		char c1 = (char) b.get();
		char c2 = (char) b.get();
		b.compact();
		b.put((byte) '!');
		b.flip();
		b.get();
		b.rewind();
		b.clear();
		System.out.println(c1 + "" + c2 + " " + b);   // JA java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]
	}
}
