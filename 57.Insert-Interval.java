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
        
        // 各个区间一共有以下几种情况:
        // 完全在左, 完全在右 (直接压进结果list)
        // s在左 e在里, 完全在里, s在里 e在右, 包裹new (与new存在重合,加载区间进new)
        // 可能要注意一下边界问题

        List<Interval> result = new ArrayList<>();
        
        for (Interval interval : intervals){
            
            if (interval.end < newInterval.start) {
                // 此区间完全在new左边,加到结果中,再取下一个循环
                result.add(interval);
                continue;
            }
            
            if (interval.start > newInterval.end) {
                // 完全在右
                result.add(interval);
                continue;
            }
            
            
            if (interval.end >= newInterval.end){
                // 由于前面有完全在右的判断, 此处不可能完全在右
                if ((interval.start <= newInterval.end) && (interval.start >= newInterval.start)){
                    // s在里 e在右
                    newInterval.end = interval.end;
                    continue;
                }
                else {
                    // 区间包裹new
                    newInterval.start = interval.start;
                    newInterval.end = interval.end;
                    continue;
                }
            }
            
            if (interval.end < newInterval.end){
                if (interval.start >= newInterval.start){
                    // 区间完全在new内部
                    continue;
                }
                else {
                    // s在左 e在里
                    newInterval.start = interval.start;
                    continue;
                }
            }
            
        }
        
        result.add(newInterval);
        result.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        return result;
        
    }
}