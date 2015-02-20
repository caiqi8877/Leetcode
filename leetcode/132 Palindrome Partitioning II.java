public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() <= 1) return 0;
        boolean[][] isPalindrome = getPalindrome(s);
        int[] f = getResult(s, isPalindrome);
        
        return f[s.length() - 1];
    }
    
    private int[] getResult(String s, boolean[][] isPalindrome) {
        int[] result = new int[s.length()];
        
        for (int i = 1; i < s.length(); i++) 
            if (!isPalindrome[0][i]) {
                result[i] = Integer.MAX_VALUE;
                for (int j = 0; j <= i - 1; j++)
                    if (isPalindrome[j + 1][i])
                        result[i] = Math.min(result[i], result[j] + 1);
            }
            
        return result;
    }
    
    private boolean[][] getPalindrome(String s) {
        int n = s.length();
        boolean[][] result = new boolean[n][n];
        
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < n - i + 1; j++)
                if (i == 1)
                    result[j][j] = true;
                else if (i == 2)
                    result[j][j + 1] = s.charAt(j) == s.charAt(j + 1);
                else
                    result[j][j + i - 1] = result[j + 1][j + i - 2] && s.charAt(j) == s.charAt(j + i - 1);
        
        return result;
    }
}