package algorithum;

import util.ArrayUtils;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * Input: [2,0,2,1,1,0] 
 * Output: [0,0,1,1,2,2]
 *
 *
 * 
 */
public class SortColor {

	public static void main(String[] args) {
		
		int[] ary = {2,0,2,1,1,0};
		sortColorsInPlace(ary);
		ArrayUtils.printArray(ary);
	}

	public static void sortColorsInPlace(int[] nums) {
		
		int count0 = 0, count1=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)
				count0++;
			else if(nums[i] == 1)
				count1++;
			
			
		}
		for(int i= 0;i<nums.length;i++) {
			if(i<count0)
				nums[i] = 0;
			else if(i< count0+count1)
				nums[i] = 1;
			else {
				nums[i] =2;
			}
		}

	}
}
