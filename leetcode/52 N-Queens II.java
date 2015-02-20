public class Solution {
    
    int aa = 0;

    public int totalNQueens(int n) {
        if(n <= 1) return n;
        boolean[] c = new boolean[n];
        boolean[] l = new boolean[2 * n];
        boolean[] r = new boolean[2 * n];       
        dfs(n,0,c,l,r);
        return aa;
    }
    
    private void dfs(int n,int i,boolean[] c,boolean[] l,boolean[] r){
        if(i == n ){
            aa++;
            return;
        }
        for(int k = 0 ; k < n ; k++){
            if(c[k] || l[k - i + n] || r[k + i] ){
                continue;
            }
            c[k] = true;
            l[k - i + n] = true; 
            r[k + i ] = true;
            dfs(n,i + 1,c,l,r);
            c[k] = false;
            l[k - i + n] = false; 
            r[k + i ] = false;
        }
    }
}