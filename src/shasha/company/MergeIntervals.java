package shasha.company;

import java.util.ArrayList;
import java.util.Collections;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> al = new ArrayList<>();
        Interval a1 = new Interval(1,3);
        Interval a2 = new Interval(8,10);
        Interval a3 = new Interval(2,6);
        Interval a4 = new Interval(15,18);
        Interval a5 = new Interval(17,21);
        al.add(a1);
        al.add(a2);
        al.add(a3);
        al.add(a4);
        al.add(a5);
        merge(al);

    }
        private static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
            Collections.sort(intervals, (x,y) -> {
               if(x.start<y.start)
                   return -1;
               else if(x.start> y.start)
                   return 1;
               else
                   return 0;
            });
           for(int i=0 ;i<intervals.size()-1 ; i++){
             if(Math.max(intervals.get(i).start,intervals.get(i+1).start)
                     <= Math.min(intervals.get(i).end,intervals.get(i+1).end)) {
                 intervals.get(i).end=Math.max(intervals.get(i).end,intervals.get(i+1).end);
                 intervals.remove(i+1);
                 i--;
               }
           }
            return intervals;
    }
}

