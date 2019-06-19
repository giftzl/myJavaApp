package algorithum;
import util.TreeNode;;



/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
  		 _____3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
         
 *
 *
 */
public class LCAofBinaryTree {
	
	public static void main(String[] args) {
	
		int[] ary = {0,3,5,1,6,2,0,8,0,0,7,4};
		
		TreeNode root = generateTreeByAry(ary, 1);
		
		TreeNode node1 = root.left;
		TreeNode node2 = root.right;
		
		TreeNode lcaNode = lowestCommonAncestor(root, node1 , node2);
		
		System.out.println(lcaNode.value);
		
		
	}
	
	/**
	 * 
	 * if both p and q exist in Tree rooted at root, then return their LCA
	 * if neither p and q exist in Tree rooted at root, then return null 
	 * if only one of p or q (NOT both of them), exists in Tree rooted at root, return it
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return  
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root== null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left!=null &&right !=null )
			return root;
		return left!=null?left:right;
	      
	        
	}
	
	public static TreeNode generateTreeByAry(int[] ary,int index) {
		if(index <  ary.length) {
			int value = ary[index];
			if(value !=0) {
				TreeNode node = new TreeNode(value);
				node.left = generateTreeByAry(ary, index*2);
				node.right = generateTreeByAry(ary, index *2+1);
				return node;
			}
			
		}
		return null;
		
		
	}

}
