/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
		RandomListNode p = head;
		while(p != null){
			RandomListNode tempNext = p.next;
			RandomListNode node = new RandomListNode(p.label);
			p.next = node;
			node.next = tempNext;
			p = tempNext;
		}
		p = head;
		while( p != null){
		    if(p.random != null) p.next.random = p.random.next;
			p = p.next.next;
		}
		p = head;
		RandomListNode newHead = p.next;
		RandomListNode copy = newHead;
		
		while( p != null){
			p.next = copy.next;
			p = p.next;
			if(p != null){
				copy.next = p.next;
			}
			copy = copy.next;
			
		}
		
		return newHead;
    }
    
}