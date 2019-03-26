package util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import algorithum.BinaryTreeTranverse;

public class ArrayUtils {

	public static void printArray(int[] array, String info) {
		System.out.print(info + " {");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	/**
	 * @param array
	 */
	public static void printArray(int[] array) {
		printArray(array, "");
	}

	/**
	 * create LinkedList by integer array
	 * 
	 * @param array
	 * @return LinkedList<ListNode>
	 */
	public static LinkedList<ListNode> generateLinkedListByArray(int[] array) {

		LinkedList<ListNode> linkedList = new LinkedList<ListNode>();

		for (int intVal : array) {
			ListNode node = new ListNode(intVal);
			linkedList.offer(node);
		}

		for (int j = 1; j < linkedList.size(); j++) {
			linkedList.get(j - 1).next = linkedList.get(j);
		}

		StringBuffer sb = new StringBuffer();
		for (ListNode node : linkedList) {
			sb.append(node.val + "(nextVal:" + (node.next != null ? node.next.val : "none") + ")  ->  ");
		}
		System.out.println(sb.substring(0, sb.toString().length() - 4));

		return linkedList;
	}
	
	public static ListNode getListHeadByArray(int[] array) {
		
		System.out.println("generate list:");

		LinkedList<ListNode> linkedList = new LinkedList<ListNode>();

		for (int intVal : array) {
			ListNode node = new ListNode(intVal);
			linkedList.offer(node);
		}

		for (int j = 1; j < linkedList.size(); j++) {
			linkedList.get(j - 1).next = linkedList.get(j);
		}

		StringBuffer sb = new StringBuffer();
		for (ListNode node : linkedList) {
			sb.append(node.val+"->");
		}
		System.out.println(sb.substring(0, sb.toString().length() - 2));

		return linkedList.getFirst();
	}
	
	public static LinkedList<RandomListNode> generateRandomListByArray(int[] array) {

		LinkedList<RandomListNode> linkedList = new LinkedList<RandomListNode>();
		// create list;
		for (int intVal : array) {
			RandomListNode node = new RandomListNode(intVal);
			linkedList.offer(node);
		}
		// create next reference
		for (int j = 1; j < linkedList.size(); j++) {
			linkedList.get(j - 1).next = linkedList.get(j);
		}
		//create random domain
		for (int j = 1; j < linkedList.size(); j++) {
			linkedList.get(j - 1).random = linkedList.get(j);
		}
		
		
		StringBuffer sb = new StringBuffer();
		for (RandomListNode node : linkedList) {
			sb.append(node.label + "(random:" + (node.random != null ? node.next.label : "none") + ")  ->  ");
		}
		System.out.println(sb.substring(0, sb.toString().length() - 4));

		return linkedList;
	}


	
	/**
	 * @param linkedList
	 */
	public static void printOutLinkedList(LinkedList<ListNode> linkedList) {
		StringBuffer sb = new StringBuffer();
		for (ListNode node : linkedList) {
			sb.append(node.val + "(nextVal:" + (node.next != null ? node.next.val : "none") + ")  ->  ");
		}
		System.out.println(sb.substring(0, sb.toString().length() - 4));
	}
	
	
	/**
	 * @param linkedList
	 */
	public static void printLinkedList(ListNode node) {
		StringBuffer sb = new StringBuffer();
		while(node.next != null) {
			sb.append(node.val+"(nextVal:"+(node.next != null? node.next.val : "none")+")  ->  ");
			node = node.next;
		}
		System.out.println(sb.substring(0, sb.toString().length()-4));
	}
	
    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     * 
     * Example:
     * 
     *   int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
     * 
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
	public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
		if (index < array.length) {
			int value = array[index];
			if (value != 0) {
				TreeNode t = new TreeNode(value);
				array[index] = 0;
				t.left = makeBinaryTreeByArray(array, index * 2);
				t.right = makeBinaryTreeByArray(array, index * 2 + 1);
				return t;
			}
		}
		return null;
	}
	
	/**
	 * 
	 *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   / \
     *           22   4 28 32  0
     *           
	 * int[] arr={null,13,65,5,97,25,null,37,22,null,4,28,0,0,32,0};
	 * 
	 * @param array
	 * @param index
	 * @return
	 */
	public static TreeNode makeBinaryTreeByArray(Integer[] array, int index) {
		if (index < array.length) {
			Integer value = array[index];
			if (value != null) {
				TreeNode t = new TreeNode(value);
				array[index] = 0;
				t.left = makeBinaryTreeByArray(array, index * 2);
				t.right = makeBinaryTreeByArray(array, index * 2 + 1);
				return t;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0 };
		TreeNode root = makeBinaryTreeByArray(arr, 1);
		System.out.println(root.value);
	}

	public static void printOutList1(Node node) {
		StringBuffer sb = new StringBuffer();
		while(node != null) {
			sb.append(node.getValue()+"(Random val:"+(node.getRandom() != null? node.getRandom().getValue() : "none")+")  ->  ");
			node = node.getNext();
		}
		System.out.println(sb.substring(0, sb.toString().length()-4));
		
	}
	
	public static void printOutList(Node node) {
		printOutList(node,"");
		
	}
	public static void printOutList(Node node, String info) {
		if(!info.equals(""))
			System.out.println(info);
		StringBuffer sb = new StringBuffer();
		while(node != null) {
			sb.append(node.getValue()+"->");
			node = node.getNext();
		}
		System.out.println(sb.substring(0, sb.toString().length()-2));
		
	}
	
	/**
	 * print out tree in level order
	 * @param root
	 */
	public static void printOutTree(TreeNode root) {
		printOutTree(root,"");
	}

	public static void printMatrix(int[][] matrix, String hint) {
		
		System.out.println(hint);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
	}

	public static void printOutTree(TreeNode root, String info) {
		if(info != null && !info.equals("")) 
			System.out.println(info);
		System.out.println(BinaryTreeTranverse.levelOrderList(root));
	}

}
