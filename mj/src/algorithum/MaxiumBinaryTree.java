package algorithum;

import java.util.Deque;
import java.util.LinkedList;

import util.TreeNode;

/**
 *  Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

	The root is the maximum number in the array.
	The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
	The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
	Construct the maximum tree by the given array and output the root node of this tree.
	
	Example 1:
	Input: [3,2,1,6,0,5]
	Output: return the tree root node representing the following tree:
	
	      6
	    /   \
	   3     5
	    \    / 
	     2  0   
	       \
	        1
	        
 */
public class MaxiumBinaryTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		
		Deque<TreeNode> stack = new LinkedList<>();
		
		for (int i = 0; i < nums.length; i++) {
			
			TreeNode curr = new TreeNode(nums[i]);
			
			//curNode.left = last pop node
			while (!stack.isEmpty() && stack.peek().value < nums[i]) {
				curr.left = stack.pop();
			}
			// stack.peek().value > curr.value;
			if (!stack.isEmpty()) {
				stack.peek().right = curr;
			}
			stack.push(curr);
		}

		return stack.isEmpty() ? null : stack.removeLast();
	}
	
	public TreeNode constructMaximumBinaryTreeRecur(int[] nums) {
		if (nums == null)
			return null;
		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] nums, int start, int end) {
		if (start > end)
			return null;

		int idxMax = start;
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] > nums[idxMax]) {
				idxMax = i;
			}
		}

		TreeNode root = new TreeNode(nums[idxMax]);

		root.left = build(nums, start, idxMax - 1);
		root.right = build(nums, idxMax + 1, end);

		return root;
	}
	
	
	public static void main(String[] args) {
		
		int[] ary = {3,2,1,6,0,5};
	
		TreeNode root = new MaxiumBinaryTree().constructMaximumBinaryTree(ary);
		
		BinaryTreeTranverse bt = new BinaryTreeTranverse(root);
		bt.levelOrderTraversal();
		
		TreeNode root1 = new MaxiumBinaryTree().constructMaximumBinaryTreeRecur(ary);
		System.out.println("recursive:"+bt.levelOrderList(root1).toString());
	}

}
