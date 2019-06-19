package basic;

public class ClassLoadSeq {
	
	
    public static int value1  = 5;
    public static int value2  = 6;
    static{
        value2 = 66;
    }
	
	public static void main(String[] args) {
	
		new Child();
	}

}

class Ancesstor{
	static String name = "A";
	
	static {
		int age = 31;
		System.out.println(age);
	}
	
	public Ancesstor() {
		System.out.println("init ancesstor");
	}
	
}


class Child extends Ancesstor{
	static String name = "C";
	
	
	static {
		int age = 3;
		System.out.println(age);
	}
	
	public Child() {
		System.out.println("init Child");
	}
	
}
