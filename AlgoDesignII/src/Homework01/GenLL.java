package Homework01;
//Jake Powers
public class GenLL <T> {
    private class ListNode {
        private T data;
        private ListNode link;
        public ListNode(T xData, ListNode xLink) {
            data = xData;
            link = xLink;
        }
    }
    private ListNode head; //points to first item
    private ListNode curr; //points to item of interest
    private ListNode prev; //One behind current
    public GenLL() {
        head = curr = prev = null;
         
    }
    public T getCurrent() {
        if (curr != null)
            return curr.data;
        return null;
    }
    public void printCurrent() {
    	if (curr != null)
    		System.out.println(curr.toString());
    }
    public void setCurrent(T xData) {
        if (curr != null)
            curr.data = xData;
    }
    public void gotoNext() {
        if (curr == null)
            return;
        prev = curr;
        curr = curr.link;
    }
    public void resetCurrent() {
        curr = head;
    }
    public boolean hasMore() {
        return curr != null;
    }
    public void insert(T xData) {
        ListNode newNode = new ListNode(xData, null);
        if (head == null) {
            head = newNode;
            curr = head;
            return;
        }
        ListNode temp = head;
        while (temp.link != null)
            temp = temp.link;
        temp.link = newNode;
    }
    public void insertafterCurrent(T xData) {
        if (curr == null)
            return;
        ListNode newNode = new ListNode(xData, curr.link);
        curr.link = newNode;
    }
    public void deleteCurrent() {
        if (curr != null && prev != null) {
            prev.link = curr.link;
            curr = curr.link;
        }
        else if (curr != null && prev == null) { // curr is at the head
            head = head.link;
        }
    }
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
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
        while (temp != null) {
            if (temp.data == xData) 
                return temp;
            temp = temp.link;
        }
        return null;
    }
}