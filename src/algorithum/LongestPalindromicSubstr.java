package algorithum;

/**
 * 
 * Given a string s, find the longest palindromic substring in s. 
   You may assume that the maximum length of s is 1000.

	Example 1:
	
	Input: "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.
	
	Example 2:
	
	Input: "cbbd"
	Output: "bb"
	
 */
public class LongestPalindromicSubstr {
	
	private int lo, maxLen;
	 
	/**
	 * 两侧比较法
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		
		if(s == null || s.length() <2)
			return s;
		 
		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = s.length();
 
		// check all possible sub strings
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int len = j - i;
				String curr = s.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (len > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = len;
					}
				}
			}
		}
 
		return longestPalindrome;
	}
 
	public static boolean isPalindrome(String s) {
 
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
 
		return true;
	}

	
	/**
	 * 中心扩展法
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome1(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
		   // assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i);
			
			// assume even length.
			extendPalindrome(s, i, i + 1);
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	
	/**
	 * 动态规划
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		if (s == null)
			return null;
	 
		if(s.length() <=1)
			return s;
	 
		int maxLen = 0;
		String longestStr = null;
	 
		int length = s.length();
	 
		int[][] table = new int[length][length];
	 
		//every single letter is palindrome
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		printTable(table);
	 
		//e.g. bcba
		//two consecutive same letters are palindrome
		for (int i = 0; i <= length - 2; i++) {
			//System.out.println("i="+i+"  "+s.charAt(i));
			//System.out.println("i="+i+"  "+s.charAt(i+1));
			if (s.charAt(i) == s.charAt(i + 1)){
				table[i][i + 1] = 1;
				longestStr = s.substring(i, i + 2);
			}	
		}
		System.out.println(longestStr);
		printTable(table);
		//condition for calculate whole table
		for (int l = 3; l <= length; l++) {
			for (int i = 0; i <= length-l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
					if (table[i][j] == 1 && l > maxLen)
						longestStr = s.substring(i, j + 1);
					
				} else {
					table[i][j] = 0;
				}
				printTable(table);
			}
		}
	 
		return longestStr;
	}

	public static void printTable(int[][] x){
		for(int [] y : x){
			for(int z: y){
				//System.out.print(z + " ");
			}
			//System.out.println();
		}
		//System.out.println("------");
	}
	
    public static void main(String[] args) {
    	
    	String[] strings = {"ac","a","babad","cbbd"};
    	for (String str : strings) {
    		System.out.println(str+ (isPalindrome(str)?" is ":" isn't ")+"palindrome. ");
    		
    		System.out.println("Longest palindromic substring in '"+str+"' is: " 
    						+ longestPalindrome(str));
		}
	}
}
