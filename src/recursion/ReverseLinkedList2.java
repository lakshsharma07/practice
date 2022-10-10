package recursion;

public class ReverseLinkedList2 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4,5 };
		// reverseList(createListNode(arr, 0));
		ListNode res = reverseBetween(createListNode(arr, 0), 2, 4);
		print(res);
	}

	private static void print(ListNode res) {
		 ListNode currNode = res;
		while (currNode!=null) {
			System.out.println(currNode.val);
			currNode = currNode.next;

		}
		
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

	public static ListNode reverseBetween(ListNode head, int left, int right) {

		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		
		ListNode currNode = dummyNode;
		ListNode prevNode = null;
		ListNode nextNode = null;
		ListNode prevIt = null;
		ListNode It = null;
		int index = -1;
		while (index <= right) {
			index++;
			if (index<left) {
				prevNode = currNode;
				currNode = currNode.next;
			}
			if (index == left) {
				prevIt = prevNode;
				It = currNode;
			}
			if (index >= left && index <= right) {
				nextNode = currNode.next;
				currNode.next = prevNode;
				prevNode = currNode;
				currNode = nextNode;
			}
		}
		prevIt.next = prevNode;
		It.next = nextNode;

		return (dummyNode.next);
	}

}
