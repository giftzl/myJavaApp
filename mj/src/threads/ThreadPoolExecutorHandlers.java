package threads;

import java.util.concurrent.*;

public class ThreadPoolExecutorHandlers {

	public static void main(String[] args) {

		testPolicy();
	}

	private static void testPolicy() {

		int corePoolSize = 5;
		int maxPoolSize = 10;
		long keepAliveTime = 5;
		BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(10);

//		RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
		RejectedExecutionHandler handler  = new ThreadPoolExecutor.CallerRunsPolicy();
//		RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
//		RejectedExecutionHandler handler =  new ThreadPoolExecutor.DiscardPolicy();

		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue, handler );

		for(int i = 0; i < 100; i++){
			executor.execute(new Worker());
		}
		executor.shutdown();
	}



}

class Worker implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}
}