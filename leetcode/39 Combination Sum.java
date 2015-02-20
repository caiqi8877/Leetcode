public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( candidates == null || candidates.length == 0 || target <= 0){
            return result;
        }
        
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        dfs(result,list,0,target,candidates);
        return result;
    }
        
    private void dfs(List<List<Integer>> result, List<Integer> list, int start, int target, int[] candidates){
        if(target == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = start ; i < candidates.length ; i++){
            if(target - candidates[i] < 0) return;
            list.add(candidates[i]);
            dfs(result,list,i,target-candidates[i],candidates);
            list.remove(list.size() - 1);
        }
        
    }   
}