package algorithum;

public class DPCoinChange {

	/**
	 * @param coinsValues  币种
	 * @param n 待找零钱金额
	 * @return 多少种找零的找法
	 * 
	 */
	public static int maxChargeTypes(int[] coinsValues, int n) {
		int m = coinsValues.length;
		int[][] c = new int[m + 1][n + 1];

		// 基准条件,可参考下面的递归代码
		for (int i = 0; i <= m; i++)
			c[i][0] = 1;
		for (int i = 1; i <= n; i++)
			c[0][i] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (j < coinsValues[i - 1])// 第 i 枚硬币 不可用. (需要找 5块钱,但是现在只有一张百元大钞)
				{
					c[i][j] = c[i - 1][j];
					continue;
				}
				// 在第 i 枚硬币可用的情况下, 不使用 第 i 枚硬币 或者第 i 枚硬币至少使用一次---状态方程
				c[i][j] = c[i - 1][j] + c[i][j - coinsValues[i - 1]];// coinsValues下标从0开始
			}
		}
		return c[m][n];
	}

	/**
	 * 
	 * @param coinsValues 可用来找零的硬币 coinsValues.length 是硬币的种类
	 * @param n           待找的零钱
	 * @return 最少硬币数目
	 */
	public static int change(int[] coinsValues, int n) {
		int[][] c = new int[coinsValues.length + 1][n + 1];

		// 特殊情况1
		for (int i = 0; i <= coinsValues.length; i++)
			c[i][0] = 0;
		for (int i = 0; i <= n; i++)
			c[0][i] = Integer.MAX_VALUE;

		for (int j_money = 1; j_money <= n; j_money++) {

			for (int i_coinKinds = 1; i_coinKinds <= coinsValues.length; i_coinKinds++) {
				// 特殊情况2，coinsValues数组下标是从0开始的, c[][]数组下标是从1开始计算的
				if (j_money < coinsValues[i_coinKinds - 1])
				{
					// 只能使用 第 1...(i-1)枚中的硬币
					c[i_coinKinds][j_money] = c[i_coinKinds - 1][j_money];
					continue;
				}

				// 每个问题的选择数目---选其中较小的
				if (c[i_coinKinds - 1][j_money] < (c[i_coinKinds][j_money - coinsValues[i_coinKinds - 1]] + 1))
					c[i_coinKinds][j_money] = c[i_coinKinds - 1][j_money];
				else
					c[i_coinKinds][j_money] = c[i_coinKinds][j_money - coinsValues[i_coinKinds - 1]] + 1;
			}
		}
		return c[coinsValues.length][n];
	}

	// 递归实现
	public static int recursiveChargeTypes(int[] coinsValues, int m, int n) {
		// 基准条件 可以 通过画一个简单的实例 分析来得出. 比如 recursiveChargeTypes({1,3,4}, 3, 5)
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (m <= 0)
			return 0;
		else
			return recursiveChargeTypes(coinsValues, m - 1, n)
					+ recursiveChargeTypes(coinsValues, m, n - coinsValues[m]);
	}

	public static void main(String[] args) {
		int[] coinsValues = { 1, 2, 3 };
		int n = 5;
		
		System.out.println("Max change type: " + maxChargeTypes(coinsValues, n));
		System.out.println("Min count of change coin is: " + change(coinsValues, n));

	}
}