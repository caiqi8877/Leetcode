public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S == null || S.length == 0) return result;
        List<Integer> empty = new ArrayList<Integer>();
        result.add(empty);
        Arrays.sort(S);
        for(int i = 0 ; i < S.length ; i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> list : result){
                List<Integer> s = new ArrayList<Integer>(list);
                s.add(S[i]);
                temp.add(s);
            }
            result.addAll(temp);
        }
        return result;
    }
}