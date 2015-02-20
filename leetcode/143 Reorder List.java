public class Solution {
    public void reorderList(ListNode root) {
        if(root == null || root.next == null){
			return;
		}
		
		ListNode slow = root;
		ListNode fast = root;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		
		// reverse head2
		
		ListNode pre = null;
		ListNode cur = head2;
		ListNode next = cur.next;
		while(cur != null){
			cur.next = pre;
			pre = cur;
			cur = next;
			if(next != null ) next = next.next;
		}
	
		
		// merge the two list
		
		ListNode p = root;
		while(cur != null && p != null){
			ListNode temp = p.next;
			ListNode tempCur = cur.next;
			p.next = cur;
			p = temp;
			cur.next = p;
			cur = tempCur;
		}
	}
    
}