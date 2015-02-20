public class Solution {
    public int maxProduct(int[] A) {
        if(A == null || A.length == 0 ) return 0;
        if(A.length == 1) return A[0];
        int maxB = A[0];
        int minB = A[0];
        int max = A[0];
        for(int i = 1 ; i < A.length ; i++){
            int temp = maxB;
            maxB = Math.max(A[i], Math.max(maxB * A[i], minB * A[i]) );
            minB = Math.min(A[i], Math.min(temp * A[i], minB * A[i]) );
            max = Math.max(maxB,max);
        }
        return max;
    }
}