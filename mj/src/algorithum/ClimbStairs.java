package algorithum;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1
 * step + 1 step 2. 2 steps Example 2:
 * 
 * Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1.
 * 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 */
public class ClimbStairs {

	public static void main(String[] args) {

		int[] ary = { 1, 2, 3, 4, 5,44 };
		for (int i = 0; i < ary.length; i++) {
			System.out.println("stair steps is " + ary[i] + ", then there're "
								+ climbStairs1(ary[i]) + " ways to climb.");
		}
		for (int i = 0; i < ary.length; i++) {
			System.out.println("stair steps is " + ary[i] + ", then there're "
								+ climbStairs2(ary[i]) + " ways to climb.");
		}
		for (int i = 0; i < ary.length; i++) {
			System.out.println("stair steps is " + ary[i] + ", then there're "
								+ clibStairs_dp(ary[i]) + " ways to climb.");
		}
	}

	public static int climbStairs1(int n) {

		if (n == 1)
			return 1;	
		if (n == 2)
			return 2;
		else
			return climbStairs1(n - 1) + climbStairs1(n - 2);
	}

	public static int climbStairs2(int n) {
		return climb_Stairs(0, n);
	}

	public static int climb_Stairs(int i, int n) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
	}
	
	
	public static int clibStairs_dp(int n) {
		
		 if(n==1) return n;
		
		int[] aux = new int[n+1];
		
		aux[1] = 1;
		aux[2] = 2;
		
		for(int i = 3; i<=n; i++) {
			aux[i] = aux[i-1]+aux[i-2];
		}
		return aux[n];
		
	}
	
}
