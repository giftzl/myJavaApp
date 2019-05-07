package algorithum;

/**
 * @author vivianzhu
 *
 *
 */
public class StringToInteger {
	
	public static int atoi(String str) throws Exception {
		
		int value = 0;
		boolean negtive = false;
		
		// 判断为空
		if(str == null || str.equals(""))
			throw new Exception("Input str cannot be empty");
		
		if(str.charAt(0) == '-')
			negtive = true;
		
		int base = 1;
		int len = str.length();
		
		// 判断非法字符
		for(int i = len-1; i>0; i--) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				value += (str.charAt(i)-'0') * base;
				base *= 10;
			}else {
				throw new Exception("input string should only contain numbers 0-9");
			}
		}
		// 判断越界
		if(value > Integer.MAX_VALUE)
			throw new Exception("input String exceed max value of Integer");
		
		//判断符号
		if(!negtive)
			value+= (str.charAt(0)-'0')*base;
		
		return negtive? value*-1: value;
	}
	
	public static float atof(String str) throws Exception {
		String[] nums = str.split("\\.");
		if(nums.length > 1) {
			String zs = nums[0];
			String xs = nums[1];
			float zsf = (float) (atof(zs) * 1.0);
			float xsf = (float) (atof(xs) / Math.pow(10,xs.length()));
			if(zsf > 0)
				return zsf+xsf;
			else 
				return (Math.abs(zsf) + xsf)* (-1);
			
		}else {
			return  (float) (atoi(str) *1.0);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		String[] strings = {"-42","36"};
		String[] floatStrs = {"2.34", "4.568","-3.1415927"};
		
		for (String str : strings) {
				System.out.println(atoi(str));
		}
		for (String str : floatStrs) {
			System.out.println(atof(str));
			
		}
		
	}

}
