package algorithum;

public class PangramTest {
	

	public static void main(String[] args) {
		
		String[] list = {"we promptly judged antique ivory buckles for the next prize",
				"we promptly judged antique ivory buckles for the prizes",
				"the quick brown fox jumps over the lazy dog",
				"the quick brown fox jump over the lazy dog"};
		

		String rs = isPangram(list);
		System.out.println(rs);
		
	}
	
    // Complete the isPangram function below.
    static String isPangram(String[] strings) {
        
        StringBuffer sb = new StringBuffer();
        
        for(String str: strings){
           sb.append(Integer.toString(check(str)));
        }
        return sb.toString();

    }

  public static int check(String arr) {
        if (arr.length() < 26) {
           return 0;
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if ((arr.indexOf(c) < 0) && (arr.indexOf((char)(c + 32)) < 0)) {
               return 0;
            }
        }
        return 1;
    }  
}
