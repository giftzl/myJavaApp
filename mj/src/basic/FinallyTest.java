package basic;

/**
 * 
 * if finally block contains "return" ,then program will return what defined in finally
 * 
 * @author vivianzhu
 *
 */
public class FinallyTest {
	
	public static void main(String[] args) {
		
			FinallyTest test = new FinallyTest();
			
			int result = test.testFinally();
			System.out.println(result);
		
	}
	
	@SuppressWarnings({ "finally", "unused" })
	public int testFinally() {
		
		int result = 0;
		int[] ary = null;
		
		try {
			
			// if finally block don't have return statement, 
            // then save this result = 5 value and return after.
			// any assign value in finally block (without return) will not change the value
			
			result = 5; 
//			ary[0] = 1; //triger exception
			return result;
			
		} catch (Exception e) {
			
			result = 10;
			return result;
			
		}finally {
		 //  if there's a return state in finally block, then always return what defined in finally 11
			result = 11;
//			return result; 
		}
		
	}
	

}
