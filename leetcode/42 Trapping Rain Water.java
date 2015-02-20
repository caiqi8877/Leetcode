public class Solution {
    public int trap(int[] A) {
        int left = 0;
        int right = A.length -1;
        int lmax = 0;
        int rmax = 0;
        int area = 0;
        while(left < right){
            lmax = Math.max(A[left],lmax);
            rmax = Math.max(A[right],rmax);
            if(lmax <= rmax){
                area += lmax - A[left++];
            }else{
                area += rmax - A[right--];
            }
        }
        return area;
    }
}