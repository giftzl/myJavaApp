package algorithum;
import util.ArrayUtils;
import util.TreeNode;

/**
 *
	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	
	For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	
	output: true;
	
	    1
	   / \
	  2   2
	   \   \
	   3    3
	output: false;
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		
		int[] ary = {0,1,2,2,3,4,4,3};
		TreeNode symmetric = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		int[] ary1 = {0,1,2,2,0,3,0,3};
		TreeNode unSymtric= ArrayUtils.makeBinaryTreeByArray(ary1, 1);
		
		System.out.println("isSymmetric? "+ new SymmetricTree().isSymmetric(symmetric));
		System.out.println("isSymmetric? "+ new SymmetricTree().isSymmetric(unSymtric));

	}

	public boolean isSymmetric(TreeNode root) {

		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null)
			return true;
		if(t1 == null || t2 == null)
			return false;
		
		return (t1.value == t2.value) 
				&& isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	}
}
