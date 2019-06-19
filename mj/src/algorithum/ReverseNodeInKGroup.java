package algorithum;

import util.ArrayUtils;
import util.ListNode;

/**
 * 
 *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    k is a positive integer and is less than or equal to the length of the linked list. 
    
    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

	Example:
	
	Given this linked list: 1->2->3->4->5
	
	For k = 2, you should return: 2->1->4->3->5
	
	For k = 3, you should return: 3->2->1->4->5
	
	Note:
	
	Only constant extra memory is allowed.
	You may not alter the values in the list's nodes, only nodes itself may be changed.
	
 *
 */
public class ReverseNodeInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part,
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group:
				ListNode tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed list
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct part
			}
			head = curr;
		}
		return head;
	}

	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5};
		
		ListNode node = ArrayUtils.getListHeadByArray(array);
		
		ListNode reverseHead = new ReverseNodeInKGroup().reverseKGroup(node, 3);
		
		ArrayUtils.printOutList(reverseHead, "Reversed list as: ");
		
		

	}
}
