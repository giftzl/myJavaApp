package algorithum;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a string, find the first non-repeating character in it and return it's index. 
 *  If it doesn't exist, return -1.

	Examples:
	
	s = "leetcode"
	return 0.
	
	s = "loveleetcode",
	return 2.
	Note: You may assume the string contain only lowercase letters.


 */
public class FirstUniqCharacterInString {
	
	
	public static int firstUniqChar(String s) {
		
		List<Character> charList = new ArrayList<>();
		int[] smap = new int[26];
		for (Character c : s.toCharArray()) {
			charList.add(c);
			smap[c-'a']++;
		}
		for (char ch : charList) {
			if(smap[ch-'a']==1) {
				return s.indexOf(ch);
			}
				
		}
		return -1;

	}
	
	public static void main(String[] args) {
		String[] strings = {"leetcode", "loveleetcode","aabb"};
		for (String str : strings) {
			System.out.println("First uniqe char at index: "+firstUniqChar(str));
			
		}
	}
}
