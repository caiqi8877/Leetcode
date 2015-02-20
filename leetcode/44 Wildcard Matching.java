public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;
        
        while(i < s.length()){
            if( j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
            }else if( j < p.length() && p.charAt(j) == '*'){
                mark = i;
                star = j;
                j++;
            }else if(star != -1){
                j = star + 1;
                i = mark + 1;
                mark ++;
            }else {
                return false;
            }
        }
        while(j < p.length() && p.charAt(j) == '*' ) j++;
        
        return j == p.length();
    }
}