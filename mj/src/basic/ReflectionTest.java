package basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {
	
	String[] memos;
	
	Integer[] ints;
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException { // Line 1
	
		List<Object> list = new ArrayList<Object>();
		list.add(new Reflect("a1"));
		list.add(new Reflect("b1"));
		list.add(new Stack(22));
		list.add(new Stack(33));
		
		Class cls = Class.forName("basic.Reflect");
		System.out.println(cls.getFields());
//		Constructor[] constructor = cls.getConstructors();
		
		List lit = new ArrayList<>();

		 Constructor[] cs = cls.getConstructors();
		 for (Constructor c : cs) {
			 lit.add(c.newInstance("1"));
		}
	} 


}

class Reflect{

   String name;
   int age;
   
   
  public Reflect(String name){
	  this.name = name;
	   
   }
	
   public String printInfo() {
	   
	   return this.name+ Integer.toString(this.age);
	   
	   
   }
   
}

class Stack{

	   String name;
	   int age;
		
	   public Stack(int age) {
		   this.age = age;
	   }
	   
	   public String printInfo() {
		   
		   return this.name+ Integer.toString(this.age);
		   
		   
	   }
	   
	}

