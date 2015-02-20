public class Solution {
    public void flatten(TreeNode root) {
        while(root != null){
            TreeNode left = root.left;
            TreeNode p = left;
            if(p != null){
                while(p.right != null){
                    p = p.right;
                }
                p.right = root.right;
                root.right = left;
                root.left = null;
            }
            root = root.right;
        }
    }
}