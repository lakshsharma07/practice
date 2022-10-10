package recursion;

public class SwapPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4 };
		swapPairs(createListNode(arr,0));
	}
	
	public static ListNode createListNode(int[] arr, int i) {
		ListNode head;
		if (i == arr.length-1) {	
			return new ListNode(arr[i]);
		}
		 head = new ListNode(arr[i]);
		 head.next =  createListNode(arr,i+1);
		 return head;
	}
	public static ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		System.out.println(head.val);
		ListNode node = head.next;
		head.next = swapPairs(head.next.next);
		node.next  = head;
		
		return node;

	}

}
