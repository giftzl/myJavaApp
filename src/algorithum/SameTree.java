package algorithum;

import util.ArrayUtils;
import util.TreeNode;

/**
 *
 *  Given two binary trees, write a function to check if they are the same or not.

	Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
	
	Example 1:
	
	Input:     1         1
	          / \       / \
	         2   3     2   3
	
	        [1,2,3],   [1,2,3]
	
	Output: true
	
	
	Example 2:
	
	Input:     1         1
	          /           \
	         2             2
	
	        [1,2],     [1,null,2]
	
	Output: false
	
	
	Example 3:
	
	Input:     1         1
	          / \       / \
	         2   1     1   2
	
	        [1,2,1],   [1,1,2]
	
	Output: false
 *
 *
 */
public class SameTree {

	public static void main(String[] args) {

		int[] t1 = { 0, 2, 1, 3 };
		int[] t2 = { 0, 2, 1, 3 };

		TreeNode root1 = ArrayUtils.makeBinaryTreeByArray(t1, 1);
		TreeNode root2 = ArrayUtils.makeBinaryTreeByArray(t2, 1);
		
		boolean isSame = SameTree.isSameTree(root1, root2);
		
		System.out.println("2 trees "+ (isSame?"are":"arent'")+" the same.");

	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p== null && q == null)
			return true;
		if(p == null || q ==null)
			return false;
		if(p.value == q.value)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		
		return false;
		

	}
}
