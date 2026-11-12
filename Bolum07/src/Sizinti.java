import java.util.ArrayList;
import java.util.List;

// Bellek sizintisi: onbellege eklenen diziler hic silinmez, yigin sonunda dolar.
// Sunumda dongu sonsuzdur ve OutOfMemoryError ile biter; burada 120 istekte durur.
public class Sizinti {
	static List<byte[]> onbellek = new ArrayList<>();

	static void istekIsle(int no) {
		byte[] veri = new byte[1024 * 1024];  // 1 MB
		onbellek.add(veri);                   // hic silinmiyor!
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 120; i++) {     // sunumda: for (int i = 1; ; i++)
			istekIsle(i);
			if (i % 20 == 0) {
				System.out.println(i + " istek islendi");   // 20 istek islendi ... 120 istek islendi
			}
		}
		System.out.println("Onbellekte " + onbellek.size() + " MB tutuluyor");   // Onbellekte 120 MB tutuluyor
		// Dongu surseydi: Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		// Yigin dokumu icin: java -XX:+HeapDumpOnOutOfMemoryError Sizinti
		//                   ya da jps, sonra jcmd <pid> GC.heap_dump yigin.hprof
		onbellek.clear();
	}
}

/* Beklenen cikti:
20 istek islendi
40 istek islendi
60 istek islendi
80 istek islendi
100 istek islendi
120 istek islendi
Onbellekte 120 MB tutuluyor
*/
