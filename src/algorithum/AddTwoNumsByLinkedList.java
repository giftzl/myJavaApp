package algorithum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import util.ArrayUtils;
import util.ListNode;

public class AddTwoNumsByLinkedList {
	
	public static void main(String[] args) {
		
		int[] ary1 = {7,2,4,3};
		int[] ary2 = {5,6,4};
		
		LinkedList<ListNode> list1 = ArrayUtils.generateLinkedListByArray(ary1);
		LinkedList<ListNode> list2 = ArrayUtils.generateLinkedListByArray(ary2);
		ListNode sum = addTwoNumbers(list1.getFirst(), list2.getFirst());
//		
		while(sum!=null) {
			System.out.print(sum.val+"->");
			sum = sum.next;
		}
		System.out.print("none");
		System.out.println("");
		
		
		ListNode sum2 = addTwoNumbersReverse(list1.getFirst(), list2.getFirst());
		while(sum2!=null) {
			System.out.print(sum2.val+"->");
			sum2 = sum2.next;
		}
		System.out.print("none");
	}
	

	/**
	 * 
	 * 
	 * 从左到右相加进位. 正序需要dummy/cur 两个指针.
	 * 
	 * Input: (2 -> 6 -> 3) + (5 -> 6 -> 4) 
	 * Output: 7 -> 2 -> 8 
	 * 
	 * @param l1
	 * @param l2
	 * @return ListNode
	 */
	private static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
			Deque<ListNode> s1 = new ArrayDeque<ListNode>();
			Deque<ListNode> s2 = new ArrayDeque<ListNode>();
	        
	        while(l1!=null){
	            s1.offer(l1);
	            l1 = l1.next;
	        }
	        
	        while(l2 !=null){
	            s2.offer(l2);
	            l2 = l2.next;
	        }
	        
	        int carry = 0;
	        ListNode dummy = new ListNode(-1);
	        ListNode cur = dummy;
	        
	        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){
	            int v1 = s1.isEmpty()?0:s1.poll().val;
	            int v2 = s2.isEmpty()?0:s2.poll().val;
	            
	            int sum = v1+v2+carry;
	            
	            ListNode newNode = new ListNode(sum%10);
	            cur.next = newNode;
	            cur = cur.next;
	            carry = sum/10;
	        }
	        return dummy.next;
	}

	/**
	 * 反序借助栈。逐一相加进位，反向输出。
	 * newNode.next = dummy
	 * dummy = newNode;
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
	 * Output: 7 -> 0 -> 8 
	 * Explanation: 342 + 465 = 807.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		   Stack<ListNode> l1Stack = new Stack<>();
	        
	        while(l1 != null) {
	            l1Stack.push(l1);
	            l1 = l1.next;
	        }
	        
	        Stack<ListNode> l2Stack = new Stack<>();
	        
	        while(l2 != null) {
	            l2Stack.push(l2);
	            l2 = l2.next;
	        }
	        
	        int carry = 0;
	        ListNode dummy = null;
	        
	        while(!l1Stack.isEmpty() || !l2Stack.isEmpty() ||  carry != 0) {
	            int f = l1Stack.isEmpty() ? 0 : l1Stack.pop().val;
	            int s = l2Stack.isEmpty() ? 0 : l2Stack.pop().val;
	            
	            int t = f + s + carry;
	            
	            ListNode newNode = new ListNode(t % 10);
	            
	            newNode.next = dummy;
	            dummy = newNode;
	            carry = t/10;
	            
	        }
	        
	        return dummy;
	
	}
}
