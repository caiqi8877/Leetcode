public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12) return result;
        StringBuilder sb = new StringBuilder();
        dfs(result,sb,s,0,0);
        return result;
    }
    
    private void dfs(List<String> result, StringBuilder sb, String s, int start, int num){
        // if(s.length() - start < 4 - num || s.length() - start > 16 - num * 4 ) return;
        if(num == 4){
            if(start == s.length()){
              sb.delete(sb.length()-1,sb.length());
               result.add(sb.toString());
            }
            return;
        }
        
        for(int i = start ; i < s.length() && i < start + 4 ; i++){
            String temp = s.substring(start,i+1);
            if(valid(temp)){
                int pre = sb.length();
                sb.append(temp).append(".");
                dfs(result, sb, s, i + 1, num + 1);
                sb.delete(pre,sb.length());
            }
        }
    }
    
    private boolean valid(String s){
        if(s.charAt(0) == '0') return s.equals("0");
        int n = Integer.parseInt(s);
        return n > 0 && n < 256;
    }
}