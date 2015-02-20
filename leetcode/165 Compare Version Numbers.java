public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null ) return 0;
        String[] splits1 = version1.split("\\.");
        String[] splits2 = version2.split("\\.");
        int len = Math.max(splits1.length,splits2.length);
        for(int i = 0 ; i < len ; i++){
            int a = i < splits1.length ? Integer.parseInt(splits1[i]) : 0;
            int b = i < splits2.length ? Integer.parseInt(splits2[i]) : 0;
            if(a > b)      return 1;
            else if(a < b) return -1;
        }
        return 0;
    }
}