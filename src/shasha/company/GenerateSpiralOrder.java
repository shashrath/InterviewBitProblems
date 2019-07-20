package shasha.company;

import java.util.ArrayList;

public class GenerateSpiralOrder {
    public static void main(String[] args) {
        generateMatrix(10000);
    }
    private static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<a;i++)
        {
            ArrayList<Integer> b = new ArrayList<>();
            for(int j=0;j < a;j++)
            {
                b.add(0);
            }
            al.add(b);
        }

        // Spiral Matrix Program

        int t=0,b=a-1,l=a-1,r=0;
        int dir=0;
        int count=1;
        while(t<=b && r<=l)
        {
            //first traverse the top row
            if(dir == 0)
            {
                for(int i=r;i<=l;i++)
                {
                    //al.add(A.get(t).get(i));
                    al.get(t).set(i,count);
                    count++;
                }
                t++;
                dir=dir+1;
            }

            //second traverse the leftmost column
            else if(dir == 1){
                for(int i=t;i<=b;i++)
                {
                    //al.add(A.get(i).get(l));
                    al.get(i).set(l,count);
                    count++;
                }
                l--;
                dir=dir+1;
            }

            //third traverse the bottommost row
            else if(dir == 2){
                for(int i=l;i>=r;i--)
                {
                    //al.add(A.get(b).get(i));
                    al.get(b).set(i,count);
                    count++;
                }
                b--;
                dir=dir+1;
            }

            //fourth traverse the rightmost column
            else if(dir == 3){
                for(int i=b;i>=t;i--)
                {
                    //al.add(A.get(i).get(r));
                    al.get(i).set(r,count);
                    count++;
                }
                r++;
                dir=dir+1;
            }
            dir= (dir)%4;
        }




        for(ArrayList<Integer> c : al)
        {
            for(Integer d: c){
                System.out.print(d +" ");
            }
            System.out.println();
        }
        return al;
    }
}
