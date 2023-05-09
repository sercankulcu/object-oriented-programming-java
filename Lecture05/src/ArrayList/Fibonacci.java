package ArrayList;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static int iterativeFibonacci(int number) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		for (int i = 2; i < number + 1; i++) {
			list.add(list.get(i - 2) + list.get(i - 1));
		}
		return list.get(number);
	}
	
	public static void main(String[] args) {
		
		int result = Fibonacci.iterativeFibonacci(10);
		System.out.println(result);
	}

}
