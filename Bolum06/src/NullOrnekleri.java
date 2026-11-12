import java.util.Objects;
import java.util.Optional;

// NullPointerException ve null ile guvenli calismanin yollari:
// Objects.requireNonNull, Optional, requireNonNullElse, null kontrolu, "Ali".equals(str).
public class NullOrnekleri {
	public static void main(String[] args) {
		// NullPointerException
		String str = null;
		int length = 0;
		try {
			length = str.length();
		} catch (NullPointerException e) {
			System.out.println(e);   // java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
		}

		// null ile Guvenli Calismak
		try {
			Objects.requireNonNull(str, "Str null olamaz");
		} catch (NullPointerException e) {
			System.out.println(e);   // java.lang.NullPointerException: Str null olamaz
		}
		Optional<String> optionalStr = Optional.ofNullable(str);
		length = optionalStr.map(String::length).orElse(0);
		System.out.println(length);                    // 0
		String defaultValue = Objects.requireNonNullElse(str, "0");
		System.out.println(defaultValue);              // 0
		if (str != null) {
			System.out.println(str.length());
		}
		System.out.println("Ali".equals(str));         // false
	}
}

/* Beklenen cikti:
java.lang.NullPointerException: Cannot invoke "String.length()" because "<local1>" is null
java.lang.NullPointerException: Str null olamaz
0
0
false
*/
