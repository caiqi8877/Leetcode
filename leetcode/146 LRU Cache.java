public class LRUCache {
    HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
    LinkedListNode first;
    LinkedListNode cur;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            LinkedListNode node = map.get(key);
            delete(node);
            setAtTail(node);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        
        if(capacity <= 0) return;
        
        if(map.containsKey(key)){
            LinkedListNode old = map.get(key);
            old.val = value;
            delete(old);
            setAtTail(old);
            
        }else{
        
            LinkedListNode node = new LinkedListNode(key,value);
            
            if(map.size() < capacity){
                map.put(key,node);
                setAtTail(node);
            }else{
                map.remove(first.key);
                delete(first);
                setAtTail(node);
                map.put(key,node);
            }
        }
    }
    
    public void delete(LinkedListNode node){
        LinkedListNode before = node.pre;
        LinkedListNode after = node.next;
        if(before != null){
            before.next = after;
        }else{
            first = after;
        }
        if(after != null){
            after.pre = before;
        }else{
            cur = before;
        }
    }
    
    public void setAtTail(LinkedListNode node){
        if(cur == null && first == null){
            first = node;
            cur = node;
        }else{
            node.next = null;
            cur.next = node;
            node.pre = cur;
            cur = node;
        }
    }
}

class LinkedListNode{
    LinkedListNode pre;
    LinkedListNode next;
    int key;
    int val;
    public LinkedListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}