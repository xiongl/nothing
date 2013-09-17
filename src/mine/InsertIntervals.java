package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/17/13
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> list = new ArrayList<Interval>();
        if (intervals==null || intervals.size()==0) {
            list.add(newInterval);
            return list;
        }
        for (Interval interval : intervals) {
            if (newInterval == null) {
                list.add(interval);
            } else if (interval.end < newInterval.start) {
                list.add(interval);
            } else if (interval.start > newInterval.end) {
                list.add(newInterval);
                list.add(interval);
                newInterval = null;
            } else {
                newInterval.start = interval.start < newInterval.start ?
                        interval.start : newInterval.start;
                newInterval.end = interval.end > newInterval.end ?
                        interval.end : newInterval.end;
            }
        }
        if (newInterval != null)
            list.add(newInterval);
        return list;
    }

    public static void main(String[] args) {
        Interval first = new Interval(1,5);
        Interval second = new Interval(2,7);
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(first);
        new InsertIntervals().insert(list, second);
    }
}
