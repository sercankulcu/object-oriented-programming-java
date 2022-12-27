/*
 * Here is an example code that demonstrates interthread communication in Java using 
 * the wait() and notify() methods:
 * 
 * In this example, the send() method is called by the sender thread to send a message, 
 * and the receive() method is called by the receiver thread to receive the message. The 
 * wait() and notify() methods are used to synchronize the threads and allow for 
 * communication between them. The synchronized keyword is used to ensure that only 
 * one thread can access the shared message at a time.
 * */

public class InterthreadCommunicationExample {
	
    public static void main(String[] args) {
    	
        final Message message = new Message();
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    message.send("Hello from the sender thread!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread receiver = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(message.receive());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        sender.start();
        receiver.start();
    }
}

class Message {
	
    private String message;
    private boolean messageReceived = false;

    public void send(String message) throws InterruptedException {
    	
        synchronized (this) {
            while (messageReceived) {
                wait();
            }
            this.message = message;
            messageReceived = true;
            notify();
        }
    }

    public String receive() throws InterruptedException {
    	
        synchronized (this) {
            while (!messageReceived) {
                wait();
            }
            messageReceived = false;
            notify();
            return message;
        }
    }
}
