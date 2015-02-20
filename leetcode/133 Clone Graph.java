/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null ) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        queue.add(node);
        createNewNode(node,map);

        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.remove();
            connect(cur,map,queue);
        }
        
        return map.get(node);
    }
    
    private void createNewNode(UndirectedGraphNode cur, HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
        UndirectedGraphNode newNode = new UndirectedGraphNode(cur.label);
        map.put(cur,newNode);
    }
    
    private void connect(UndirectedGraphNode cur, HashMap<UndirectedGraphNode,UndirectedGraphNode> map, Queue<UndirectedGraphNode> queue){
        for(UndirectedGraphNode neighbor : cur.neighbors){
            if(!map.containsKey(neighbor)){
                queue.add(neighbor);
                createNewNode(neighbor,map);
            }
            map.get(cur).neighbors.add(map.get(neighbor));
        }
    }
}