/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length ==0) return 0;
        if(points.length == 1) return 1;
        
        int max = 2;
        // k = infinite
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        for(Point p : points){
            if(map1.containsKey(p.x)){
                int val = map1.get(p.x) + 1;
                if(max < val) max = val;
                map1.put(p.x,val);
            }else{
                map1.put(p.x,1);
            }
        }
        // k != infinite
        
        int line = 0;
        
        for(int i = 0 ; i < points.length ; i++){
            Map<Double,Integer> map = new HashMap<Double,Integer>();
            int samePoint = 0;
            int temp = 0;
            for(int j = i + 1 ; j < points.length ; j++){
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y){
                        samePoint++;
                    }
                    continue;
                }
                double k = (double)(points[j].y - points[i].y ) / (double)(points[j].x - points[i].x) + 0.0;
                if(map.containsKey(k)){
                    int val = map.get(k) + 1;
                    if(temp < val) temp = val;
                    map.put(k,val);
                }else{
                    map.put(k,1);
                    if(temp < 1) temp = 1;
                }
            }
            temp += samePoint;
            line = Math.max(line, temp);
        }
        
        return Math.max(max,line + 1);
    }
}