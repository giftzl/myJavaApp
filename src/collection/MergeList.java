package collection;

import java.util.LinkedList;

import util.ArrayUtils;
import util.ListNode;

public class MergeList {
	
	public static void main(String[] args) {
		
		int[] ary1 = {1,4,7};
		int[] ary2 = {1,3,6};
		
	    LinkedList<ListNode> l1 = ArrayUtils.generateLinkedListByArray(ary1);
	    LinkedList<ListNode> l2 = ArrayUtils.generateLinkedListByArray(ary2);
	    
	    MergeList solution = new MergeList();
	    ListNode rs = solution.mergeTwoList(l1.getFirst(), l2.getFirst());
	    ArrayUtils.printLinkedList(rs);
	  
		
	}
	
	/**
	 * @param l1
	 * @param l2
	 * @return ListNode
	 */
	public ListNode mergeTwoList(ListNode l1, ListNode l2) {
		
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		// construct new list
		ListNode head ;
		if(l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
		}else {
			head = l2;
			l2= l2.next;
		}
		
		ListNode cur = head;
		
		// re-sort 
		while(l1 != null && l2!= null) {
			if(l1.val <=l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		
		
		//add the rest of the element of both Lists
		cur.next = l1 == null ? l2:l1;
		return head;
	}

}
