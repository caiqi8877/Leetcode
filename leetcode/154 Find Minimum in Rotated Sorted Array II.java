public class Solution {
    public int findMin(int[] num) {
            
        if(num == null || num.length == 0) return 0;
        if(num[0] < num[num.length - 1]) return num[0];
        int l = 0;
        int r = num.length - 1;
        while(l < r - 1){
            if(num[l] < num[r]) return num[l];
            int m = (r + l) / 2;
            if(num[l] > num[m]){
                r = m;
            }else{
                l++;
            }
        }
        return Math.min(num[l],num[r]);

    }
}