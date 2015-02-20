public class Solution {
    public void connect(TreeLinkNode root) {
        
        if(root == null) return;
        
        while(root != null){
            TreeLinkNode temp = new TreeLinkNode(0);
            TreeLinkNode cur = temp;
            while(root!=null){
                if(root.left != null) { cur.next = root.left; cur = cur.next;}
                if(root.right != null) { cur.next = root.right; cur = cur.next;}
                root = root.next;
            }
            root = temp.next;
        }
    }
}