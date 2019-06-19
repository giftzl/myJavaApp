package algorithum;

import util.ArrayUtils;
import util.TreeNode;

/**
	Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
	where largest means subtree with largest number of nodes in it.
	
	Note:
	A subtree must include all of its descendants.
	Here's an example:
	    10
	    / \
	   5  15
	  / \   \ 
	 1   8   7
	
	The Largest BST Subtree in this case is the [5,1,8]. The return value is the subtree's size, which is 3.

 *
 */
public class LargestBSTSubtree {
	private int max = 0;

	/**
	 * 
	 * 方法：递归检查。一颗子树当且仅当其左右子树都是BST，并且左子树的最大值小于根节点，右子树的最小值大于根节点的时候，
	 * 这棵子树才是BST。则定一个递归函数的返回结果，包括该节点能否形成一棵BST，以及该BST的节点总数。
	 */
	private Range check(TreeNode root) {
		Range range = new Range(root.value, root.value);
		Range left = (root.left == null) ? null : check(root.left);
		Range right = (root.right == null) ? null : check(root.right);
		if (left != null) {
			if (!left.bst || left.max >= root.value)
				return range;
			range.min = left.min;
			range.count += left.count;
		}
		if (right != null) {
			if (!right.bst || root.value >= right.min)
				return range;
			range.max = right.max;
			range.count += right.count;
		}
		range.bst = true;
		max = Math.max(max, range.count);
		return range;
	}

	public int largestBSTSubtree2(TreeNode root) {
		if (root != null)
			check(root);
		return max;
	}
	
	/**
	 * 对于整个数的每一个节点，判断当前节点子树是不是一个BST，是个话返回节点个数，不是的话返回左右子树的最大BST子树节点个数。
	 * @param root
	 * @return int
	 */
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}
		if (isValid(root, null, null)) {
			return countNode(root);
		}
		return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
	}

	private boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) {
			return true;
		}
		if (min != null && min.value >= root.value) {
			return false;
		}
		if (max != null && max.value <= root.value) {
			return false;
		}
		boolean valid = (isValid(root.left, min, root) && isValid(root.right, root, max));
		return valid;
	}

	private int countNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return 1 + countNode(root.left) + countNode(root.right);
	}

	
	public static void main(String[] args) {
		
		LargestBSTSubtree solution = new LargestBSTSubtree();
		
		Integer[] ary = {null, 10,5,15,1,8,null,7};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		System.out.println("Largest BST subtree node count1:"+ solution.largestBSTSubtree(root));
		
		System.out.println("Largest BST subtree node count2:"+ solution.largestBSTSubtree2(root));
		
		
	}
}

class Range {
	boolean bst;
	int min, max;
	int count = 1;

	Range(int min, int max) {
		this.min = min;
		this.max = max;
	}

}
