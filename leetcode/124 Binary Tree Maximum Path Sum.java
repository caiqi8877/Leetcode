/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public Iterable<TreeNode> topSort(TreeNode root) {
    Deque<TreeNode> result = new LinkedList<>();
    if (root != null) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.push(curr);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }
    return result;
}

public int maxPathSum(TreeNode root) {
    int result = Integer.MIN_VALUE;
    Map<TreeNode, Integer> maxRootPath = new HashMap<>(); // cache
    maxRootPath.put(null, 0); // for simplicity we want to handle null nodes
    for (TreeNode node : topSort(root)) {
        // as we process nodes in post-order their children are already cached
        int left = Math.max(maxRootPath.get(node.left), 0);
        int right = Math.max(maxRootPath.get(node.right), 0); 
        maxRootPath.put(node, Math.max(left, right) + node.val);
        result = Math.max(left + right + node.val, result);
    }
    return result;
    }
}