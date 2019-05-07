package algorithum;
import util.ArrayUtils;
import util.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
	    1             1
	   / \             
	  2   5              
	 / \   \             
	3   4   6             
 *
 * into list IN-PLACE
 *
	1
	 \
	  2
	   \
	    3
	     \
	      4
	       \
	        5
	         \
	          6
 */

/**
 * bottom-up,  post order traversal solution
 */
public class FlattentBinaryTree {

	private TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}

	public static void main(String[] args) {
		Integer[] ary = {null,1,2,5,3,4,null,6};
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		new FlattentBinaryTree().flatten(root);
		System.out.println(root);

	}

}
