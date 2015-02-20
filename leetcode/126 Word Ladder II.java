public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
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
    
    private List<List<String>> BFS(String start, String end, HashMap<String, Set<String>> graph) {
        List<String> words = new ArrayList<String>();
        List<Integer> father = new ArrayList<Integer>();
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, Integer> minSteps = new HashMap<String, Integer>();
        
        words.add(start);
        father.add(-1);
        minSteps.put(start, 0);
        int head = 0;
        while (head < words.size()) {
            String cur = words.get(head);    
            int base = minSteps.get(cur);
            
            for (String next : graph.get(cur)) 
                if (minSteps.get(next) == null || base + 1 <= minSteps.get(next)) {
                    words.add(next);
                    father.add(head);
                    if (minSteps.get(next) == null)
                        minSteps.put(next, base + 1);
                    
                    if (end.equals(next)) {
                        result.add(trackSolution(words, father, words.size() - 1));
                    }
                }
                
            head ++;
        }
        
        return result;
    }
    
    private List<String> trackSolution(List<String> words, List<Integer> father, int index) {
        List<String> result = new LinkedList<String>();
        while (index != -1) {
            result.add(0, words.get(index));
            index = father.get(index);
        }
        return result;
    }
}