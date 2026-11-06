// Bytecode: bu iki metodun derlenmis hali "javap -c BytecodeOrnegi" ile
// gorulur (args parametresi, yerel degisken numaralari main ile ayni olsun diye).
// JVM bir yigin makinesidir.
public class BytecodeOrnegi {

	// Bytecode Ornegi (yerel 0 args, yerel 1 x; sunumda main'in kodu):
	// 0: iconst_5
	// 1: istore_1
	// 2: getstatic     #7    // System.out
	// 5: iload_1
	// 6: invokevirtual #13   // println(int)
	// 9: return
	static void ornek(String[] args) {
		int x = 5;
		System.out.println(x);  // 5
	}

	// Bytecode Yigini: Kod Izleme
	// iconst_5        // 5'i yigina koy
	// istore_1        // a = 5
	// bipush 7        // 7'yi yigina koy
	// istore_2        // b = 7
	// iload_1         // a'yi yukle
	// iload_2         // b'yi yukle
	// iadd            // topla
	// istore_3        // toplam = 12
	// getstatic       // System.out
	// iload_3         // toplam'i yukle
	// invokevirtual   // println(int)
	// return
	static void yigin(String[] args) {
		int a = 5;
		int b = 7;
		int toplam = a + b;
		System.out.println(toplam);  // 12
	}

	public static void main(String[] args) {
		ornek(args);
		yigin(args);
	}
}
