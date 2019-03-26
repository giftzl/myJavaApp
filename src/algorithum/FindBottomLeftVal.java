package algorithum;

import java.util.LinkedList;
import java.util.Queue;

import util.ArrayUtils;
import util.TreeNode;;

/**
 * Given binary tree:
 * 
 * Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

	Output:	7
 *
 */
public class FindBottomLeftVal {

	public static void main(String[] args) {
		
		Integer[] ary = {null, 1,2,3,4,null,5,6,null, null,null, null,7};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		System.out.println("Bottom left value:"+new FindBottomLeftVal().findBottomLeftValue(root));

	}

	public int findBottomLeftValue(TreeNode root) {
		 if (root == null) return 0;
	        
	        int result = 0;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                TreeNode node = queue.poll();
	                if (i == 0) result = node.value;
	                if (node.left != null) queue.add(node.left);
	                if (node.right != null) queue.add(node.right);
	            }
	        }
	        
	        return result;
	    }
}
