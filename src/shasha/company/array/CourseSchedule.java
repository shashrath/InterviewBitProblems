package shasha.company.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] courses = {{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}};
        System.out.println(scheduleCourse(courses));
    }

    public static int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));
        Arrays.sort(courses, (x, y) -> Integer.compare(x[1], y[1]));
        int totalTime = 0;
        int max = 0;
        for (int i = 0; i < courses.length; i++) {
            if (totalTime + courses[i][0] <= courses[i][1]) {
                totalTime += courses[i][0];
                heap.add(courses[i]);
                max = Math.max(max, heap.size());
            } else {
                if (!heap.isEmpty() && totalTime + courses[i][0] > courses[i][1]) {
                    int[] highestDuration = heap.poll();
                    totalTime = totalTime - highestDuration[0];
                    if(totalTime+ highestDuration[0] <= totalTime+ courses[i][0]) {
                        totalTime += highestDuration[0];
                        heap.add(highestDuration);
                    }else{
                        totalTime += courses[i][0];
                        heap.add(courses[i]);
                    }
                }
            }
        }
        return max;
    }

    public static int scheduleCourse1(int[][] courses) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> Integer.compare(y,x));
        Arrays.sort(courses, Comparator.comparingInt(x -> x[1]));
        int totalTime = 0;
        int max = 0;
        for (int[] course : courses) {
            totalTime = totalTime + course[0];
            heap.add(course[0]);
            if (totalTime > course[1]) {
                Integer val = heap.poll();
                if(val!=null)
                totalTime = totalTime - val;
            }
            max = Math.max(max, heap.size());
        }
        return max;
    }
}
