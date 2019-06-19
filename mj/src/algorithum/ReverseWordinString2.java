package algorithum;

/**
 * 
 * Given an input string, reverse the string word by word. A word is defined as
 * a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words
 * are always separated by a single space. For example,
 * 
 * Given s = "the sky is blue",
 * 
 * return "blue is sky the".
 * 
 * @author vivianzhu
 *
 */
public class ReverseWordinString2 {
	
	public static void main(String[] args) {
		
		String s =  "the sky is blue" ;
		System.out.println(reverseWords(s));
		
	}

	public static String reverseWords(String s) {
		
		StringBuffer sb = new StringBuffer();
		
		String[] words = s.split("\\s+");
		
		for (int j = words.length-1; j>=0; j--) {
			sb.append(words[j]).append(" ");
		}
		return sb.toString().trim();
	}
	
}
