package util;

public class ListNode implements Node{
	
    public int val;
    
    public ListNode next;
   
    
    public ListNode(int x) {
    	val = x; 
    }


	@Override
	public Node getNext() {
		return next;
	}


	@Override
	public Node getRandom() {
		return null;
	}


	@Override
	public int getValue() {
		return val;
	}
    
    

}
