package algorithum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author vivianzhu
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] rs = twoSum(nums, target);
		System.out.println(Arrays.toString(rs));

	}

	public static int[] twoSum(int[] ary, int target) {
		int[] rs = new int[2];
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i< ary.length; i++) {
			map.put(ary[i], i);
		}
		
		for (int i = 0; i < ary.length; i++) {
			int val = target - ary[i];
			if(map.containsKey(val) && i != map.get(val)) {
				rs[0] = Math.min(i, map.get(val));
				rs[1] = Math.max(i, map.get(val));
			}
		}

		return rs;
	}

}
