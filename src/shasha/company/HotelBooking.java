package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBooking {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2,3,4));
        System.out.println(hotel(a,b,1));
    }
    private static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int currmax=0,finalmax=0;
        int i=0, j=0;
        while(i<arrive.size() && j<depart.size())
        {
            if(arrive.get(i)<depart.get(j)) {
                currmax++;
                i++;
            }
            else{
                currmax--;
                j++;
            }

            finalmax=Math.max(currmax,finalmax);
        }
        return finalmax<=k;
    }
}
