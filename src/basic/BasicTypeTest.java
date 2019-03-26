package basic;

import java.util.ArrayList;
import java.util.List;

public class BasicTypeTest {
	
//	定义数组时，如果是基本数据类型int、byte、boolean、long、float、double
//	其每个元素的默认值是0,char数据类型的默认值时空格，而如果是对象数据类型那么默认值是null
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
    	//a数组中的默认值是100个0，因为byte是基本数据类型 (8 个字符， 2^7-1)
		byte[] a=new byte[100];
		//a数组中的默认值是100个null，因为Byte是对象数据类型
		Byte[] b=new Byte[100];
		
		
		byte bt = 1;
		short st =2;
		int it =3;
		long lg = 4;
		float ft = 5;
		double db = 6;
		
		System.out.println(bt);
		
		List<String> strList = new ArrayList<String>();
		
		strList.add("aa");
		strList.add("bb");
		strList.add("cc");
		
		String[] strAry = strList.toArray(new String[strList.size()]);
		for (String s : strAry) {
			System.out.println(s);
		}
		
		
		
	
	
	}

}
