package algorithum;
import util.ArrayUtils;
import util.TreeNode;

/**
 * 
 *  Given a binary tree, find its maximum depth.

	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	
	Note: A leaf is a node with no children.
	
	Example:
	
	Given binary tree [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	   
	return its depth = 3.

 *
 */
public class MaxDeptOfBianeryTree {
	

	public static void main(String[] args) {
		Integer[] ary = {null, 3,9,20, null, null, 15,7};
		
//		int[] ary={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		ArrayUtils.printOutTree(root,"Input tree:");
		
		
		System.out.println("Max dept of the binary tree is : "+ maxDepth(root));
		

	}

	public static int maxDepth(TreeNode root) {
		
		if(root == null)
			return 0;
		
		int left = maxDepth(root.left)+1;
		int right = maxDepth(root.right)+1;
		
		return Math.max(left, right);
	}
}
