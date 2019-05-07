package algorithum;

import java.util.ArrayList;
import java.util.List;

import util.ArrayUtils;
import util.ListNode;

/**
	 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
	
	Example:
	
	Input:
	[
	  1->4->5,
	  1->3->4,
	  2->6
	]
	
	
	Output: 1->1->2->3->4->4->5->6
	
 */
public class MergeKSortedList {
	
	public static ListNode mergeKLists(ListNode[] lists) {
		return partion(lists, 0, lists.length - 1);
	}

	public static ListNode partion(ListNode[] lists, int start, int end) {
		if (start == end)
			return lists[start];
		if (start < end) {
			int mid = (start + end) / 2;
			ListNode l1 = partion(lists, start, mid);
			ListNode l2 = partion(lists, mid + 1, end);
			return merge(l1, l2);
		} else
			return null;
	}

	// This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		
		List<ListNode>  lists = new ArrayList<>();

		int[] ary1 = {1,4,5};
		int[] ary2 = {1,3,4};
		int[] ary3 = {2,6};
		
		lists.add(ArrayUtils.getListHeadByArray(ary1));
		lists.add(ArrayUtils.getListHeadByArray(ary2));
		lists.add(ArrayUtils.getListHeadByArray(ary3));
		
		ListNode[] nodes = lists.toArray(new ListNode[0]);
		
		ListNode rs = mergeKLists(nodes);
		
		ArrayUtils.printOutList(rs, "Merged List:");
		
		
	}
}
