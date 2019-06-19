package algorithum;

import java.util.LinkedList;

import util.ArrayUtils;
import util.ListNode;

public class PalindromList {
	
	public static void main(String[] args) {
		
		PalindromList test = new PalindromList();
		
		LinkedList<ListNode> list= test.generateLinkedList();
		
//		int[] array = {1,2,3,6,3,2,1};
		int[] array = {1,4,3,5,6,6,4,3,1,2};
		LinkedList<ListNode> aryList= test.generateLinkedListByArray(array);
		
		boolean isPalindrom = test.isPalindrome(aryList.peekFirst());
		System.out.println((isPalindrom?" is":" isn't" ) +" a plindrome");
		
	}

	private LinkedList<ListNode> generateLinkedListByArray(int[] array) {

		LinkedList<ListNode> linkedList = new LinkedList<ListNode>();
		
		for (int intVal : array) {
			ListNode node = new ListNode(intVal);
			linkedList.offer(node);
		}
		
		for(int j=1;j<linkedList.size();j++) {
			linkedList.get(j-1).next = linkedList.get(j);
		}
		
		ArrayUtils.printOutLinkedList(linkedList);
		
		return linkedList;
	}



	private boolean isPalindrome(ListNode head) {
		boolean isPalindrome = true;
		ListNode fast = head;
		ListNode slow = head;
		while(fast !=null && fast.next != null) {
			fast = fast.next.next;  // move 2step every time
			slow = slow.next; //move 1 step every time
		}
		if(fast!= null) { 
			// odd number collection, make left half smaller
			slow = slow.next;		
		}
		
		slow = reverseList(slow);
		fast = head;
		
		while(fast.next != null && slow.next != null) {
			if(fast.val != slow.val) {
				isPalindrome = false;
				break;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return isPalindrome;
		
	}

	private ListNode reverseList(ListNode slow) {
		if(slow == null || slow.next == null)
			return slow;
		
		ListNode rh = reverseList(slow.next);
		slow.next.next = slow;
		slow.next = null;
		return rh;
	}

	private LinkedList<ListNode> generateLinkedList() {
		
		LinkedList<ListNode> linkedList = new LinkedList<ListNode>();
		
		for(int i =1; i< 10; i+=2) {
			ListNode node = new ListNode(i);
			linkedList.offer(node);
		}
		
		for(int j=1;j<linkedList.size();j++) {
			linkedList.get(j-1).next = linkedList.get(j);
		}
		
		ArrayUtils.printOutLinkedList(linkedList);
		
		return linkedList;
	}

}
