package algorithum;

import java.util.HashMap;

/**
 *		Given a string, find the length of the longest substring without repeating characters.

		Example 1:
		
		Input: "abcabcbb"
		Output: 3 
		Explanation: The answer is "abc", with the length of 3. 
		Example 2:
		
		Input: "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:
		
		Input: "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3. 
		             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstrWithoutRepeat {

	/**
	 * 
	 * 1. keep a hashmap which stores the characters in string as keys and their positions as values, 
	 * 2. keep two pointers which define the max substring.
	 * 	  move the right pointer to scan through the string, meanwhile update the hashmap.
	 *    If the character is already in the hashmap,
	 *    then move the left pointer to the right of the same character last found.
	 *    
	 * Note that the two pointers can only move forward.
	 */
	public int lengthOfLongestSubstring(String s) {
		
		if (s.length() == 0)
			return 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			
			if (map.containsKey(s.charAt(i))) {
				// j is assign value as last repeated -> max method
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		
		LongestSubstrWithoutRepeat solution = new  LongestSubstrWithoutRepeat();
		
		String[] strs = {"abba","abcabcbb", "bbbbbbb", "pwwkew"};
		
		for (String str : strs) {
			System.out.println("Longest non-repeat substr length of '"
								+ str + "' is: "+solution.lengthOfLongestSubstring(str));
		}
	}
}
