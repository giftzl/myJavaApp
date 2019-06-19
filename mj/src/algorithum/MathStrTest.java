package algorithum;

import java.util.ArrayDeque;
import java.util.Deque;

public class MathStrTest {
	
	public static void main(String[] args) {
		
		String mathStr = "5+2*(3+(8-4)/2)-1";
		
		int result = calculate(mathStr);
		
		System.out.println(result);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int calculate(String mathStr) {
		
	
		Deque stack = new ArrayDeque<>();
		
		char[] charAry = mathStr.toCharArray();
		for (char c : charAry) {
			if(c == '（') {
				stack.push(c);
			}
			else if(c == ')') {
				
			}
		}
		
		return 0;
	}

}
