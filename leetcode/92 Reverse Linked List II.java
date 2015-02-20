/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( m == n) return head;
	  ListNode end = head;
	  ListNode fakeHead = new ListNode(0);
	  fakeHead.next = head;
	  ListNode start = fakeHead;
	  while( n > 0){
		  n--;
		  end = end.next;
	  }
	  while( m > 1){
		  m--;
		  start = start.next;
	  }
	  reverseHelp(start,end);
	  return fakeHead.next;
	}
	
	private static void reverseHelp(ListNode start,ListNode end){
		ListNode pre = end;
		ListNode cur = start.next;
		ListNode next = cur.next;
	
		while(next != end){
			cur.next = pre;
			pre = cur;
			cur = next;
			next = next.next;
		}
		cur.next = pre;
		start.next = cur;
		
	}
}