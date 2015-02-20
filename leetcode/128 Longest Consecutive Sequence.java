public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        int max = 1;
        
        for(int e : num){
            set.add(e);
        }
        
        for(int e: num){
            int left = e - 1;
            int right = e + 1;
            int count = 1;
            
            while(set.contains(left)){
                count++;
                set.remove(left);
                left--;
            }
            
            while(set.contains(right)){
                count++;
                set.remove(right);
                right++;
            }
            
            max = Math.max(count, max);
        }
        
        return max;
    }
}