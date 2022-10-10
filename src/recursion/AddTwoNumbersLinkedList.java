package recursion;

import java.util.ArrayList;

public class AddTwoNumbersLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,9,9,9,9};
		int[] arr1 = {9,5,9,9};
		addTwoNumbers1( createListNode(arr,0),  createListNode(arr1,0));
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
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long sum = dfs(l1,0,0)+dfs(l2,0,0);
		int[] arr = new int[String.valueOf(sum).length()];
		int i =0;
		while (sum>0) {
			arr[i] =(int) (sum%10);
			sum = sum/10; 
			i+=1;
		}
		
		return createListNode(arr, 0);
        
    }

	private static long dfs(ListNode l1, int i, long num) {
		if (l1 == null) {
			return 0;
		}
		else{
			num+=dfs(l1.next,i+1,num) + l1.val*Math.pow(10,i);
		}
		return num;
	}
	
	
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

}
