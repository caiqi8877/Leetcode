public class Solution {
    public int[] searchRange(int[] A, int target) {
        int left = findLeftBound(A,target);
        int right = findRightBound(A,taget);
        int[] result = {left,right}
        return result;
    }
    public int findLeftBound(int[] A, int target){
        if(A == null || A.length == 0) return -1;
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target < A[mid])      right = mid - 1;
            else if(target > A[mid]) left  = mid + 1;
            else right = mid;
            
        }
        return -1;
    }
}