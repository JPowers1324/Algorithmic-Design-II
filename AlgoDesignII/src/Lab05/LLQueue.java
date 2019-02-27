package Lab05;
//Jake Powers
public class LLQueue<T> {
	public class ListNode {
		private T data;
		private ListNode link;
		public ListNode() {
			data = null;
			link = null;
		}
		public ListNode(T xData, ListNode xLink) {
			data = xData;
			link = xLink;
		}
	}
	private ListNode head;
	private ListNode tail;
	
	public LLQueue() {
		head = tail = null;
	}
	
	public void enqueue(T xData) { //Adding new node to queue
		ListNode newNode = new ListNode(xData,null);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}
	public T dequeue() { //Removing first node in queue
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}
	public T peek() { //Check first node in queue
		return head.data;
	}
	public void print() { //Print all nodes in queue
		for (ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
}
