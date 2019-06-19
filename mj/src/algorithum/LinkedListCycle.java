package algorithum;

import java.util.LinkedList;

import util.ArrayUtils;
import util.ListNode;

public class LinkedListCycle {
	
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,7,8};
		
		LinkedList<ListNode> list = ArrayUtils.generateLinkedListByArray(array);
		
		if(list.getLast().next == null) {
			System.out.println( "set loop to "+list.peekLast().val+" to"+list.peekFirst().val);
			list.getLast().next = list.getFirst();
		}
		printOutList(list);
		
		LinkedListCycle test = new LinkedListCycle();
		boolean hasCycle = test.hasCycle(list.getFirst());
		
		System.out.println("the list "+(hasCycle ?"has":"hasn't")+" cycle");
	
		
		
	}
	
	private static void printOutList(LinkedList<ListNode> list) {
		StringBuffer sb = new StringBuffer();
		for (ListNode node : list) {
			sb.append(node.val+"(nextVal:"+(node.next != null? node.next.val : "none")+")  ->  ");
		}
		System.out.println(sb.substring(0, sb.toString().length()-4));
		
	}


	   public boolean hasCycle(ListNode head) {
		   boolean looped = false;
		   
		   ListNode fast = head;
		   ListNode slow = head;
		   
		   while(fast != null && fast.next!= null) {
			   fast = fast.next.next;
			   slow = slow.next;
			   
			   if(fast == slow) {
				   looped = true;
				   break;
			   }
				   
		   }
		   
		   return looped;
	   }
}
