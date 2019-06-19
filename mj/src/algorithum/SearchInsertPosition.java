package algorithum;

import util.ArrayUtils;

/**
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order. You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,6], 5 Output: 2 
 * 
 * Example 2:
 * 
 * Input: [1,3,5,6], 2 Output: 1 
 * 
 * Example 3:
 * 
 * Input: [1,3,5,6], 7 Output: 4
 * 
 *
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		
		int[] ary = {1,3,5,6};
//		int[] ary = {1,3};
//		int[] targets = {5,2,7};
		int[] targets = {7};
		
		for (int i = 0; i < targets.length; i++) {
			SearchInsertPosition solution = new SearchInsertPosition();
			ArrayUtils.printArray(ary,"Input array: ");
			
			int rs = solution.searchInsert(ary, targets[i]);
			System.out.println("Target: "+targets[i]+". Insert postion is:" +rs);
		}
	}

	public int searchInsert(int[] nums, int target) {
		
		int rs = 0;
		
		if(nums[0] >= target)
			return 0;
		if(nums[nums.length-1] == target)
			return nums.length-1;
		if(nums[nums.length-1] < target)
			return nums.length;
		
		for (int i = 1; i < nums.length; i++) {
			if( nums[i-1] < target && nums[i]> target ) {
				rs = i;
				break;
			}else if(nums[i-1] == target && nums[i]> target){
				rs = i-1;
				break;
			}
		}
		return rs;
	}
}
