package algorithum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import util.ArrayUtils;
import util.RandomListNode;

public class CopyRandomList {
	
	public static void main(String[] args) {
		
		int[] array = {1,5,7,9,3};
		
		LinkedList<RandomListNode> list = ArrayUtils.generateRandomListByArray(array);
		RandomListNode node = copyRandomList(list.getFirst());
		
		ArrayUtils.printOutList(node);

		
	}
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		
		if(head == null)
			return null;
		
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		
		RandomListNode node = head;
		
		// copy node
		while(node != null) {
			map.put(node, new RandomListNode(node.label));
			node= node.next;
		}
	       
		//copy next and random
		node = head;
		while(node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}
		return map.get(head);
	        
	}

}
