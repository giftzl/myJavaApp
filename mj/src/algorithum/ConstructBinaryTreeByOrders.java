package algorithum;
import java.util.HashMap;
import java.util.Map;

import util.TreeNode;


/**
 * 
 * inorder = [9,3,15,20,7] postorder = [9,15,7,20,3] preorder=[3,9,20,15,7]
 * 
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * 
 *
 */
public class ConstructBinaryTreeByOrders {
	
	int[] pre;
	int[] post;
	int[] in;
	Map<Integer, Integer> inmap = new HashMap<>();

	
	/**
	 * @param preorder
	 * @param inorder
	 * @return TreeNode
	 */
	private TreeNode buildTreeByPostInOrder(int[] preorder, int[] inorder) {
		post = preorder;
		in = inorder;
		for(int i = 0; i< in.length; i++) {
			inmap.put(in[i], i);
		}
		return _buildTreeByPostIn(post.length-1,0,in.length-1);
		
		
	}

	private TreeNode _buildTreeByPostIn(int postStart, int inStart, int inEnd) {
		if(postStart > post.length-1 || inStart > inEnd)
			return null;
		
		int val = post[postStart];
		TreeNode root = new TreeNode(val);
		int inIndex = inmap.get(val);
		root.left = _buildTreeByPostIn(postStart+inIndex-inEnd-1, inStart, inIndex-1);
		root.right = _buildTreeByPostIn(postStart-1, inIndex+1, inEnd);
		return root;
	}

	/**
	 * 先序遍历可以提供根的所在，而根据中序遍历的性质知道根的所在就可以将序列分为左右子树。
	 * 
	 * inorder = [9,3,15,20,7] 
	 * preorder = [3,9,20,15,7]
	 * 
	 *      3
		   / \
		  9  20
		    /  \
		   15   7
	 */
	public TreeNode buildTreeByPreInOrder(int[] preorder, int[] inorder) {
		pre = preorder;
		in = inorder;
		for (int i = 0; i < inorder.length; i++) {
			inmap.put(inorder[i], i);
		}
		TreeNode root = helper(0, 0, in.length - 1);
       
		return root;
	}

	private TreeNode helper(int preStart, int inStart, int inEnd) {
		if (preStart > pre.length - 1 || inStart > inEnd)
			return null;
		int val = pre[preStart];
		TreeNode root = new TreeNode(val);
		int inIndex = inmap.get(val);
		root.left = helper(preStart + 1, inStart, inIndex - 1);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd);
		return root;
	}
	
	public static void main(String[] args) {

		ConstructBinaryTreeByOrders solution = new ConstructBinaryTreeByOrders();

		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };

		TreeNode root1 = solution.buildTreeByPreInOrder(preorder, inorder);

		TreeNode root2 = solution.buildTreeByPostInOrder(postorder, inorder);

		System.out.println(root1.value + "," + root2.value);

	}

}
