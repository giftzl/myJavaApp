package algorithum;

public class HouseRobber {

	public static void main(String[] args) {

//		int[] nums = { 2,1,1,2,3,3,3,9,1 };
		int[] nums = { 1, 2, 3, 2 };

		HouseRobber robber = new HouseRobber();
		System.out.println(robber.rob(nums));

	}

	/**
	 * 
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed, the only constraint stopping you
	 * from robbing each of them is that adjacent houses have security system
	 * connected and it will automatically contact the police if two adjacent houses
	 * were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight without
	 * alerting the police.
	 * 
	 * @param nums
	 * @return
	 */
	private int rob(int[] nums) {

		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		if (n > 2)
			nums[2] += nums[0];

		for (int i = 3; i < n; i++)
			nums[i] += Math.max(nums[i - 2], nums[i - 3]);

		return Math.max(nums[n - 1], nums[n - 2]);

	}

	/**
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed. All houses at this place are
	 * arranged in a circle. That means the first house is the neighbor of the last
	 * one. Meanwhile, adjacent houses have security system connected and it will
	 * automatically contact the police if two adjacent houses were broken into on
	 * the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight without
	 * alerting the police.
	 * 
	 * Example 1:
	 * 
	 * Input: [2,3,2] Output: 3 Explanation: You cannot rob house 1 (money = 2) and
	 * then rob house 3 (money = 2), because they are adjacent houses. Example 2:
	 * 
	 * Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then rob
	 * house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
	 * 
	 * @param nums
	 * @return
	 */
	public int robWithCycle(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] num, int lo, int hi) {
		int include = 0, exclude = 0;
		for (int j = lo; j <= hi; j++) {
			int i = include, e = exclude;
			include = e + num[j];
			exclude = Math.max(e, i);
		}
		return Math.max(include, exclude);

	}
}
