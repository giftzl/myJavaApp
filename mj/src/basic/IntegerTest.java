package basic;

public class IntegerTest {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Integer a=new Integer(100);
		a=new Integer("123");//将数字字符串转化为数字，注意只能是数字字符串 两种构造方法
		System.out.println(a+5);//128 这样可以证明是转化过来了，如果a是字符串的话，会做拼接
		
		a=Integer.MAX_VALUE;//在c语言中赋初值一般是0，-1，Java中可以用Min,Max_VALUE即2^31-1
		System.out.println(a);//2147483647
		
		//进制转换
		int t=Integer.parseInt("15");//这个方法跟上面的差不多
		System.out.println(t+1);//16
		
		//其他进制转换为十进制
		t=Integer.parseInt("10",16 );//第二个参数是指定几进制
		System.out.println(t);//16
		
		//十进制转其他进制
		String s=Integer.toBinaryString(10);//以二进制（基数 2）无符号整数形式返回一个整数参数的字符串表示形式
		System.out.println(s);//1010
		
		s=Integer.toHexString(17);
		System.out.println(s);//11
		
		s=Integer.toOctalString(9);
		System.out.println(s);//11
		
		s=Integer.toString(15);
		System.out.println(s+1);//将整形15转换为字符15 151		
	}


}
