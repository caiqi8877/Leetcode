public class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void inOrder(TreeNode root){
        if(root == null) return;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode cur = stack.pop();
                //
                if(prev != null && cur.val < prev.val){
                    if(first == null) first = prev;
                    second = cur;
                }
                prev = cur;
                //
                p = cur.right;
            }
        }
    }
    
    public void recoverTree(TreeNode root) {
        inOrder(root);
        if(first != null && second != null){
            first.val ^= second.val;
            second.val ^= first.val;
            first.val ^= second.val;
            
        }
    }
}