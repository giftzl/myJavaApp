package algorithum;

import java.util.Arrays;

/**
	Given an array of non-negative integers, you are initially positioned at the first 
	index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	Example 1:
	
	Input: [2,3,1,1,4]
	Output: true
	Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
	
	Example 2:
	
	Input: [3,2,1,0,4]
	Output: false
	Explanation: You will always arrive at index 3 no matter what. Its maximum
	             jump length is 0, which makes it impossible to reach the last index.

 */
public class JumpGame {

	public  boolean canJump(int[] nums) {
		boolean can = false;

		int maxindex = nums.length - 1;
		int index = 0;

		while (index <maxindex) {
			int step = nums[index];
			if(step == 0) 
				break;
			index += step;
		}
		if (index == maxindex)
			can = true;

		return can;
	}
	
	boolean canJump(int A[], int n) {
	    int last=n-1,i;
	    for(i=n-2;i>=0;i--){
	        if(i+A[i]>=last)last=i;
	    }
	    return last==0;
	}
	
    boolean canJumpDP(int[] nums) {
    	
        int n = nums.length;
        boolean[] jump = new boolean[n];
        
        jump[n-1]=true;
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<=nums[i] && i+j<n;j++)
            {
                if(jump[i+j]==true) 
                {
                    jump[i]=true; 
                    break;
                }
            }
        }
        return jump[0];
    }

	public static void main(String[] args) {
		int[] canary = {2,3,1,1,4};
		int[] cannotAry = { 3,2,1,0,4 };
		int[] ary = { 2,0 };
		
		System.out.println("input ary" + Arrays.toString(canary)
				+(new JumpGame().canJump(canary)?" can ":" cannot ")+"jump to last index." );
		
		System.out.println("input ary" + Arrays.toString(cannotAry)
			    + (new JumpGame().canJumpDP(cannotAry)?" can ":" cannot ")+"jump to last index." );
			
		System.out.println("input ary" + Arrays.toString(ary)
				+(new JumpGame().canJump(ary, ary.length)?" can ":" cannot ")+"jump to last index." );

	}
}
