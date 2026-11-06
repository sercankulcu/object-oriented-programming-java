import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// Kuyruklar: Queue (FIFO), PriorityQueue (dogal sira, Comparable,
// ters sira) ve ArrayDeque (iki uclu kuyruk / yigin).
public class KuyrukOrnekleri {

	// Onceligi Belirlemek
	static class Gorev implements Comparable<Gorev> {
		String ad;
		int oncelik;          // kucuk = acil

		Gorev(String ad, int oncelik) {
			this.ad = ad;
			this.oncelik = oncelik;
		}

		@Override
		public int compareTo(Gorev diger) {
			return Integer.compare(oncelik, diger.oncelik);
		}

		@Override
		public String toString() {
			return ad + "(" + oncelik + ")";
		}
	}

	// Queue: Izleme
	static void queueIzleme() {
		Queue<String> kuyruk = new LinkedList<>();
		kuyruk.offer("Ali");
		kuyruk.offer("Banu");
		kuyruk.offer("Cem");
		System.out.println(kuyruk);          // [Ali, Banu, Cem]
		System.out.println(kuyruk.peek());   // Ali
		System.out.println(kuyruk.poll());   // Ali
		System.out.println(kuyruk.poll());   // Banu
		System.out.println(kuyruk.size());   // 1
		System.out.println(kuyruk.poll());   // Cem
		System.out.println(kuyruk.poll());   // null
	}

	// PriorityQueue Ornegi ve PriorityQueue: Kod Izleme (ayni kod)
	static void priorityQueueOrnegi() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(30);
		pq.add(10);
		pq.add(40);
		pq.add(20);
		System.out.println(pq.peek());   // 10 (en kucuk)
		System.out.println(pq);          // [10, 20, 40, 30] (ic duzen: yigin)
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		System.out.println();            // 10 20 30 40
	}

	// Onceligi Belirlemek
	static void onceligiBelirlemek() {
		PriorityQueue<Gorev> gorevler =
				new PriorityQueue<>();
		gorevler.add(new Gorev("Rapor", 3));
		gorevler.add(new Gorev("Ariza", 1));
		gorevler.add(new Gorev("Toplanti", 2));
		while (!gorevler.isEmpty()) {
			System.out.println(gorevler.poll());   // Ariza(1)  Toplanti(2)  Rapor(3)
		}

		PriorityQueue<Integer> buyukOnce =
				new PriorityQueue<>(
				Collections.reverseOrder());
		buyukOnce.add(30);
		buyukOnce.add(10);
		buyukOnce.add(40);
		System.out.println(buyukOnce.poll());   // 40
	}

	// ArrayDeque Sinifi
	static void arrayDequeSinifi() {
		Deque<String> yigin = new ArrayDeque<>();
		yigin.push("A");     // basa ekler
		yigin.push("B");
		System.out.println(yigin.pop());   // B
	}

	// ArrayDeque: Izleme
	static void arrayDequeIzleme() {
		ArrayDeque<Integer> sayilar = new ArrayDeque<>();
		sayilar.addFirst(5);
		sayilar.addLast(10);
		sayilar.addFirst(1);
		System.out.println(sayilar);                // [1, 5, 10]
		int ilkSayi = sayilar.pollFirst();
		int sonSayi = sayilar.pollLast();
		System.out.println(ilkSayi + " " + sonSayi); // 1 10
		System.out.println(sayilar.peekFirst());     // 5
	}

	public static void main(String[] args) {
		queueIzleme();
		priorityQueueOrnegi();
		onceligiBelirlemek();
		arrayDequeSinifi();
		arrayDequeIzleme();
	}
}
