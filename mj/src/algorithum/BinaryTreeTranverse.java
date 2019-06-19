package algorithum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.ArrayUtils;
import util.TreeNode;

public class BinaryTreeTranverse {
 

    public TreeNode root;

    public BinaryTreeTranverse(int[] array){
        root=ArrayUtils.makeBinaryTreeByArray(array,1);
    }
    
    public BinaryTreeTranverse(TreeNode root) {
    	this.root = root;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }       
        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        stack.push(root);       
        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();
            System.out.print(node.value+"    ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }           
        }
        System.out.print("\n");
    }


    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            TreeNode node=queue.poll();
            System.out.print(node.value+"    ");
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        System.out.print("\n");
    }
    
	/**
	 * 二叉树中序遍历递归实现
	 * 左 - 根 - 右
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		return _inOrderTrans(root, list);
	}
	
	/**
	 * 二叉树前序遍历递归实现
	 * 根 - 左 - 右
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		return _preOrderTrans(root, list);
	}
	
	/**
	 * 二叉树前序遍历递归实现
	 *  左 - 右 - 根
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		return _postOrderTrans(root, list);
	}
    
	 private List<Integer> _preOrderTrans(TreeNode root, List<Integer> list) {
	    	if(root == null)
	    		return list;
	    	list.add(root.value);
	    	_preOrderTrans(root.left, list);
	    	_preOrderTrans(root.right, list);
			return list;
		}
    
    private List<Integer> _postOrderTrans(TreeNode root, List<Integer> list) {
    	if(root == null)
    		return list;
    	_postOrderTrans(root.left, list);
    	_postOrderTrans(root.right, list);
    	list.add(root.value);
		return list;
	}
    
    /**
     *  left - root - right
     * @param root
     * @param list
     * @return List<Integer>
     */
    private List<Integer> _inOrderTrans(TreeNode root, List<Integer> list) {
    	if(root == null)
    		return list;
    	
    	_inOrderTrans(root.left, list);
    	list.add(root.value);
    	_inOrderTrans(root.right, list);
		return list;
	}

	/**
	 *  Binary Tree:      Return ZigZag: every level is a list
	 *      3             [ [3],
		   / \              [20,9],
		  9  20             [15,7]
		    /  \          ]
		   15   7
	 *
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean order = true;
		int size = 1;

		while (!q.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				TreeNode n = q.poll();
				if (order) {
					tmp.add(n.value);
				} else {
					tmp.add(0, n.value);
				}
				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
			}
			res.add(tmp);
			size = q.size();
			order = order ? false : true;
		}
		return res;
	}

	/**
	 *  Binary Tree:     Return level-order list
	 *      3             [ [3],
		   / \              [9, 20],
		  9  20             [7,15]
		    /  \          ]
		   15   7
	 *
	 */
	public static List<List<Integer>> levelOrderList(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> q = new LinkedList<>();
		
		if(root == null)
			return res;
		
		int size = 1;
		q.offer(root);
		while(!q.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i< size; i++) {
				TreeNode node = q.poll();
				temp.add(node.value);
				if(node.left != null)
					q.offer(node.left);
				if(node.right != null)
					q.offer(node.right);
			}
			size=q.size();
			res.add(temp);
		}
		return res;
	}
	
	
	/** 
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTreeTranverse tree=new BinaryTreeTranverse(arr);
        tree.depthOrderTraversal();
        tree.levelOrderTraversal();
        
        System.out.println("InOrder traverse: "+tree.inorderTraversal(tree.root).toString());
        System.out.println("PreOrder traverse: "+tree.preorderTraversal(tree.root).toString());
        System.out.println("PostOrder traverse: "+tree.postorderTraversal(tree.root).toString());
        
        System.out.println("Zigzag level order:" +tree.zigzagLevelOrder(tree.root));
        System.out.println("Level order with list:"+ levelOrderList(tree.root));
       
    }
}