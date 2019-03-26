package algorithum;

public class ExcelSheetCol {
	
	public static void main(String[] args) {
		
		ExcelSheetCol sol = new ExcelSheetCol();
		
		String[] arys = {"A","C","AA","AZ","ZA"};
		for (String str : arys) {
			System.out.println(sol.titleToNumber(str));
		}
	}

	
	public int titleToNumber(String s) {
	    int result = 0;
	    for(int i = 0 ; i < s.length(); i++) {
	      result = result * 26 + (s.charAt(i) - 'A' + 1);
	    }
	    return result;
	  }
}
