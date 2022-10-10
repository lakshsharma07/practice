package recursion;

public class MergeTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list1 = { 1, 2, 4 };
		int[] list2 = { 1, 3, 4 };
		mergeTwoLists(createListNode(list1, 0), createListNode(list2, 0));
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

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
            return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
            return list2;
		}

	}
	
	public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
		ListNode node = new ListNode();
        ListNode ans = node;

		while ( list1 != null && list2 != null) {

			if (list1.val <= list2.val) {
				node.next = list1;
				list1 = list1.next;
			} else {
				node.next = list2;
				list2 = list2.next;
			}
            node = node.next;
		}
         while(list1 != null){
            node.next=list1;
            node = node.next;
            list1=list1.next;
        }
        while(list2 != null){
            node.next=list2;
            node = node.next;
            list2=list2.next;
        }

		return ans.next;
}

}
