package Lab03;
//Jake Powers
public class circularListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCircularLinkedList strLL = new StringCircularLinkedList();
		System.out.println("Create, insert, and print test by adding values 1-4");
		for (int i = 1; i <= 5; i++) {
			strLL.insert(Integer.toString(i));
		}
		strLL.print();
		System.out.println("Moving curr twice and deleting curr.");
		strLL.gotoNext();
		strLL.gotoNext();
		strLL.gotoNext();
		strLL.deleteCurrent();
		strLL.print();
		System.out.println("Testing In list by searching for the value 4");
		System.out.println(strLL.isInList("4"));
		System.out.println("Testing In list by searching for the value 3");
		System.out.println(strLL.isInList("3"));
		System.out.println("Testing getting and setting current by setting value of string to 14");
		strLL.gotoNext();
		strLL.setDataAtCurr("14");
		strLL.print();
		System.out.println("Moving current forward and deleting that node.");
		strLL.gotoNext();
		strLL.gotoNext();
		strLL.deleteCurrent();
		strLL.print();
		System.out.println("Moving current backward and deleting that node.");
		strLL.goToPrev();
		strLL.deleteCurrent();
		strLL.print();
	}

}
