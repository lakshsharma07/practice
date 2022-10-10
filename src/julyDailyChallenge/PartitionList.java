package julyDailyChallenge;

public class PartitionList {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 3, 0, 2, 5, 2 };
		int x = 3;

		partition(createListNode(arr, 0), x);
	}

	public static ListNode partition1(ListNode head, int x) {

		ListNode before_head = new ListNode(0);
		ListNode before = before_head;
		ListNode after_head = new ListNode(0);
		ListNode after = after_head;

		while (head != null) {
			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}

		after.next = null;
		before.next = after_head.next;

		return before_head.next;
	}

	public static ListNode partition(ListNode head, int x) {

		ListNode currNode = new ListNode(0);
		ListNode prevNode = currNode;
		ListNode startNode = new ListNode(0);
		ListNode start = startNode;

		while (head != null) {
			// System.out.println(currNode.val);
			if (head.val < x) {
				start.next = head;
				start = start.next;
			} else {
				prevNode.next = head;
				prevNode = prevNode.next;
			}
			head = head.next;
		}
		prevNode.next = null;

		start.next = currNode.next;

		// System.out.println(list);
		print(startNode.next);
		return startNode.next;

	}

	private static void print(ListNode res) {
		ListNode currNode = res;
		while (currNode != null) {
			System.out.println(currNode.val);
			currNode = currNode.next;
		}
	}

	public static ListNode createListNode(int[] arr, int i) {
		ListNode head;
		if (arr.length == 0) {
			return null;
		}
		if (i == arr.length - 1) {
			return new ListNode(arr[i]);
		}
		head = new ListNode(arr[i]);
		head.next = createListNode(arr, i + 1);
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
