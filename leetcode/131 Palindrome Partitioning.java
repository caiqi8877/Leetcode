public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if( s == null || s.length() < 1) return result;
        
        List<String> list = new ArrayList<String>();
        boolean[][] isValid = getValid(s);
        dfs(result,list,s, 0, isValid);
        
        return result;
    }
    
    private boolean[][] getValid(String s) {
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
    
    private void dfs(List<List<String>> result, List<String> list, String s, int depth, boolean[][] isValid) {
        if (depth == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = depth; i < s.length(); i++) 
            if (isValid[depth][i]) {
                list.add(s.substring(depth, i + 1));
                dfs(result, list, s, i+1, isValid);
                list.remove(list.size() - 1);
            }

    }
}