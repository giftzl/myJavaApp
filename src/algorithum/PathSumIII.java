package algorithum;

import java.util.HashMap;
import java.util.Map;

import util.ArrayUtils;
import util.TreeNode;

/**
 *  You are given a binary tree in which each node contains an integer value.

	Find the number of paths that sum to a given value.
	
	The path does not need to start or end at the root or a leaf, but it must go downwards 
	(traveling only from parent nodes to child nodes).
	
	The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
	
	Example:
	
	root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
	
	      10
	     /  \
	    5   -3
	   / \    \
	  3   2   11
	 / \   \
	3  -2   1
	
	Return 3. The paths that sum to 8 are:
	
	1.  5 -> 3
	2.  5 -> 2 -> 1
	3. -3 -> 11

 */
public class PathSumIII {
	
	public int pathSum(TreeNode root, int sum) {
		
		// 'key' is current sum, 'value' is the ways to achieve this sum
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1); 
		
		// Default sum = 0 has one count
		return backtrack(root, 0, sum, map);
	}

	/**
	 * BackTrack one pass
	 * 
	 * @param root
	 * @param curSum	
	 * @param target
	 * @param map
	 * @return count
	 */
	public int backtrack(TreeNode root, int curSum, int target, Map<Integer, Integer> map) {
		if (root == null)
			return 0;
		
		curSum += root.value;
		
		// See if there is a subarray sum equals to target
		int res = map.getOrDefault(curSum - target, 0); 
		
		// there are one more way to achive the value 'curSum',so +1 and update the map
		map.put(curSum, map.getOrDefault(curSum, 0) + 1);
		
		// Extend to left and right child
		res += backtrack(root.left, curSum, target, map) 
				+ backtrack(root.right, curSum, target, map);
		
		// Remove the current node so it wont affect other path
		map.put(curSum, map.get(curSum) - 1); 
		
		return res;
	}

	public static void main(String[] args) {
		Integer[] ary = {null,10,5,-3,3,2,null,11,3,-2,null,1};
//		Integer[] ary = {1};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		ArrayUtils.printOutTree(root,"create tree:");
		
		int sum = 8;
		
		System.out.println("There're "+(new PathSumIII().pathSum(root, 8))+" ways to get sum "+ sum);

	}
}
