package Lab04;
//Jake Powers
public class GenDoubleLinkedList <T>{
	 private class ListNode {
		 private T data;
		 private ListNode next;
		 private ListNode prev;
		 public ListNode(T xData, ListNode xNext, ListNode xPrev) {
			 data = xData;
			 next = xNext;
			 prev = xPrev;
		 }
	 }
	 private ListNode head;
	 private ListNode curr;
	 public GenDoubleLinkedList() {
		 head = curr = null;
	 }
	 
	 public void goToNext() {
		 if (curr.next == null) 
			 return;
		 curr = curr.next;
	 }
	 public void goToPrev() {
		 if (curr.prev == null)
			 return;
		 curr = curr.prev;
	 }
	 public T getDataAtCurrent() {
		 if (curr.data == null)
			 return null;
		 return curr.data;
	 }
	 public void setDataAtCurrent(T xData) {
		 if (curr == null)
			 return;
		 curr.data = xData;
	 }
	 public void insert(T xData) {
		 if (head == null) {
			 ListNode newNode = new ListNode(xData, null, null);
			 head = newNode;
			 curr = head;
			 return;
		 }
		 ListNode temp = head;
		 while (temp.next != null) {
			 temp.prev = temp;
			 temp = temp.next;
		 } 
		 ListNode newNode = new ListNode(xData, null, temp.prev);
		 newNode.prev = temp;
		 temp.next = newNode;
	 }
	 public void insertNodeAfterCurrent(T xData) {
		 if (curr ==  null)
			 insert(xData);
		 ListNode newNode = new ListNode(xData, curr.next, curr);
		 curr.next = newNode;
		 
		 /*
		 curr.next = newNode;
		 curr.next.next.prev = newNode; //curr => newNode => curr.next => curr.next(previous) assigned to newNode
		 */
	 }
	 public void deleteCurrentNode() {
		 curr.prev.next = curr.next;
		 curr.next.prev = curr.prev;
	 }
	 public void showList() {
		 if (head == null)
			 return;
		 ListNode temp = head;
		 while (temp != null) {
			 System.out.println(temp.data);
			 temp = temp.next;
		 }
	 }
	 public boolean inList(T xData) {
		 ListNode temp = head;
		 while (temp != null) {
			 if (temp.data == xData)
				 return true;
			 temp = temp.next;
		 }
		 return false;
	 }
}
