package algorithum;

import java.util.Arrays;

/**
 * 
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of 
    the non-zero elements.

	Example:
	
	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]
	
	Note:
	
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
	 
 *
 */
public class MoveZeroTest {
	
	
	
	public void moveZero(int[] nums) {
		
		int zeroCnt = 0;
		int head = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)
				zeroCnt++;
			else 
				nums[head++] = nums[i];
		}
		for(int j = 0; j< zeroCnt; j++) {
			nums[head++] = 0;
		}
	}

	public static void main(String[] args) {


		int[] nums = { 0, 12, 3, 0, 6, 9 };

		new MoveZeroTest().moveZero(nums);

		System.out.println(Arrays.toString(nums));
	}

}
