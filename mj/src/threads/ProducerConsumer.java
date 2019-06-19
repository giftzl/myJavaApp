package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	
	public static void main(String[] args) {
		
		int[] n = new int[5] ;
		
		for (int i : n) {
			System.out.println(i);
		}
		
		BlockingQueue<Object> blkQue = new ArrayBlockingQueue<Object>(3);
		
		for(int i=0; i<3; i++) {
			new Thread() {
				
				@Override
				public void run() {
					
					while(true) {
						try {
							Thread.sleep((long)Math.random()*1000);
//							System.out.println(Thread.currentThread().getName()+" is ready to put in object");
							
							blkQue.put(1);
							System.out.println(Thread.currentThread().getName()+
									" has put obj into queue. Current queue size is "+ blkQue.size());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}					
					
					
				}
			}.start();
		
		}
		
		for(int j = 0 ; j<4 ;j++) {
			
			new Thread() {
				
				@Override
				public void run() {
					
					while(true) {
						try {
							Thread.sleep(1000);
//							System.out.println(Thread.currentThread().getName()+" is ready to take obj");
							
							blkQue.take();
							System.out.println(Thread.currentThread().getName()+" take obj out. Currently queue size is "+blkQue.size());
							
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					
				}
				
			}.start();
		
		}
		
	}

}
