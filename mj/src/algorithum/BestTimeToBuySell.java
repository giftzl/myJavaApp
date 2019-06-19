package algorithum;

/**
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 * 
 * Input: [7,1,5,3,6,4] 
 * Output: 5 
 * Explanation: Buy on day 2 (price = 1) and sell
 * on day 5 (price = 6), profit = 6-1 = 5. Not 7-1 = 6, as selling price needs
 * to be larger than buying price.
 */
public class BestTimeToBuySell {

	public static void main(String[] args) {
		int[] stock = { 7, 1, 5, 3, 6, 4 };
//		int[] stock = { 7, 6, 4, 3, 1 };

		System.out.println(maxProfit(stock));
		System.out.println(maxProfitRecursive(stock));
	}

	public static int maxProfit(int[] prices) {

		int min = prices[0];
		int mindex = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
				mindex = i;
			}
		}

		int max = prices[mindex];
		int mandex = mindex;
		for (int j = mindex; j < prices.length; j++) {
			if (prices[j] > max) {
				max = prices[j];
				mandex = j;
			}
		}

		if (max <= min)
			return 0;
		else
			return max - min;
	}

	public static int maxProfitRecursive(int[] prices) {

		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}

}