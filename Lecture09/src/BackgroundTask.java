/*
 * here is another simple Java program that demonstrates how to use a thread to perform a task 
 * in the background:
 * 
 * his program defines a BackgroundTask class that implements the Runnable interface and has a 
 * run method. This method simply prints out a message and sleeps for 1 second, 100 times.
 * */

public class BackgroundTask implements Runnable {
	
  public void run() {
  	
    for (int i = 0; i < 10; i++) {
      System.out.println("Running task: " + i);
      try {
        Thread.sleep(500); // Sleep for 1 second
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
  	
    BackgroundTask task = new BackgroundTask();
    Thread thread = new Thread(task);
    thread.start();
    
    // Do some other work here
    for (int i = 0; i < 5; i++) {
      System.out.println("Doing other work: " + i);
      try {
        Thread.sleep(500); // Sleep for 0.5 seconds
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println("Done.");
  }
}
