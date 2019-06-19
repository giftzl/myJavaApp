package algorithum;
import java.util.ArrayDeque;
import java.util.Deque;

import util.TreeNode;

/**
 * 
	    5
	   / \
	  1   4
	     / \
	    3   6
	Output: false
	
	Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
	             is 5 but its right child's value is 4.
 *
 *
		    2
		   / \
		  1   3
		  
	 Output: true
 */

public class ValidBinarySearchTree {
	
	public static void main(String[] args) {
		
		ValidBinarySearchTree solution = new ValidBinarySearchTree();
		
		Integer[] ary = {null,5,1,4,null,null,3,6};
		TreeNode root1 = solution.generateTree(ary, 1);
		
		Integer[] ary2 = {null,2,1,3};
		TreeNode root2 = solution.generateTree(ary2, 1);
		
		boolean flag1 = solution.isValidBSTRecursive(root1);
		boolean flag2 = solution.isValidBSTRecursive(root2);
		
		System.out.println(flag1+","+flag2);
		
		System.out.println( solution.isValidBSTIter(root1) +","+  solution.isValidBSTIter(root2) );
		
	}
	
	public boolean isValidBSTRecursive(TreeNode root) {
		return _isValidBSTRecu(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}
	
	private boolean _isValidBSTRecu(TreeNode root, long minValue, long maxValue) {
		if(root == null)
			return true;
		if(root.value <= minValue || root.value >= maxValue)
			return false;
		
		return _isValidBSTRecu(root.left, minValue, root.value) 
				&& _isValidBSTRecu(root.right, root.value, maxValue);
		
	}
	
	
	public boolean isValidBSTIter(TreeNode root) {
		//TODO:
		boolean flag = true;
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			TreeNode left = node.left;
			TreeNode right = node.right;
			if(left!= null && right!= null
					&& (node.value < left.value || node.value > right.value))
				flag = false;
			
			if(right != null)
				stack.push(right);
			if (left != null) {
				stack.push(left);
			}
		
		}
		return flag;

	}

	public TreeNode generateTree(Integer[] ary, int index) {
		if(index < ary.length) {
			Integer value = ary[index];
			if(value != null) {
				TreeNode node = new TreeNode(value);
				node.left = generateTree(ary, index*2);
				node.right = generateTree(ary, index*2+1);
				return node;
			}
		}
		return null;
	}
	

}
