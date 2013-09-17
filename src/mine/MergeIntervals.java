package mine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/16/13
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeIntervals {


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> list = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return list;
        Collections.sort(intervals, new IntervalComparator());
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if (curr.end >= next.start ) {
                next.start = curr.start;
                if (curr.end > next.end) {
                    next.end = curr.end;
                }
            } else {
                list.add(curr);
            }
        }
        list.add(intervals.get(intervals.size() - 1));
        return list;
    }

    public static void main(String[] args) {
        Interval first = new Interval(1,4);
        Interval second = new Interval(5,6);
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(first);
        list.add(second);
        new MergeIntervals().merge(list);
    }

    class IntervalComparator implements Comparator {


        @Override
        public int compare(Object first, Object second) {
            int startFirst = ((Interval) first).start;
            int startSecond = ((Interval) second).start;
            if (startFirst < startSecond)
                return -1;
            else if (startFirst == startSecond)
                return 0;
            else
                return 1;
        }
    }
}
