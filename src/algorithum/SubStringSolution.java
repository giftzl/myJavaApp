package algorithum;

class SubStringSolution{
    public int numJewelsInStones(String J, String S) {
        int number=0;
        
        for(int i = 0; i < S.length(); i++){
        	int j =0;;
            for(; j<J.length();j++){
            	if(J.charAt(j) != S.charAt(i)){
                    break;
                }else {
                	i++;
                }
            }
           if(j==J.length()) {
        	   number++;
        	   i--;
           }
        }
        return number;
    }
    
    public int numJinS(String J, String S) {
    	String s=S.replaceAll("[^" + J + "]", "");
    	 return S.replaceAll("[^" + J + "]", "").length();
    }
    
    public static void main(String[] args){
       
        String J = "Ruby";
        String S = "SapRubyhireRubyDiamondRubyYellow";
    	
//    	String J = "EDF";
//    	String S ="FldzM";
        
        SubStringSolution solution = new SubStringSolution();
        int number = solution.numJewelsInStones(J,S);
        int num = solution.numJinS(J, S);
        
        System.out.println("Contained Jewel number is: "+ number);
        System.out.println("Contained Jewel num is: "+ num);
        
    }
}