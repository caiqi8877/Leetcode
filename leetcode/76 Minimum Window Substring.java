public class Solution {
    public String minWindow(String S, String T) {
        if(S == null || T == null || S.length() ==0 || T.length() ==0) return "";
        int[] count = new int[256];
        int[] cur = new int[256];
        
        for (int i = 0; i < T.length(); i++) count[(int)T.charAt(i)]++;
        
        int head = 0, tail = 0, size = 0;
        String result = "";
        while (tail < S.length()) {
            int c = (int)S.charAt(tail);
            cur[c]++;
            if (count[c] > 0) {
                if (cur[c] <= count[c]) size++;
                
                if (size == T.length()) {
                    while (cur[(int)S.charAt(head)] > count[(int)S.charAt(head)]) {
                        if(count[(int)S.charAt(head)] > 0)cur[(int)S.charAt(head)]--;
                        head++;
                    }
                    if (result.equals("") || (tail - head + 1) < result.length()) result = S.substring(head, tail + 1);
                }
            }
            tail++;
        }
        
        return result;
    }
}