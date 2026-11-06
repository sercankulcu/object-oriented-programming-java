import java.nio.ByteBuffer;

// ByteBuffer: put ile yazilir, flip ile okuma moduna gecilir, get ile okunur.
public class TamponOrnek {
	public static void main(String[] args) {
		// 1 KB boyutunda bir ByteBuffer olustur
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// Veri yazma
		buffer.put("Merhaba, Java!".getBytes());
		System.out.println("put sonrasi  : " + buffer);   // put sonrasi  : java.nio.HeapByteBuffer[pos=14 lim=1024 cap=1024]
		// Buffer'i okuma moduna gecirme
		buffer.flip();
		System.out.println("flip sonrasi : " + buffer);   // flip sonrasi : java.nio.HeapByteBuffer[pos=0 lim=14 cap=1024]
		// Veriyi okuma
		while (buffer.hasRemaining()) {
			System.out.print((char) buffer.get());
		}
		System.out.println();                             // Merhaba, Java!
	}
}
