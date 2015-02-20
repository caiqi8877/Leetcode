/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        return generateTrees(1,n);
    }
    
    private List<TreeNode> generateTrees(int left, int right){
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        if(left > right){
            result.add(null);
        }else if(left == right){
            TreeNode cur = new TreeNode(left);
            result.add(cur);
        }else{
            for(int i = left ; i <= right ; i++){
                for(TreeNode l : generateTrees(left,i-1)){
                    for(TreeNode r : generateTrees(i + 1, right)){
                        TreeNode cur = new TreeNode(i);
                        cur.left = l;
                        cur.right = r;
                        result.add(cur);
                    }
                }
            }
        }
        return result;
    }
}