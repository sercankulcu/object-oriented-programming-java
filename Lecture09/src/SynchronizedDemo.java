
public class SynchronizedDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The final count is: " + counter.getCount());
    }
}

class Counter {

  private int count;

  public synchronized void increment() {
      count++;
  }

  public synchronized int getCount() {
      return count;
  }
}