package shasha.company.array;

import java.util.*;
/*
* InterviewBit
* Brick Wall */
public class BrickWall {
    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> a = new ArrayList<>(Arrays.asList(1,2,2,1));
        List<Integer> b = new ArrayList<>(Arrays.asList(3,1,2));
        List<Integer> c = new ArrayList<>(Arrays.asList(1,3,2));
        List<Integer> d = new ArrayList<>(Arrays.asList(2,4));
        List<Integer> e = new ArrayList<>(Arrays.asList(3,1,2));
        List<Integer> f = new ArrayList<>(Arrays.asList(1,3,1,1));

/*        List<Integer> a = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> b = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> c = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> d = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> e = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> f = new ArrayList<>(Arrays.asList(1,2));*/
        wall.add(a);
        wall.add(b);
        wall.add(c);
        wall.add(d);
        wall.add(e);
        wall.add(f);
        BrickWall brickWall = new BrickWall();
        System.out.println(brickWall.leastBricks(wall));
    }
    public int leastBricks(List<List<Integer>> wall) {
        for(int i=0;i<wall.size();i++){
            for(int j=1;j<wall.get(i).size();j++){
                wall.get(i).set(j, wall.get(i).get(j)+ wall.get(i).get(j-1));
            }
        }
        printWall(wall);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<wall.size();i++){
            for(int j=0;j<wall.get(i).size()-1;j++){
                if(map.containsKey(wall.get(i).get(j)))
                {
                    map.put(wall.get(i).get(j),map.get(wall.get(i).get(j))+1);
                }
                else
                    map.put(wall.get(i).get(j), 1);
            }
        }
        if(map.isEmpty())
            return wall.size();
        int max =Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            max = Math.max(max,entry.getValue());
        }
        return wall.size()-max;
    }
    
    // Huge Reduce in size of Code
    public int leastBricks1(List<List<Integer>> wall){
        Map<Integer,Integer> map = new HashMap<>();
        int count =  0;
        for(List<Integer> row : wall){
            int sum = 0;
            for(int i=0;i<row.size()-1;i++){
                sum = sum+row.get(i);
                map.put(sum, map.getOrDefault(sum,0)+1);
                count = Math.max(count,map.get(sum));
            }
        }
        return wall.size()-count;
    }
    
    
    
    public void printWall(List<List<Integer>> wall){
        for(int i=0;i<wall.size();i++){
            for(int j=0;j<wall.get(i).size();j++){
                System.out.print(wall.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

}
