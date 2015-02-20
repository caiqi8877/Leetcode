public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        
        Set<List<Integer>> cur = new HashSet<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        cur.add(l);
        Arrays.sort(num);
        for(int i = 0 ; i < num.length ; i++){
            Set<List<Integer>> pre = new HashSet<List<Integer>>();
            for(List<Integer> list : cur){
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(num[i]);
                pre.add(newList);
            }
            cur.addAll(pre);
        }
        return new ArrayList<List<Integer>>(cur);
    }
}