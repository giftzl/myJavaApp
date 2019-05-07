package algorithum;

import util.ArrayUtils;
import util.TreeNode;

/**
	Given a non-empty binary tree, find the maximum path sum.
	
	For this problem, a path is defined as any sequence of nodes from some starting node to any node 
	in the tree along the parent-child connections. The path must contain at least one node and does not 
	need to go through the root.
	
	Example 1:
	
	Input: [1,2,3]
	
	       1
	      / \
	     2   3
	
	Output: 6
	
	Example 2:
	
	Input: [-10,9,20,null,null,15,7]
	
	   -10
	   / \
	  9  20
	    /  \
	   15   7
	
	Output: 42

 *
 *
 */
public class BinaryTreeMaxPathSum {

	int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
	    int maxBranchVal = helper(root);
	    System.out.println("max branch val:" + maxBranchVal);
		return max;
	}

	// helper returns the max branch + plus current node's value
	int helper(TreeNode root) {
		if (root == null)
			return 0;

		// in case the value is 0
		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right), 0);

		max = Math.max(max, root.value + left + right);

		return root.value + Math.max(left, right);
	}
	

	public static void main(String[] args) {
		
	  Integer[] arys = { null, -10,9,20,null,null,15,7}	;
	  
	  TreeNode root = ArrayUtils.makeBinaryTreeByArray(arys, 1);
	  
	  System.out.println("Max path sum of the BST is:" + new BinaryTreeMaxPathSum().maxPathSum(root));
	}
	
	
}
