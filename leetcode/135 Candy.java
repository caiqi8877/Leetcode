public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null) return 0;
        if(ratings.length == 1) return 1;
        int[] a = new int[ratings.length];
        a[0] = 1;
        
        for(int i = 1 ; i  <ratings.length ; i++){
            if(ratings[i] > ratings[i-1]){
                a[i] = a[i-1] + 1;
            }else{
                a[i] = 1;
            }
        }
        
        int sum = a[ratings.length - 1];
        a[ratings.length - 1] = 1;
        
        for(int i = ratings.length - 2; i >= 0 ; i--){
            if(ratings[i ] > ratings[i + 1]){
                sum += Math.max(a[i], a[i + 1] + 1);
                a[i] = a[i + 1] + 1;
            }else{
                sum += a[i];
                a[i] = 1;
            }
        }
        return sum;
    }
}