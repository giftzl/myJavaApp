package algorithum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MoreseCode {
	
	
	public static void main(String[] args) {
		
		String[] words =  {"gin", "zen", "gig", "msg"};
		
		MoreseCode coder = new MoreseCode();
		coder.uniqueMorseRepresentations(words);
	}
	
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public int uniqueMorseRepresentations(String[] words) {
          String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet();
        List<String> list = new ArrayList<String>();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
            list.add(code.toString());
        }

        return seen.size();
    }
}