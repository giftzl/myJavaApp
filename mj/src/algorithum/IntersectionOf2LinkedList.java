package algorithum;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class IntersectionOf2LinkedList {
	
	public static void main(String[] args) {
		
		String[] a = {"a1","a2","a3","c1","c2","c3"};
		LinkedList<StrNode> listA = generateLinkedListByString(a);
		
		String[] b = {"b1","b2","b3","c1","c2","c3"};
		LinkedList<StrNode> listB = generateLinkedListByString(b);
		
		StrNode node = getIntersectionNode(listA.peekFirst(),listB.peekFirst());

		System.out.println(node.val);
		
		
	}

	
	private static StrNode getIntersectionNode(StrNode headA, StrNode headB) {
		
		StrNode insectNode = null;
		
		Set<String> setA = new HashSet<String>();
		
		while(headA != null) {
			setA.add(headA.val);
			headA = headA.next;
		}
		while(headB != null) {
			if(setA.contains(headB.val)) {
				insectNode = headB;
				break;
			}
			headB = headB.next;
			
		}
		return insectNode;
	}


	private static LinkedList<StrNode> generateLinkedListByString(String[] array) {

		LinkedList<StrNode> linkedList = new LinkedList<StrNode>();
		
		for (String str : array) {
			StrNode node = new StrNode(str);
			linkedList.offer(node);
		}
		
		for(int j=1;j<linkedList.size();j++) {
			linkedList.get(j-1).next = linkedList.get(j);
		}
		
		StringBuffer sb = new StringBuffer();
		for (StrNode node : linkedList) {
			sb.append(node.val+"(nextVal:"+(node.next != null? node.next.val : "none")+")  ->  ");
		}
		System.out.println(sb.substring(0, sb.toString().length()-4));
		
		return linkedList;
	}

}

class StrNode {
    String val;
    StrNode next;
    StrNode(String x) { val = x; }
 }
