package collection;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {
	
	public static void main(String[] args) {
		
		TreeNode root= new TreeNode(3);
		
		TreeNodeTest.generateTree(root);
		
		TreeNodeTest.generateBinaryTree(new TreeNode(3));
		
		TreeNode subroot = new TreeNode(4);
		TreeNodeTest.generateSubTree(subroot);
		
		
		System.out.println("Tree preorder tranverse output is:");
		TreeNodeTest.preorder(root);
		
		System.out.println("\n\nTree inOrder tranverse output is:");
		TreeNodeTest.inOrder(root);
		
		System.out.println("\n\nTree postOrder tranverse output is:");
		TreeNodeTest.postOrder(root);
		
		System.out.println("\n\n");
		boolean isSubtree=TreeNodeTest.isSubTree(root, subroot);
		System.out.println("\n\n SubTree Judege:"+isSubtree);
		
		
	}
	
	private static boolean isSubTree(TreeNode s, TreeNode t) {
		boolean isSubTree = false;
		
		List<Integer> tPreorder = new ArrayList<Integer>();
		List<Integer> sPreorder = new ArrayList<Integer>();
		
		TreeNodeTest.preorder(t,tPreorder);
		TreeNodeTest.preorder(s,sPreorder);
		
		if(sPreorder.containsAll(tPreorder))
			isSubTree = true;
		
		return isSubTree;
		
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void preorder(TreeNode root, List tPreorder) {

		if(root != null) {
			System.out.print(root.getValue()+", ");
			if (tPreorder !=null) {
				tPreorder.add(root.getValue());
			}
			
			preorder(root.getLeft(),tPreorder);
			preorder(root.getRight(),tPreorder);
		}
	}

	private static void postOrder(TreeNode root) {
		if(root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getValue()+", ");
		}
		
	}

	private static TreeNode generateBinaryTree(TreeNode root) {
		return root;
	}

	/**
	 * generate a tree as below structure
	 *        3
	 *       /  \
	 *      4    5
	 *     / \   
	 *    1   2  
	 *    	 
	 * @param root
	 * @return
	 */
	private static TreeNode generateTree(TreeNode root) {
		
		root.setLeft(new TreeNode(4));
		root.setRight(new TreeNode(5));
		
//		root.getRight().setLeft(new TreeNode(4));
//		root.getRight().setRight(new TreeNode(5));
		
		root.getLeft().setLeft(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(2));
			
		return root;
	}
	
	/**
	 * generate a tree as below structure
	 *
	 *      4    
	 *     / \   
	 *    1   2  
	 *    	 
	 * @param root
	 * @return
	 */
	private static TreeNode generateSubTree(TreeNode root) {
		
		root.setLeft(new TreeNode(1));
		root.setRight(new TreeNode(2));
		
	
			
		return root;
	}
	
	/**
	 *  Root Left Right
	 * 
	 * @param root
	 */
	private static void preorder(TreeNode root) {
		preorder(root, null);
	}

	private static void inOrder(TreeNode root) {
		
		if(root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getValue()+", ");
			inOrder(root.getRight());
		}
	}
}

class TreeNode{
	
	protected TreeNode left;
	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	protected TreeNode right;
	int value;
	
	public TreeNode() {
		super();
	}
	
	public TreeNode(int val) {
		this();
		this.value= val;
	}
	
}
