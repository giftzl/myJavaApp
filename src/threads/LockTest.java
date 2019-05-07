package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class LockTest {
	
	public static void main(String[] args) {
		final Queue<Integer> sharedQ = new LinkedList<Integer>();
		  
	      Thread producerThread = new Thread(new Producer(sharedQ, 4), "PRODUCER");
	      Thread consumerThread = new Thread(new Consumer(sharedQ, 4), "CONSUMER");
	     
	      producerThread.start();
	      consumerThread.start();
		
	}

}
@SuppressWarnings("rawtypes")
class Consumer implements Runnable
{
  
	private final Queue sharedQ;
     
    public Consumer(Queue sharedQ, int maxSize)
    {
        this.sharedQ = sharedQ;
    }
     
    @Override
    public void run(){
        while(true)
        {
            synchronized (sharedQ) {
                while(sharedQ.isEmpty())
                {
                    try {
                        System.out.println("Que is Empty");
                        sharedQ.wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace(); 
                    }
                }
                 
                int number = (int) sharedQ.poll();
                System.out.println("removing Element " + number);
                sharedQ.notify();
                 
            }
        }
    }
     
}

class Producer implements Runnable
{
   
	private final Queue<Integer> sharedQ;
    private int maxSize;
     
	public Producer(Queue<Integer> sharedQ, int maxSize)
    {
        this.sharedQ = sharedQ;
        this.maxSize = maxSize;
    }
     
	@Override
    public void run(){
         
        while(true)
        {
            synchronized (sharedQ) {
                while(sharedQ.size()==maxSize)
                {
                    try
                    {
                        System.out.println("Queue is full");
                        sharedQ.wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                     
                }
                Random random = new Random(); 
                int number = random.nextInt(100);
                System.out.println("Producing value " + number);
                sharedQ.offer(number);
                sharedQ.notify();
                 
            }
             
        }
    }
}
