public class Solution {
    public int maximumGap(int[] num) {
        if(num == null || num.length < 2) return 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < num.length ; i++){
            if(max < num[i]) max = num[i];
            if(min > num[i]) min = num[i];
        }
        int n = num.length;
        int gap = (int)Math.ceil((max + 0.0 - min) / (n - 1));
        int[][] a = new int[n + 1][3];
        for(int i = 0 ; i < num.length ; i++){
            int cur = num[i];
            int row = (cur - min) / gap;
            if(a[row][0] == 0){ 
                a[row][0] = 1;a[row][1] = cur;a[row][2] = cur;
            }else if(cur > a[row][1]){
                a[row][2] = cur;
            }else if(cur < a[row][0]){
                a[row][1] = cur; 
            }
        }
        int result = 0;
        int pre = a[0][2];
        for(int i = 1 ; i < a.length ; i++ ){
           if(a[i][0] == 0)continue;
           if(result < a[i][1] - pre) result = a[i][1] - pre;
           pre = a[i][2];
        }
        return result;
        
    }
}