public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Deque<Integer> r = new LinkedList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            r.push(p.val);
            if(p.left != null){
                stack.push(p.left);
            }
            if(p.right != null){
                stack.push(p.right);
            }
        }
        return new ArrayList(r);
       
    }
}