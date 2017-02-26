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
        
        // ��������һ�������¼������:
        // ��ȫ����, ��ȫ���� (ֱ��ѹ�����list)
        // s���� e����, ��ȫ����, s���� e����, ����new (��new�����غ�,���������new)
        // ����Ҫע��һ�±߽�����

        List<Interval> result = new ArrayList<>();
        
        for (Interval interval : intervals){
            
            if (interval.end < newInterval.start) {
                // ��������ȫ��new���,�ӵ������,��ȡ��һ��ѭ��
                result.add(interval);
                continue;
            }
            
            if (interval.start > newInterval.end) {
                // ��ȫ����
                result.add(interval);
                continue;
            }
            
            
            if (interval.end >= newInterval.end){
                // ����ǰ������ȫ���ҵ��ж�, �˴���������ȫ����
                if ((interval.start <= newInterval.end) && (interval.start >= newInterval.start)){
                    // s���� e����
                    newInterval.end = interval.end;
                    continue;
                }
                else {
                    // �������new
                    newInterval.start = interval.start;
                    newInterval.end = interval.end;
                    continue;
                }
            }
            
            if (interval.end < newInterval.end){
                if (interval.start >= newInterval.start){
                    // ������ȫ��new�ڲ�
                    continue;
                }
                else {
                    // s���� e����
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