package Homework02;

//Jake Powers
public class GenLLCirc <T> {
    private class ListNode {
        private T data;
        private ListNode link;
        public ListNode(T xData, ListNode xLink) {
            data = xData;
            link = xLink;
        }
    }
    private ListNode head; //points to first item
    private ListNode tail; //points to last item
    private ListNode curr; //points to item of interest
    private ListNode prev; //One behind current
    private int size;
    public GenLLCirc() {
        head = curr = prev = tail = null;
         
    }
    public T getCurrent() {
        if (curr != null)
            return curr.data;
        return null;
    }
    public void printCurrent() {
    	if (curr != null)
    		System.out.println(curr.data);
    }
    public void setCurrent(T xData) {
        if (curr != null)
            curr.data = xData;
    }
    public void gotoNext() {
        if (curr == null)
            return;
        if (curr == tail) {
        	curr = head;
        	prev = tail;
        	return;
        }
        prev = curr;
        curr = curr.link;
    }
    public void resetCurrent() {
        curr = head;
        prev = tail;
    }
    public boolean hasMore() {
        return curr != tail;
    }
    public void insert(T xData) {
        ListNode newNode = new ListNode(xData, null);
        if (head == null) {
            head = tail = newNode;
            tail.link = head;
            curr = head;
            size = 1;
            return;
        }
        tail.link = newNode;
        tail = newNode;
        tail.link = head;
        size += 1;
    }
    public void insertafterCurrent(T xData) {
        if (curr == null)
            insert(xData);
        ListNode newNode = new ListNode(xData, curr.link);
        if (curr == tail) {
        	curr.link = tail = newNode;
        	tail.link = head;
        	size+=1;
        	return;
        }
        curr.link = newNode;
    }
    public void deleteCurrent() {
    	if (curr != null && prev != null) {
            prev.link = curr.link;
            curr = curr.link;
            size --;
        }
        else if (curr == head) { // curr is at the head
            head = head.link;
            tail.link = head;
            curr = head;
            size --;
        }
        else if (curr == tail) {
        	prev.link = head;
        	prev = tail;
        	curr = head;
        	size--;
        }
    }
    public void print() {
        ListNode temp = head;
        while (temp.link != head) {
            System.out.println(temp.data);
            temp = temp.link;
        }
        System.out.println(tail.data);
    }
    public boolean isContained(T xData) {
        if (findnodeWith(xData) != null)
            return true;
        return false;
    }
    public void gotoItem(T xData) {
        ListNode temp = this.findnodeWith(xData);
        if (temp == null)
            return;
        this.resetCurrent();
        while(this.hasMore() && curr != temp)
            this.gotoNext();
    }
    private ListNode findnodeWith(T xData) {
        ListNode temp = head;
        while (temp != tail) {
            if (temp.data == xData) 
                return temp;
            temp = temp.link;
        }
        return null;
    }
    public int getSize() {
    	return this.size;
    }
}