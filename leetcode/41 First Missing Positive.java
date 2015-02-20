public class Solution {
    public int firstMissingPositive(int[] a) {
        if(a == null ) return 0;
        for(int i = 0 ; i < a.length ; i++){
            if(a[i] != i + 1){
                int val = a[i];
                while(val >= 1 && val <= a.length && a[val - 1] != val){
                    int temp = a[val - 1];
                    a[val - 1] = val;
                    val = temp;
                }
            }
        }
        for(int i = 0 ; i < a.length ; i++){
            if(a[i] != i + 1)
                return i+1;
        }
        return a.length + 1;
    }
}