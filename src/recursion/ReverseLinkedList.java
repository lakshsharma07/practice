package recursion;

public class ReverseLinkedList {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		reverseList(createListNode(arr, 0));
	}

	public static ListNode createListNode(int[] arr, int i) {
		ListNode head;
		if (i == arr.length - 1) {
			return new ListNode(arr[i]);
		}
		head = new ListNode(arr[i]);
		head.next = createListNode(arr, i + 1);
		return head;
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode node = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}
	

	public static ListNode reverseList1(ListNode head) {
		 ListNode currNode = head;
		 ListNode prevNode = null;
		 ListNode nextNode;
		while (currNode!=null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;	
		}
		return prevNode;
	}

}
