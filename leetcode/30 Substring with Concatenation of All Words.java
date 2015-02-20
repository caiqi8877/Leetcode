public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();  
        int len = L.length;  
        if (len == 0) {  
            return list;  
        }  
        int wordLen = L[0].length();  
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();  
        for (int i = 0; i < len; i++) {  
            int num = 1;  
            if (wordsMap.get(L[i]) != null) {  
                num += wordsMap.get(L[i]);  
            }  
            wordsMap.put(L[i], num);  
        }  
        int slen = S.length();  
        int max = slen - len * wordLen + 1;  
        for (int i = 0; i < max; i++) {  
            Map<String, Integer> numMap = new HashMap<String, Integer>();  
            int j = 0;  
            for (; j < len; j++) {  
                int start = i + j * wordLen;  
                int end = start + wordLen;  
                String tempStr = S.substring(start, end);  
                if (!wordsMap.containsKey(tempStr)) {  
                    break;  
                }  
                int num = 1;  
                if (numMap.get(tempStr) != null) {  
                    num += numMap.get(tempStr);  
                }  
                if (num > wordsMap.get(tempStr)) {  
                    break;  
                }  
                numMap.put(tempStr, num);  
            }  
            if (j == len) {  
                list.add(i);  
            }  
        }  
        return list; 
    }
}