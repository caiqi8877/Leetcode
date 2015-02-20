public class Solution {
    public void nextPermutation(int[] num) {
      if( num == null || num.length <= 1) return;
      boolean flag = false;
      for(int i = num.length - 2 ; i >= 0 ; i--){
          if(num[i] < num[i + 1]){
              flag = true;
              int j;
              for(j = num.length - 1; j > i ; j--){
                  if(num[j] > num[i]) break;
              }
              int temp = num[i];
              num[i] = num[j];
              num[j] = temp;
              Arrays.sort(num,i+1,num.length);
              break;
          }
      }
      if(!flag){
          Arrays.sort(num);
      }
    }
}