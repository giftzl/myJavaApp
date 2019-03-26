package algorithum;

public class PowerCount {
	
	public static void main(String[] args) {
		
		int i =5;
		System.out.println(Integer.toBinaryString(i));
		
		whetherPowerof2(5);
		whetherPowerof2(8);
		whetherPowerof2(10);
		whetherPowerof2(16);
		whetherPowerof2(0);
		
		
		printAdjacentInfo(10, whetherAdjacentBinary(10));
		printAdjacentInfo(4, whetherAdjacentBinary(4));
	
		
	}

	public static void printAdjacentInfo(int i, boolean isAdjecent) {
		System.out.println(Integer.toString(i)+":" +   Integer.toBinaryString(i) + (isAdjecent?" is":" is not") + " adjacent number");
		
	}


	private static boolean whetherAdjacentBinary(int i) {
		
		String binStr = Integer.toBinaryString(i);
		
		for(int j =0; j< binStr.length()-1; j++) {
			if(binStr.charAt(j) == binStr.charAt(j+1))
				return false;
		}
		return true;
		
	}

	/**
	 * power of 2 means only one bit is "1"
	 * 
	 * @param i
	 * @return
	 */
	private static boolean whetherPowerof2(int i) {
		if(i < 0)
			return false;
		
		boolean isPowerOf2 = (Integer.bitCount(i) ==1);
		
		if(isPowerOf2)
			System.out.println("number "+i+" is power of 2");
		else
			System.out.println("number "+i+" is not power of 2");
		
		return isPowerOf2;
	}
}
