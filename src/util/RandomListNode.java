package util;

public class RandomListNode implements Node {

	public int label;
	
	public RandomListNode next, random;
	
	public RandomListNode(int x) {
		this.label = x; 
	}

	@Override
	public Node getNext() {
		return next;
	}

	@Override
	public Node getRandom() {
		return random;
	}

	@Override
	public int getValue() {
		return label;
	}
	
}
