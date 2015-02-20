public class Solution {
    public List<List<Integer>> permute(int[] num) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0){
            return result;
        }
        result.add(new ArrayList<Integer>());
        
        for(int i = 0 ; i < num.length ; i++){
            List<List<Integer>> cur = new ArrayList<List<Integer>>();
            for(List<Integer> list : result){
                for(int j = 0 ; j <= list.size() ; j++){
                    list.add(j,num[i]);
                    cur.add(new ArrayList<Integer>(list));
                    list.remove(j);
                }
            }
            
            result = new ArrayList<List<Integer>>(cur);
        }
        return result;
    }
}