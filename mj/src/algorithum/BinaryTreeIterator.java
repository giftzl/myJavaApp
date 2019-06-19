package algorithum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.ArrayUtils;
import util.TreeNode;

/**
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 *
 */
public class BinaryTreeIterator {

	private Stack<TreeNode> stack;

	public BinaryTreeIterator(TreeNode root) {
		stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			if (cur.left != null)
				cur = cur.left;
			else
				break;
		}
	}

	/**
	 * 
	 *  @return whether we have a next smallest number
	 *  
	 */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/**
	 * 
	 *  @return the next smallest number
	 *  
	 **/
	public int next() {
		TreeNode node = stack.pop();
		TreeNode cur = node;
		// traversal right branch
		if (cur.right != null) {
			cur = cur.right;
			while (cur != null) {
				stack.push(cur);
				if (cur.left != null)
					cur = cur.left;
				else
					break;
			}
		}
		return node.value;
	}
	
	/**
	 *      6
		   / \
		  4   7
		 / \    
	    2   5
		 \
		  3 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer[] array = {null, 6,4,7,2,5,null,null,null,3};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(array, 1);
		
		BinaryTreeIterator i = new BinaryTreeIterator(root);
		
		List<Integer> res = new ArrayList<>();
		
		while (i.hasNext()) {
			 int value = i.next();
			 res.add(value);
		}
		 System.out.println(res.toString());
	}
}
