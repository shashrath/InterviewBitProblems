package shasha.company.bfs;

import java.util.*;
import java.util.stream.Collectors;

public class OpenLock {
    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        long currTime = System.currentTimeMillis();
        Integer result = openLock.openLock(deadends, "6252");
        System.out.println(result);
        System.out.println(System.currentTimeMillis()-currTime);
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.add("0000");
        Set<String> deadPath = Arrays.stream(deadends).collect(Collectors.toSet());
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
              String val = queue.poll();
              if(!deadPath.add(val)) continue;
              if(val.equals(target)) return count;

              for(String nextVal: getNextStates(val)){
                  if(!deadPath.contains(nextVal))
                      queue.offer(nextVal);
              }
            }
            count++;
        }
        return -1;
    }

    private List<String> getNextStates(String lock) {
        List<String> locks = new LinkedList<>();
        char[] arr = lock.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c;
        }
        return locks;
    }
}
