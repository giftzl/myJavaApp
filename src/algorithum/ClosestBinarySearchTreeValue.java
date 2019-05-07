package algorithum;

import util.ArrayUtils;
import util.TreeNode;

public class ClosestBinarySearchTreeValue {

	/**
	 * 
	 * 算法很简单，求出 lowerBound 和 upperBound。 即 < target 的最大值和 >= target 的最小值。
	 * 然后在两者之中去比较谁更接近，然后返回即可。
	 * 
	 *  时间复杂度为 O(h)O(h)，注意如果你使用 in-order traversal的话
	 *  时间复杂度会是 o(n)o(n) 并不是最优的。 另外复杂度也不是 O(logn)O(logn) 因为BST 并不保证树高是 logn 的。
	 * 
	 * @param root: the given BST
	 * @param target: the given target
	 * @return: the value in the BST that is closest to the target
	 */
	public int closestvalueue(TreeNode root, double target) {
		
		if (root == null) {
			return 0;
		}
		// 找到< target 的最大值和 >= target 的最小值。
		TreeNode lowerNode = lowerBound(root, target);
		TreeNode upperNode = upperBound(root, target);

		// 如果只有lowerBound 或 upperBound 之一，则直接返回
		if (lowerNode == null) {
			return upperNode.value;
		}
		if (upperNode == null) {
			return lowerNode.value;
		}
		// 在两者之中去比较谁更接近，然后返回即可
		if (target - lowerNode.value > upperNode.value - target) {
			return upperNode.value;
		}
		return lowerNode.value;
	}

	/**
	 * find the node with the largest valueue that smaller than target
	 */
	private TreeNode lowerBound(TreeNode root, double target) {
		if (root == null) {
			return null;
		}
		// 如果根节点都大于等于target，则target一定在左子树
		if (target <= root.value) {
			return lowerBound(root.left, target);
		}

		// root.value < target
		// 否则target可能在右子树，也可能为根节点
		TreeNode lowerNode = lowerBound(root.right, target);
		if (lowerNode != null) {
			return lowerNode;
		}
		return root;
	}

	
	/**
	 * find the node with the smallest valueue that larger than or equal to target
	 */
	private TreeNode upperBound(TreeNode root, double target) {
		if (root == null) {
			return null;
		}
		// 如果根节点都小于target，则target一定在右子树
		if (target > root.value) {
			return upperBound(root.right, target);
		}

		// root.value >= target
		// 否则target可能在左子树，也可能为根节点
		TreeNode upperNode = upperBound(root.left, target);
		if (upperNode != null) {
			return upperNode;
		}
		return root;
	}
	
	/**
	 *      6
		   / \
		  4   7
		 / \    
	    2   5
		 \
		  3 
	 */
	public static void main(String[] args) {
		
		Integer[] ary = {null, 6,4,7,2,5,null, null, null,3};
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		System.out.println("Closest value: "+new ClosestBinarySearchTreeValue().closestvalueue(root, 2.5));
		
	}
}
