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
    public List<Interval> merge(List<Interval> intervals) {
        
        if(intervals == null || intervals.size() <= 1) return intervals;
            
        Collections.sort(intervals,new IntervalComparator());
        
        int end = Integer.MIN_VALUE;
        List<Interval> result = new ArrayList<Interval>();
        for(Interval it: intervals){
            if(it.start > end){
                result.add(it);
                end = it.end;
            }else if(it.end > end){
                Interval pre = result.remove(result.size() - 1);
                pre = new Interval(pre.start,it.end);
                result.add(pre);
                end = it.end;
            }
        }
        return result;
    }
}

class IntervalComparator implements Comparator<Interval>{
    @Override
    public int compare(Interval it1, Interval it2){
        return it1.start - it2.start;
    }
}


