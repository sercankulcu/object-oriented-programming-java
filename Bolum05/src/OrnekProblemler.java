import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Ornek problemler: yiginla parantez dengesi, Deque islemlerinin izi,
// TreeMap'te ayni anahtarin uzerine yazilmasi.
public class OrnekProblemler {

	// Ornek Problemler (3)
	static boolean dengeliMi(String ifade) {
		Deque<Character> yigin = new ArrayDeque<>();
		for (char c : ifade.toCharArray()) {
			if (c == '(' || c == '[') {
				yigin.push(c);
			} else if (c == ')' || c == ']') {
				if (yigin.isEmpty()) return false;
				char ac = yigin.pop();
				if (c == ')' && ac != '(') return false;
				if (c == ']' && ac != '[') return false;
			}
		}
		return yigin.isEmpty();
	}

	// Ornek Problemler (4)
	static void dequeVeMap() {
		Deque<Integer> d = new ArrayDeque<>();
		d.offerLast(1);
		d.offerFirst(2);
		d.offerLast(3);
		d.push(4);
		System.out.println(d);                         // [4, 2, 1, 3]
		System.out.println(d.pollLast() + d.pop());    // 7
		System.out.println(d);                         // [2, 1]

		Map<String, Integer> m = new TreeMap<>();
		m.put("b", 1);
		m.put("a", 2);
		m.put("b", 3);
		Set<Integer> s = new TreeSet<>(m.values());
		s.add(2);
		System.out.println(m + " " + s + " " + m.size());  // {a=2, b=3} [2, 3] 2
	}

	public static void main(String[] args) {
		System.out.println(dengeliMi("a[(b)+c]"));   // true
		System.out.println(dengeliMi("([)]"));       // false
		System.out.println(dengeliMi("(()"));        // false
		dequeVeMap();
	}
}

/* Beklenen cikti:
true
false
false
[4, 2, 1, 3]
7
[2, 1]
{a=2, b=3} [2, 3] 2
*/
