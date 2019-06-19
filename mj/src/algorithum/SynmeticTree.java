package algorithum;

import util.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
	     	1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
	Example : above is symmetric tree
	
		    1
		   / \
		  2   2
		   \   \
		   3    3
 * Example : above isn't symmetric tree
 *
 */
public class SynmeticTree {
	
	public static void main(String[] args) {
		
		int[] symmertric = {0,1,2,2,3,4,4,3};
//		int[] unsymmertric = {0,1,2,2,0,3,0,3};
		
		TreeNode root = makeBinaryTreeByArray(symmertric, 1);
		
		boolean isSynmetic = isMirror(root, root);
		
		System.out.println("The input tree "+(isSynmetic? "is":"isn't")+" symetic tree!");
	}

	private static boolean isMirror(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) 
			return true;
		if(t1 == null || t2 == null)
			return false;
		return (t1.value == t2.value) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
		
	}

	private static TreeNode makeBinaryTreeByArray(int[] array, int index) {
		if(index < array.length) {
			int value = array[index];
			if(value != 0) {
				TreeNode  t = new TreeNode(value);
//				array[index] = 0;
				t.left = makeBinaryTreeByArray(array, index * 2);
				t.right = makeBinaryTreeByArray(array, index * 2 +1);
				return t;
			}
			
		}
		return null;
	}

}
