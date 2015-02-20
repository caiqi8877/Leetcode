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
    public ListNode mergeKLists(List<ListNode> lists) {
        if( lists.size() == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return (a.val - b.val);
            }
        });
    
    
    for( ListNode list : lists ){
        if( list != null)
            q.add(list);
    }
    
    ListNode head = new ListNode(0);
    ListNode prev = head;
    
    while( q.size() >  0){
        ListNode temp = q.poll();
        prev.next = temp;
        
        if(temp.next != null)
            q.add(temp.next);
            
        prev = prev.next;
    }
    
    return head.next;
 }
}