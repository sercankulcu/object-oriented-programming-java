import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

// CompletableFuture zinciri (supplyAsync, thenApply, thenCombine) ve
// paralel akista ConcurrentHashMap.merge ile guvenli sayma.
public class CompletableFutureOrnegi {
	public static void main(String[] args) throws Exception {
		CompletableFuture<Integer> cf = CompletableFuture
				.supplyAsync(() -> 6)
				.thenApply(x -> x * 7)              // 42
				.thenCombine(CompletableFuture
						.supplyAsync(() -> 8), Integer::sum);
		System.out.println(cf.get());           // 50

		Map<String, Integer> say =
				new ConcurrentHashMap<>();
		String[] k = {"elma", "armut", "elma"};
		Arrays.stream(k).parallel()
				.forEach(w -> say.merge(w, 1, Integer::sum));
		System.out.println(say);  // {elma=2, armut=1}
	}
}

/* Beklenen cikti:
50
{elma=2, armut=1}
*/
