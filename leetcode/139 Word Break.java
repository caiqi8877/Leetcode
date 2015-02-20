public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
         if(s == null || dict == null) return false;
         boolean[] table = new boolean[s.length() + 1];
         table[0] = true;
         for(int i = 0 ; i < s.length() ; i++){
            if(!table[i]) continue;
            for(String word : dict){
                int len = word.length();
                if(i + len > s.length()) continue;
                if(s.substring(i,i+len).equals(word)){
                    table[i + len] = true;
                }
            }
         }
         return table[s.length()];
    }
}