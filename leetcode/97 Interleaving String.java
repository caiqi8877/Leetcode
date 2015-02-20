public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        
        if(s1 == null || s2 == null || s3 == null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];
        table[0][0] = true;
        
        for(int i = 1 ; i <= s1.length() ; i++)
            if(s1.charAt(i - 1) == s3.charAt(i - 1)) table[i][0] = true;
            
        for(int j = 1 ; j <= s2.length() ; j++)
            if(s2.charAt(j - 1) == s3.charAt(j - 1)) table[0][j] = true;
            
        for(int i = 1 ; i <= s1.length() ; i++){
            for(int j = 1; j <= s2.length() ; j++){
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && table[i - 1][j ]) table[i][j] = true;
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1) && table[i][j - 1 ]) table[i][j] = true;
            }
        }
        return table[s1.length() ][s2.length()];
    }
}