public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        HashMap<String, Set<String>> graph = buildGraph(dict);
        
        return BFS(start, end, graph);
    }
    
    private HashMap<String, Set<String>> buildGraph(Set<String> dict) {
        HashMap<String, Set<String>> result = new HashMap<String, Set<String>>();
        
        for (String word : dict) {
            if (result.get(word) == null)
                result.put(word, new HashSet<String>());
            
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];

                for (int j = 0; j <= 25; j++)
                    if ((int)(c - 'a') != j) {
                        chars[i] = (char)('a' + j);
                        String newWord = new String(chars);

                        if (dict.contains(newWord))
                            result.get(word).add(newWord);

                    }
                    
                chars[i] = c;
            }
            
        }
        
        return result;
    }
    
    private int BFS(String start, String end, HashMap<String, Set<String>> graph) {
        Queue<String> words = new LinkedList<String>();
        Queue<Integer> steps = new LinkedList<Integer>();
        Set<String> hash = new HashSet<String>();
        words.add(start);
        steps.add(1);
        hash.add(start);
        
        while (!words.isEmpty()) {
            String head = words.poll();
            int base = steps.poll();
            for (String next : graph.get(head)) 
                if (!hash.contains(next)) {
                    words.add(next);
                    steps.add(base + 1);
                    hash.add(next);
                    
                    if (end.equals(next)) {
                        return base + 1;
                    }
                }
        }
        
        return 0;
    }
}