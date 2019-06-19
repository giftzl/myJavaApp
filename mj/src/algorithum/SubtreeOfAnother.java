package algorithum;

import util.ArrayUtils;
import util.TreeNode;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure
 *  and node values with a subtree of s. A subtree of s is a tree consists of a node in s 
 *  and all of this node's descendants. The tree s could also be considered as a subtree of itself.

	Example 1:
	
	Given tree s:
	
	     3
	    / \
	   4   5
	  / \
	 1   2
	 
	Given tree t:
	   4 
	  / \
	 1   2
	 
 Return true, because t has the same structure and node values with a subtree of s. 
	 
 */
public class SubtreeOfAnother {

	 /**
	  * judge whether t is subtree of s 
	  *
	 * @param s big tree
	 * @param t samll tree
	 * @return
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {
		 
		 if(s == null)
			 return false;
		 if(isSameTree(s, t))
			 return true;
		 return isSubtree(s.left, t) || isSubtree(s.right, t);
		 
	 }
	 
	 public boolean isSameTree(TreeNode p, util.TreeNode q) {
		 
		 if(p == null && q == null)
			 return true;
		 if(p == null || q == null)
			 return false;
		 
		 return (q.value == p.value) 
				 	&& isSameTree(p.left, q.left)
				 	&& isSameTree(p.right, q.right);
		 
	 }
	 
	 public static void main(String[] args) {
		 Integer[] tree1 = {null,3,4,5,1,2};
		 Integer[] tree2 = {null,4,1,2};
		 
		 TreeNode root_s = ArrayUtils.makeBinaryTreeByArray(tree1, 1);
		 TreeNode root_t = ArrayUtils.makeBinaryTreeByArray(tree2, 1);
		 
		 ArrayUtils.printOutTree(root_s, "Create tree s");
		 ArrayUtils.printOutTree(root_t, "Create tree t");
		 
		 System.out.println( "Tree t "+( new SubtreeOfAnother().isSubtree(root_s, root_t)?"is":"isn't")
				 			+ " a subtree of Tree s");
		 
		 
		
	}
}
