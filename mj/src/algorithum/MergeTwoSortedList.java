package algorithum;

import java.util.LinkedList;

import util.ArrayUtils;
import util.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 
 * 
 * Output: 1->1->2->3->4->4
 * 
 * @author vivianzhu
 *
 */
public class MergeTwoSortedList {

	public static void main(String[] args) {
		
		int[] ary1 = {1,2,4};
		int[] ary2 = {1,3,4};
		
		LinkedList<ListNode> list1 = ArrayUtils.generateLinkedListByArray(ary1);
		LinkedList<ListNode> list2 = ArrayUtils.generateLinkedListByArray(ary2);
		
		ListNode node = mergeTwoLists(list1.getFirst(), list2.getFirst());
		
		ArrayUtils.printOutList(node);

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while(l1 !=null && l2 !=null) {
			if(l1.val <= l2.val) {
				cur.next = l1;
				l1 =l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		
		while(l1 != null) {
			cur.next = l1;
			cur = cur.next;
			l1 = l1.next;
		}
		
		while(l2 != null) {
			cur.next = l2;
			cur = cur.next;
			l2 = l2.next;
		}
		
		return dummy.next;
	}

}
