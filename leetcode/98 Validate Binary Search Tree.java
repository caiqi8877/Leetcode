public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode cur = stack.pop();
                if(pre != null && cur.val <= pre.val) return false;
                p = cur.right;
                pre = cur;
            }
        }
        
        return true;
    }
}