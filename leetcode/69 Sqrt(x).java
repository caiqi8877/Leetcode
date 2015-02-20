public class Solution {
    public int sqrt(int x) {
        if(x <= 1) return x;
        int l = 0 ;
        int r = x;
        while(l + 1< r){
            int mid = ( l + r ) / 2;
            if( mid == x / mid){
                return mid;
            }else if(mid < x / mid){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l;
    }
}