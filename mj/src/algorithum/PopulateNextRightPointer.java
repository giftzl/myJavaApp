package algorithum;

/**
       Given the following perfect binary tree,
		
		     1
		   /  \
		  2    3
		 / \  / \
		4  5  6  7
		
		
		After calling your function, the tree should look like:
		
		     1 -> NULL
		   /  \
		  2 -> 3 -> NULL
		 / \  / \
		4->5->6->7 -> NULL
		
 */
public class PopulateNextRightPointer {

	public void connect(TreeLinkNode root) {

		if (root == null)
			return;
		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null) {
				root.right.next = root.next.left;
			}
		}

		connect(root.left);
		connect(root.right);
	}
	
	public static void main(String[] args) {
		//TODO:
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}