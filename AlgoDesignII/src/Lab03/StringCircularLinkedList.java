package Lab03;
//Jake Powers
public class StringCircularLinkedList {
	private class ListNode {
		private String data;
		private ListNode link;
		public ListNode (String xData, ListNode xLink) {
			data = xData;
			link = xLink;
		}
	}
	
	private ListNode head;
	private ListNode curr;
	private ListNode prev;
	private ListNode tail;
	private ListNode temp;
	
	public StringCircularLinkedList() {
		head = tail  = curr = temp = null;
	}
	public void gotoNext() {
		if (curr == null) {
			curr = head;
			prev = tail;
			return;
		}
		prev = curr;
		curr = curr.link;
	}
	public void goToPrev() {
		if (curr == null)
			return;
		else if (curr != null && prev == null) {
			curr = head;
			prev = tail;
			return;
		}
		else if (curr != null && prev != null) {
			curr = prev;
			prev = head;
			while (prev.link != curr) {
				prev = prev.link;
			}
			return;
		}
	}
	public String getDataAtCurr() {
		if (curr != null)
			return curr.data;
		return null;
	}
	public void setDataAtCurr(String xData) {
		if (curr != null)
			curr.data = xData;
		return;
	}
	public void insert(String xData) {
		if (head == null) {
			ListNode newNode = new ListNode(xData, null);
			head = tail = curr = newNode;
			return;
		}
		else {
			ListNode newNode = new ListNode(xData, null);
			tail.link = newNode;
			tail = newNode;
			tail.link = head;
		}
		
	}
	public void insertAfterCurr(String xData) {
		ListNode newNode = new ListNode(xData,null);
		if (curr == null)
			return;
		prev = curr;
		curr.link = newNode;
		curr = newNode;
		if (curr.link == null) {
			newNode.link = head;
			newNode = tail;
		}
			
	}
	public void deleteCurrent() {
		if (curr != null && prev != null) {
			prev.link = curr.link;
			curr = curr.link;
		}
		else if (curr != null && prev == null)
			head = curr;
		return;
	}
	public void print() {
		curr = head;
		if (curr == null)
			return;
		while (curr != tail) {
			System.out.println(curr.data);
			this.gotoNext();
		}
		curr = prev.link;
		System.out.println();
	}
	public boolean isInList(String xData) {
		curr = head;
		while (curr != tail) {
			if (curr.data .equals(xData)) 
				return true;
			this.gotoNext();
		}
		curr = prev.link;
		return false;
	}
}
