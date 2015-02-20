public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(! (new String(c1)).equals(new String(c2)) ){
            return false;
        }
        if(s1.length() == 1 && s2. length() == 1 && s1.charAt(0) == s2.charAt(0) ) return true;
        boolean result;
        int len = s1.length();
        
        for(int i = 1 ; i < len ; i++){
            result = (isScramble(s1.substring(0,i),s2.substring(0,i)) &&
                     isScramble(s1.substring(i),s2.substring(i))) ||
                     (isScramble(s1.substring(0,i),s2.substring(len - i)) &&
                     isScramble(s1.substring(i),s2.substring(0,len - i)));
            if(result) return true;
        }
        
        return false;
    }  
    
}