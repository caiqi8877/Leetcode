public class Solution {
    public int jump(int[] A) {
        int reach = 0;
        int lastreach = 0;
        int step = 0;
        for(int i = 0 ; i <= reach && i < A.length ; i++){
            if(i > lastreach){
                lastreach = reach;
                step++;
            }
            reach = Math.max(reach, A[i] + i);
        }
        return step;
    }
}