package algorithum;

import util.ArrayUtils;
import util.ListNode;

public class DeleteNodeInLinkedList {

	public static void main(String[] args) {
		
		int[] ary = {4,5,1,9};
		
		ListNode head = ArrayUtils.getListHeadByArray(ary);	
		
		ListNode deListNode = head.next.next;
		
		deleteNode(deListNode);
		
		ArrayUtils.printOutList(head);

	}

	private static void deleteNode(ListNode node) {
		
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
}
