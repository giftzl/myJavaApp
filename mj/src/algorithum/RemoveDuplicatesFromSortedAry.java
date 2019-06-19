package algorithum;

import java.util.Arrays;

/**
 *  Given a sorted array nums, remove the duplicates in-place such that each element appear
    only once and return the new length.

	Do not allocate extra space for another array, you must do this by modifying the 
	input array in-place with O(1) extra memory.
	
	Example 1:
	
	Given nums = [1,1,2],
	
	Your function should return length = 2, with the first two elements of nums being 1 and 2
	It doesn't matter what you leave beyond the returned length.

 */
public class RemoveDuplicatesFromSortedAry {
	
	public static int removeDuplicatesInPlace(int[] nums) {
		if(nums == null) {
			return 0;
		}		
		int i = 1;
		for(int j = 1; j< nums.length; j++) {
			if(nums[j] != nums[j-1]) {
				nums[i++] = nums[j];
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		
		int[] ary = {1,1,1,1,2,2,3,4,5,5,5,7};
		System.out.println("input array is:"+ Arrays.toString(ary));
		System.out.println("After remmove duplicated elements, array length is "
							+ removeDuplicatesInPlace(ary));
	}

}
