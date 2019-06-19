package algorithum;

import java.util.Arrays;
import java.util.List;

public class DictionaryTest {
	
	public static void main(String[] args) {
		
		String str = "catsandog";
		String[] words = {"cats", "dog", "sand", "and", "cat"};
		List<String> strList = Arrays.asList(words);
		
		strList.add("a");
		
		DictionaryTest dict = new DictionaryTest();
		
		boolean can = dict.wordBreak(str, strList);
		
	}

	private boolean wordBreak(String str, List<String> strList) {
		return false;
	}
	
	

}
