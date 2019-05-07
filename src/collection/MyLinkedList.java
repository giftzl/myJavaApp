package collection;
public class MyLinkedList {
	
	private class Data{
		private Object obj;
		private Data next = null;
		
		public Data getNext() {
			return next;
		}

		public void setNext(Data next) {
			this.next = next;
		}

		Data(Object obj){
			this.obj = obj;
		}
	}
	
	private Data first = null;
	
	
	
	
	private Data reverseList(Data head) {
		// head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
				if (head == null || head.getNext() == null) {
					return head;// 若为空链或者当前结点在尾结点，则直接还回
				}
				Data reHead = reverseList(head.getNext());// 先反转后续节点head.getNext()
				head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
				head.setNext(null);// 前一结点的指针域令为null;
				return reHead;// 反转后新链表的头结点
	}
	
	public void insertFirst(Object obj){
		Data data = new Data(obj);
		data.next = first;
		first = data;
	}
	
	public Object deleteFirst() throws Exception{
		if(first == null)
			throw new Exception("empty!");
		Data temp = first;
		first = first.next;
		return temp.obj;
	}
	
	public Object find(Object obj) throws Exception{
		if(first == null)
			throw new Exception("LinkedList is empty!");
		Data cur = first;
		while(cur != null){
			if(cur.obj.equals(obj)){
				return cur.obj;
			}
			cur = cur.next;
		}
		return null;
	}
	
	public void remove(Object obj) throws Exception{
		if(first == null)
			throw new Exception("LinkedList is empty!");
		if(first.obj.equals(obj)){
			first = first.next;
		}else{
			Data pre = first;
			Data cur = first.next;
			while(cur != null){
				if(cur.obj.equals(obj)){
					pre.next = cur.next;
				}
				pre = cur;
				cur = cur.next;
			}
		}
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void display(){
		if(first == null)
			System.out.println("empty");
		Data cur = first;
		while(cur != null){
			System.out.print(cur.obj.toString() + " -> ");
			cur = cur.next;
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) throws Exception {
		MyLinkedList ll = new MyLinkedList();
		ll.insertFirst(4);
		ll.insertFirst(3);
		ll.insertFirst(2);
		ll.insertFirst(1);
		ll.display();
		ll.reverseList(ll.first);
		ll.display();
		
//		ll.deleteFirst();
//		ll.display();
//		ll.remove(3);
//		ll.display();
//		System.out.println(ll.find(1));
//		System.out.println(ll.find(4));
//		
		
	}
}
