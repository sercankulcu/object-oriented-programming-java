// Yigin izini okumak: en ustteki satir istisnanin olustugu yer, alttakiler
// cagri zinciri. Program 0 ile bitsin diye main istisnayi yakalayip izi yazar.
public class IzlemeOrnegi {
	static int uzunluk(String metin) {
		return metin.length();
	}
	static void yazdir(String ad) {
		System.out.println(ad + ": " + uzunluk(ad));
	}
	public static void main(String[] args) {
		try {
			yazdir("Ali");     // Ali: 3
			yazdir(null);
			System.out.println("Bitti");
		} catch (NullPointerException e) {
			// java.lang.NullPointerException: Cannot invoke "String.length()" because "metin" is null
			//     at IzlemeOrnegi.uzunluk, at IzlemeOrnegi.yazdir, at IzlemeOrnegi.main
			e.printStackTrace(System.out);
		}
	}
}
