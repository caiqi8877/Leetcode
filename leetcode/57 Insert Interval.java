/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for(Interval it : intervals){
            if(it.end < newInterval.start ){
                result.add(it);
            }else if(it.start > newInterval.end){
                result.add(newInterval);
                newInterval = it;
            }else{
                newInterval = new Interval(Math.min(newInterval.start,it.start),Math.max(newInterval.end,it.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}