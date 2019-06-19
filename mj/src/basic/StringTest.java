package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTest {  
    public static void main(String args[]) {  
    	
      newStringWithCharset();
      
      stringBuffer();  
      
      String s = "Hello String";
      char[] cary = s.toCharArray();
      System.out.println(s.charAt(9));
      System.out.println(cary);
      
      byte [] aa1 = {(byte) 00010110,(byte) 01010010,  (byte) 10111000};
      byte [] aa2 = {0x16,0x52,(byte) 0xB8};
      byte [] aa3 = {22, 82, (byte) 184};
      System.out.println(Arrays.toString(aa1));
      System.out.println(Arrays.toString(aa2));
      System.out.println(Arrays.toString(aa3));
     
      
      
    }

	private static void newStringWithCharset() {
		char[] charset = {'h','e','l','l','o'};
    	String charSetStr = new String(charset);
    	
    	int len1 = charset.length;
    	int len2 = charSetStr.length();
    	
    
    	
    	List<String> list = new ArrayList<String>();
    	list.add("world");
    	list.size();
    	
    	
    	System.out.println(charSetStr);
	}

	private static void stringBuffer() {
		String str = "abc";  
        StringBuffer sb = new StringBuffer("abc");  
        Runtime runtime = Runtime.getRuntime();  
        long start = System.currentTimeMillis();  
        long startFreememory = runtime.freeMemory();  
        for (int i = 0; i < 10000; i++) {  
//            str += i;  
            //测试StringBuffer时候把注释打开  
            sb.append(i);   
        }  
        long endFreememory = runtime.freeMemory();  
        long end = System.currentTimeMillis();  
        System.out.println("操作耗时:" + (end - start) + "ms," + "内存消耗:"  
                + (startFreememory - endFreememory)/1024 + "KB");
	}  
}  