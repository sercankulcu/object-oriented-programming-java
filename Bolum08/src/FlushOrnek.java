import java.io.*;

// Tamponlu yazma: veri flush ya da close cagrilana kadar diske gitmez.
// "Kayit 1" metnindeki noktasiz i UTF-8'de 2 bayt tuttugu icin flush sonrasi boyut 8'dir.
public class FlushOrnek {

	// Tampon ve flush: kod izleme slayti
	static void kodIzleme() throws IOException {
		File f = new File("log.txt");
		PrintWriter pw = new PrintWriter(new FileWriter(f));
		System.out.println("0: " + f.length());   // 0: 0
		pw.print("kayit1;");
		System.out.println("1: " + f.length());   // 1: 0
		pw.print("kayit2;");
		System.out.println("2: " + f.length());   // 2: 0
		pw.flush();
		System.out.println("3: " + f.length());   // 3: 14
		pw.print("kayit3;");
		pw.close();
		System.out.println("4: " + f.length());   // 4: 21
		pw.print("kayit4;");   // kapali: sessizce yok sayilir
		System.out.println("hata? " + pw.checkError());   // hata? true
		f.delete();
	}

	public static void main(String[] args) throws IOException {
		File log = new File("log.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(log));
		bw.write("Kay\u0131t 1");
		System.out.println("once: " + log.length());    // once: 0
		bw.flush();
		System.out.println("sonra: " + log.length());   // sonra: 8
		bw.close();
		log.delete();

		kodIzleme();
	}
}

/* Beklenen cikti:
once: 0
sonra: 8
0: 0
1: 0
2: 0
3: 14
4: 21
hata? true
*/
