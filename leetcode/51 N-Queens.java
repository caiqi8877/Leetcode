public class Solution {
    
    public List<String[]> solveNQueens(int n) {
        
        List<String[]> result = new ArrayList<String[]>();
        String[] s = new String[n];
        boolean[] c = new boolean[n];
        boolean[] l = new boolean[2 * n];
        boolean[] r = new boolean[2 * n];       
        dfs(n,0,c,l,r,s,result);
        return result;
    }
    
    private void dfs(int n,int i,boolean[] c,boolean[] l,boolean[] r,String[] s,List<String[]> result){
        if(i == n ){
            result.add(s.clone());
            return;
        }
        for(int k = 0 ; k < n ; k++){
            if(c[k] || l[k - i + n] || r[k + i] ){
                continue;
            }
            char[] chars = new char[s.length];
            Arrays.fill(chars,'.');
            chars[k] = 'Q';
            s[i] = new String(chars);
            
            c[k] = true;
            l[k - i + n] = true; 
            r[k + i ] = true;
            dfs(n,i + 1,c,l,r,s,result);
            c[k] = false;
            l[k - i + n] = false; 
            r[k + i ] = false;
        }
    }
}