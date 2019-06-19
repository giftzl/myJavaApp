package threads;

public class Singleton {
	
	private volatile static Singleton instance;
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized(Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Runnable R1 = new  Runnable() {
			public void run() {
				Singleton s1 =Singleton.getInstance();
				System.out.println(s1);
			}
		};
		
		Runnable R2 = new  Runnable() {
			public void run() {
				Singleton s1 =Singleton.getInstance();
				System.out.println(s1);
			}
		};
		
		Thread t1 = new Thread(R1);
		Thread t2 = new Thread(R2);
		
		t1.start();
		t2.start();

		
		
	}

}
