package algorithum;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
	
	
	public static void main(String[] args) {
		
		int[] a= {3,0,1};
		
		int missing = missingNumber(a);
		System.out.println(missing);
		
		
		System.out.println("-------- finding missing number LIst ----------");
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> mList = findMissingNums(nums);
		for (Integer intval : mList) {
			System.out.println(intval);
		}
	}

	private static int missingNumber(int[] ary) {
		
		int indexSum = 0;
		int sum =0;
		int i = 0;
		
		for(; i< ary.length;i++) {
			indexSum += i;
			sum += ary[i];
		}
		indexSum +=i;
		
		return indexSum -sum;
	}

	
	private static List<Integer> findMissingNums(int[] nums){
		   List<Integer> rlist = new ArrayList<Integer>();
		  
		    int[] cnums =nums.clone();
	        
	        for(int i =0; i<=nums.length-1; i++){
	        	int val = nums[i];
	        	cnums[val-1]=0;
	           
	        }
	        
	        for(int j = 0; j< cnums.length; j++){
	            if(cnums[j] != 0){
	                rlist.add(j+1);
	            }
	        }        
	        return rlist;
	}
}
