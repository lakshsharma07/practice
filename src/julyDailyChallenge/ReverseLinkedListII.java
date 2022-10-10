package julyDailyChallenge;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] head = { 1, 2, 3, 4, 5 };
		int left = 2;
		int right = 4;

		ListNode root = createListNode(head, 0);
		// print(root);

		reverseBetween(root, left, right);
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
		if (i == arr.length - 1) {
			return new ListNode(arr[i]);
		}
		head = new ListNode(arr[i]);
		head.next = createListNode(arr, i + 1);
		return head;
	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
		int index = 0;
		ListNode Ls1 = null;
		ListNode Rs1 = null;

		ListNode start = new ListNode();
		start.next = head;

		ListNode curr = start.next;
		ListNode prev = null;
		ListNode next = null;

		while (index <= right) {
			index += 1;
			if (index < left) {
				prev = curr;
				curr = curr.next;
			}
			if (index == left) {
				Ls1 = prev;
				Rs1 = curr;
			}
			if (index > left) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}

		}
		Ls1.next = prev;
		Rs1.next = curr;

		// print(start.next);
		return start.next;

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
