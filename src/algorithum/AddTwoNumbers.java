package algorithum;

import java.util.Deque;
import java.util.LinkedList;

import util.ArrayUtils;
import util.ListNode;


/**
 *  https://leetcode.com/articles/add-two-numbers/
  
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit. 
    Add the two numbers and return it as a linked list.
	
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example:
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
	
 
 */

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		
//		int[] ary1 = {2,4,3};
//		int[] ary2 = {5,6,4};
		
		int[] ary1 = {1,8};
		int[] ary2 = {0};
		
		ListNode head1 = ArrayUtils.getListHeadByArray(ary1);
		ListNode head2 = ArrayUtils.getListHeadByArray(ary2);
		
		ListNode head = new AddTwoNumbers().addTwoNumbers1(head1, head2);
		
		ArrayUtils.printOutList(head, "Added List: ");
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummyHead = new ListNode(0);
		
		ListNode p = l1, q = l2, curr = dummyHead;
		
		int carry = 0;
		
		while (p != null || q != null) {
			
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			
			int sum = carry + x + y;
			carry = sum / 10;
			
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			
			if (p != null)
				p = p.next;
			
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
	
	/**
	 * 根据explanation 倒序相加，得到结果
	 * 342 + 465 = 807
	 * 返回倒序链表7-0-8
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		
		
		Deque<ListNode> stack1 = new LinkedList<>();
		Deque<ListNode> stack2 = new LinkedList<>();
		
		while(l1!=null) {
			stack1.push(l1);
			l1 = l1.next;
		}
		
		while(l2!=null) {
			stack2.push(l2);
			l2 = l2.next;
		}
		
		int carry = 0;
		ListNode cur = new ListNode(0);
		ListNode head = cur;
		
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
			int v1 = stack1.isEmpty()? 0:stack1.pop().val;
			int v2 = stack2.isEmpty()? 0:stack2.pop().val;
			
			ListNode node = new ListNode((v1+v2+carry)%10);
			
			cur.next = node;
			cur = cur.next;
			carry = (v1+v2+carry)>= 10? 1:0;
		}
		return head;
	}
}


