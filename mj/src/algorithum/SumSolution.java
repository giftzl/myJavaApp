package algorithum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumSolution {
	
	public static void main(String[] args) {
		
//		int[] ary = {2,5,5,11};
		int[] ary = {2,2,5,8};
		int target = 10;
		
		int[] rs = SumSolution.twoSum(ary, target);
		System.out.println(Arrays.toString(rs));
		
		
	}

	/**
	 * 
	 * Given an array of integers, return indices of the two numbers such that they add up to a
	 *  specific target.You may assume that each input would have exactly one solution, 
	 *  and you may not use the same element twice.
	 * 
	 * @param ary
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] ary, int target) {
		int[] rs = new int[2];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i< ary.length; i++) {
			map.put(ary[i], i);
		}
		
		for (int i = 0; i < ary.length; i++) {
			int val = target - ary[i];
			if(map.containsKey(val) && map.get(val) != i) {
				rs[0] = Math.min(i, map.get(val));
				rs[1] = Math.max(i, map.get(val));
			}
			
		}
		
		return rs;
	}
	
	
}
