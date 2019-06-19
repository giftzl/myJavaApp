package algorithum;

import util.ArrayUtils;
import util.ListNode;

public class InsertSortList {

	public static void main(String[] args) {
		// insert sort array
//		int[] ary = { 5, 1, 3, 7, 2, 9 ,6, 4};
//		insertSortAry(ary);
//		ArrayUtils.printArray(ary, "insert sort:");

		// insert sort list
		int[] ary1 = { 5, 1, 3, 7, 2, 9 ,6, 4};
		ListNode l = ArrayUtils.getListHeadByArray(ary1);
		ListNode head = insertionSortList(l);
		ArrayUtils.printOutList(head,"After Sort:");

	}

	public static void insertSortAry(int[] nums) {

		// begin from the second element, assure element ahead is already sorted.
		for (int i = 1; i < nums.length; i++) {
			int insertVal = nums[i];
			int j = i - 1;
			for (; j >= 0 && insertVal < nums[j]; j--) {
				// move backward the sorted array
				nums[j + 1] = nums[j];
			}
			nums[j + 1] = insertVal;
		}

	}

	/**
	 *  list: 5->1->3->7->2->9->64
	 *  
	 *  BASIC IDEA: insert curr between p and p.next
	 */
	public static ListNode insertionSortList(ListNode head) {
		ListNode curr = head, next = null;
		  // l is a fake head
		  ListNode l = new ListNode(0);
		  
		  while (curr != null) {
		    next = curr.next;
		    
		    ListNode p = l;
		    while (p.next != null && p.next.val < curr.val)
		      p = p.next;
		    
		    //when cur.val < p.val,then insert curr between p and p.next,
		    // p->cur->p.next;
		    curr.next = p.next;
		    p.next = curr;
		    
		    curr = next;
		  }
		  
		  return l.next;
		

	}
}
