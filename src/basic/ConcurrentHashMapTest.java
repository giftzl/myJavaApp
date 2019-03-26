package basic;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) {
		
		ConcurrentHashMapTest test = new ConcurrentHashMapTest();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<10; i++) {
			map.put(i, i+5);
		}
		
		// remove key < 5 items in map
		for(Iterator<Entry<Integer, Integer>> mapItr = map.entrySet().iterator(); mapItr.hasNext();) {
			Entry<Integer, Integer> next = mapItr.next();
			Integer key = next.getKey();
			if(key < 5)
				mapItr.remove();
		}
		test.printMap(map);
		
		// ArrayList, HashMap don't support modification during traverse.
		test.testModifyWithoutIterator(map);
		test.printMap(map);
		
		// Use iterator to remvoe during traverse;
		test.testModifyWithIterator(map);
		test.printMap(map);
		
		// test concurrentHashMap which support multiple thread traverse while modification
		ConcurrentMap<Integer, Integer> conMap = new ConcurrentHashMap<Integer, Integer>();
		 
	    for(int i = 0; i< 20; i++) 	conMap.put(i, i+5);
	    test.printMap(conMap);
	    
//		test.testConcurrentMap(map);   // will throw ConcurrentModificationException;
	    test.testConcurrentMap(conMap);  // support multiple thread modification while traverse
	}
	
	/**
	 * use concurrentHashMap to support add/remove during traverse.
	 * HashMap don't support multiple thread operation.
	 * 
	 * 对ConcurrentHashMap边遍历边删除或者增加操作不会产生异常(可以不用迭代方式删除元素)
	 * 因为其内部已经做了维护，遍历的时候都能获得最新的值。即便是多个线程一起删除、添加元素也没问题。
	 * 
	 * @param conMap
	 */
	public void testConcurrentMap(Map<Integer, Integer> conMap) {
	    
	    // modification thread task 
	    Thread addThread= new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					conMap.put(i+1000, i+1005);
					System.out.println("ADD:("+(i+1000)+","+(i+1005)+")");
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
	    // traverse thread task
	    Thread traverseThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Iterator<Integer> iterator = conMap.keySet().iterator();
				while(iterator.hasNext()) {
					int key = iterator.next();
					System.out.println("Key:"+key+"->"+conMap.get(key));
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	    
	    Thread removeThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Iterator<Integer> iterator = conMap.keySet().iterator();
				while(iterator.hasNext()) {
					int key = iterator.next();
					if(key%2==0) {
						System.out.println("REMOVE: ("+key+","+conMap.get(key)+")");
						iterator.remove();
					}
					
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	    
	    
	    
		addThread.start();
		traverseThread.start();
		removeThread.start();
	}
	
	public void printMap(Map<Integer, Integer> map) {
		for (Integer key : map.keySet()) {
			System.out.println(key+":"+ map.get(key));
		}
		System.out.println("=================================");
	}
	
	/**
	 * 
	 * HashMap或者ArrayList边遍历边删除数据会报java.util.ConcurrentModificationException异常
	 * @param map
	 */
	public void testModifyWithoutIterator(Map<Integer,Integer> map) {
		try {
			for (Integer num : map.keySet()) {
				if(num%2 == 0)
					map.remove(num);
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("HashMap or ArrayList don't support modification during traverse!! "+e);
		}
	}
	

	/**
	 * Use iterator to remove while traverse
	 * @param map
	 */
	public void testModifyWithIterator(Map<Integer,Integer> map) {
		
	   Iterator<Integer> iterator = map.keySet().iterator();
	   while(iterator.hasNext()) {
		   Integer value = iterator.next();
		   if( value%2 == 0) {
			   iterator.remove();
		   }
	   }
	}
	
}
