public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n < k || n < 0 || k <= 0) return result;
        List<Integer> list = new ArrayList<Integer>();
        generate(result, list, 1, n, k);
        return result;
    }
    
    private void generate(List<List<Integer>> result, List<Integer> list,int start, int n, int k){
        if(list.size() == k){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = start ; i <= n ; i++){
            list.add(i);
            generate(result,list,i + 1,n,k);
            list.remove(list.size() - 1);
        }
        
    }
}