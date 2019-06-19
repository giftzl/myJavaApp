package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Entry[] table = new Entry[10];
		
		for (Entry entry : table) {
			System.out.println(entry);
		}
		
		testHashMap();

		
	}

	private static void testHashMap() {
		Map<String, Integer> map = new HashMap<>();

		map.put("语文", 1);
		map.put("数学", 2);
		map.put("英语", 3);
		map.put("历史", 4);
		map.put("政治", 5);
		map.put("地理", 6);
		map.put("生物", 7);
		map.put("化学", 8);
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		int n = 20;
		System.out.println(n >>> 16);

	}
}