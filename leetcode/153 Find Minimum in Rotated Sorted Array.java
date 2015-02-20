public class Solution {
    public int findMin(int[] num) {
        
        if(num.length==1) return num[0];
        
        int l = 0;
        int r = num.length - 1;
        if(num[l] < num[r]) return num[0];
        
        while(l < r- 1){
            int m = (l + r) / 2;
            if( num[m] < num[l]){
                r = m;
            }else{
                l = m;
            }
        }
        
        return num[r];
    }
}