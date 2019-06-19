package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MyThreadPoolTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		
		
		Callable<String> c1 = new Task();
		Callable<String> c2 = new Task();
		Callable<String> c3 = new Task();
		Callable<String> c4 = new Task();
		
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Future<String> f1 = pool.submit(c1);
		Future<String> f2 = pool.submit(c2);
		Future<String>  f3 = pool.submit(c3);
		Future<String>  f4 = pool.submit(c4);
		
		Thread.sleep(5000);
		
		try {
			System.out.println(f1.get().toString());
			System.out.println(f2.get().toString());
			System.out.println(f3.get().toString());
			System.out.println(f4.get().toString());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		pool.shutdown();
	}

}


@SuppressWarnings("rawtypes")
class Task implements Callable{


	@Override
	public Object call() throws Exception {
		
		String info = Thread.currentThread().getId()+":" +Thread.currentThread().getName();
		
		return info;
	}
	
}