public class Solution {
    public int majorityElement(int[] num) {
        if(num == null || num.length == 0) return 0;
        int majority = 0;
        int count = 1;
        for(int i = 1; i < num.length ; i++){
            if(num[i] == num[majority]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                majority = i;
                count = 1;
            }
            if(count > num.length / 2) return num[majority];
        }
        return num[majority];
    }
}