package collections;
import java.util.ArrayList;
import java.util.Collections;

public class Lottery {
	
	public static Integer[] performLottery(int numNumbers, int numbersToPick) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for(int i = 0; i < numNumbers; i++) {
      numbers.add(i+1);
    }

    Collections.shuffle(numbers);
    return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
  }
	
	public static void main(String[] args) {
		Integer[] results = Lottery.performLottery(49, 6);
		for(Integer result : results)
		{
			System.out.print(result + " ");
		}
	}

}
