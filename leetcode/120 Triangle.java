public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int len = triangle.size();
        List<Integer> a = new ArrayList<Integer>(triangle.get(len-1));
        for(int i = len - 2 ; i >= 0 ; i--){
            for(int j = 0 ; j < triangle.get(i).size() ; j++){
                a.set(j, triangle.get(i).get(j) + Math.min(a.get(j),a.get(j + 1) ));
            }
        }
        return a.get(0);
    }
}

