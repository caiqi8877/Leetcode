public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root != null){
            List<TreeNode> list = new ArrayList<TreeNode>();
            List<Integer> path = new ArrayList<Integer>();
            List<Integer> sums = new ArrayList<Integer>();
            list.add(root);
            path.add(-1);
            sums.add(sum);
            int index = 0;
            while(index < list.size()){
                TreeNode cur = list.get(index);
                int s = sums.get(index);
                if(cur.left != null) {
                    list.add(cur.left);
                    sums.add(s - cur.val);
                    path.add(index);
                }
                if(cur.right != null) {
                    list.add(cur.right);
                    sums.add(s - cur.val);
                    path.add(index);
                }
                if(cur.left == null && cur.right == null && cur.val == s){
                    result.add(build(path,list,index));
                }
                index++;
            }
        }
        return result;
    }
    
    private List<Integer> build(List<Integer> path, List<TreeNode> list, int index){
        List<Integer> result = new ArrayList<Integer>();
        while(index != -1){
            result.add(0,list.get(index).val);
            index = path.get(index);
        }
        return result;
        
    }
}