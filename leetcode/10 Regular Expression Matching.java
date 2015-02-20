public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    
    public boolean isMatch(String s, int is, String p, int ip) {
        if (ip == p.length()) return is == s.length();
        
        //case 1, next char of p is not "*"
        if (ip == p.length() - 1 || p.charAt(ip + 1) != '*')
            return (is < s.length() && 
                    (p.charAt(ip) == '.' || p.charAt(ip) == s.charAt(is)) && 
                    isMatch(s, is + 1, p, ip + 1));
        
        //case 2, next char of p is "*"
        if (isMatch(s, is, p, ip + 2)) return true;
        
        for (int i = is + 1; i <= s.length(); i++) {
            if (p.charAt(ip) != '.' && p.charAt(ip) != s.charAt(i - 1)) return false;
            if (isMatch(s, i, p, ip + 2)) return true;
        }
        
        return false;
    }
}