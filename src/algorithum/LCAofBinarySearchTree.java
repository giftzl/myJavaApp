package algorithum;

import util.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given binary search tree: root = [6,2,8,0,4,7,9,null,null,3,5]
 * 
	 
	        _______6______
	       /              \
	    ___2__          ___8__
	   /      \        /      \
	   0      4       7       9
	         / \
	        3   5
	         
 */
public class LCAofBinarySearchTree {
	
	public static void main(String[] args) {
		
		LCAofBinarySearchTree solution = new LCAofBinarySearchTree();
		
		Integer[] ary = {null, 6,2,8,0,4,7,9,null,null,3,5};
		
		TreeNode root = solution.generateTree(ary, 1);
		
		TreeNode lowNode1 = solution.LCAIterater(root, new TreeNode(2), new TreeNode(8));
		TreeNode lowNode2 = solution.LCARecursive(root, new TreeNode(0), new TreeNode(4));
		
		System.out.println(lowNode1.value +","+lowNode2.value);
		
		
	}
	
	public TreeNode LCAIterater(TreeNode root, TreeNode p, TreeNode q) {
		while(root != null) {
			if(root.value > p.value && root.value > q.value) {
				root = root.left;
			}else if(root.value < p.value && root.value < q.value) {
				root = root.right;
			}else
				return root;
		}
        return root;
    }
	
	public TreeNode LCARecursive(TreeNode root, TreeNode p, TreeNode q) {
	
		if(root.value > p.value && root.value >q.value) {
			return  LCARecursive(root.left, p, q);
		}else if(root.value < p.value && root.value <q.value) {
			return LCARecursive(root.right, p, q);
		}else {
			return root;
		}
		
	}

	
	public TreeNode generateTree(Integer[] ary, int index) {
		if(index < ary.length) {
			Integer value = ary[index];
			if(value != null) {
				TreeNode treeNode = new TreeNode(value);
				treeNode.left = generateTree(ary, index*2);
				treeNode.right = generateTree(ary, index*2+1);
				return treeNode;
			}
		}
		return null;
	}
}
