package algorithum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 *   Traverse tree
 * 	
 
		  	    Hello
		    /     |    \
		 This  pretty  world
		 / \
	   is   a
	         \
	      wonderful
 * 
 *
 */
public class TreeTranverse {
	
	public static void main(String[] args) {
		
		TreeNode root = generateTree();
		
		dsfTraverse(root);
		System.out.println("");
		
		dsfTransRecursive(root);
		System.out.println("");
		
		bsfTraverse(root);
		System.out.println("");
		
	}


	private static void bsfTraverse(TreeNode root) {
		if(root == null)
			return;
		
		
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.label+" ");
			for(int i = 0; i<node.children.size(); i++) {
				queue.offer(node.children.get(i));
			}
		}
	}

	private static void dsfTraverse(TreeNode root) {
		if(root == null) {
			System.out.println("Empty Tree!");
			return;
		}
		
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.label+" ");
			
			for(int i = node.children.size()-1; i>=0; i--) {
				stack.push(node.children.get(i));
			}
		}
	}
	
	private static void dsfTransRecursive(TreeNode root) {
		if(root == null)
			return;
		
		System.out.print(root.label+" ");
		
		for(int i = 0; i<root.children.size(); i++) {
			dsfTransRecursive(root.children.get(i));
		}
	}

	private static TreeNode generateTree() {
		
		TreeNode root = new TreeNode("Hello");
		TreeNode c1 = new TreeNode("this");
		TreeNode c2 = new TreeNode("pretty");
		TreeNode c3 = new TreeNode("world");
		TreeNode c11 = new TreeNode("is");
		TreeNode c12 = new TreeNode("a");
		TreeNode c122= new TreeNode("wonderful");
		
		root.children.add(c1);
		root.children.add(c2);
		root.children.add(c3);
		
		c1.children.add(c11);
		c1.children.add(c12);
		c12.children.add(c122);
		
		return root;
	}
}


class TreeNode{
	
	String label;
	int val;
	
	List<TreeNode> children = new ArrayList<TreeNode>();
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public TreeNode(String label) {
		this.label = label;
	}
}