package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Triplets {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(Arrays.asList("0.503094", "0.648924", "0.999298"));
        System.out.println(solve(al));
    }
//    public static int solve(ArrayList<String> A) {
//        Double maxa1=Double.MIN_VALUE,maxa2=Double.MIN_VALUE,maxa3=Double.MIN_VALUE;
//        Double mina1=Double.MAX_VALUE,mina2=Double.MAX_VALUE;
//        Double maxb1=Double.MIN_VALUE;
//        Double minb1=Double.MAX_VALUE, minb2=Double.MAX_VALUE;
//        Double c = Double.MAX_VALUE;
//        for(int i=0 ; i<A.size(); i++){
//            Double temp = Double.parseDouble(A.get(i));
//            if(temp > 0.0 && temp < 2.0/3){
//                if(temp> maxa1){
//                    maxa3=maxa2;
//                    maxa2= maxa1;
//                    maxa1 = temp;
//                }
//                else if(temp > maxa2){
//                    maxa3=maxa2;
//                    maxa2 = temp;
//                }
//                else if (temp > maxa3)
//                    maxa3 = temp;
//
//                if(temp<mina1) {
//                    mina2 = mina1;
//                    mina1 = temp;
//                }
//                else if(temp<mina2)
//                    mina2 = temp;
//            }
//
//            else if(temp >=2.0/3 && temp <1.0){
//                if(temp > maxb1)
//                    maxb1 =temp;
//
//                if(temp<minb1){
//                    minb2 = minb1;
//                    minb1= temp;
//                }
//                else if(temp<minb2)
//                    minb2 = temp;
//            }
//
//            else if(temp >1.0 && temp <2.0){
//                if(temp  <c ){
//                    c= temp ;
//                }
//            }
//        }
//
//        if(maxa3!=Double.MIN_VALUE && maxa2!=Double.MIN_VALUE && maxa1!= Double.MIN_VALUE && maxa1+maxa2+maxa3 > 1.0)
//            return 1;
//        else if(maxa1!=Double.MIN_VALUE && maxa2!= Double.MIN_VALUE && minb1!= Double.MAX_VALUE && maxb1!= Double.MIN_VALUE && maxa1+maxa2+minb1>1.0 && maxa1+maxa2+maxb1< 2.0){
//            return 1;
//        }
//        else if(c!=Double.MAX_VALUE && mina1!=Double.MAX_VALUE && mina2!= Double.MAX_VALUE && c+mina1+mina2 < 2.0){
//            return 1;
//        }
//        else if(minb1!=Double.MAX_VALUE && minb2!=Double.MAX_VALUE & mina1!= Double.MAX_VALUE && minb1+minb2+mina1 < 2.0)
//            return 1;
//        else if(mina1!=Double.MAX_VALUE && minb1!=Double.MAX_VALUE && c!=Double.MAX_VALUE && mina1+minb1+c < 2.0)
//            return 1;
//        else
//            return 0;
//    }

    private static int solve(ArrayList<String> A) {
        int n = A.size();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.valueOf(A.get(i));
        }
        double a = arr[0], b = arr[1], c = arr[2];
        for (int i = 3; i < n; i++) {
            // check if sum fall in (1, 2)
            if (a + b + c > 1 && a + b + c < 2) {
                return 1;
            }
            // if not, then check is sum greater than 2
            // if so, then replece MAX(a,b,c) to new number
            else if (a + b + c > 2) {
                if (a > b && a > c) {
                    a = arr[i];
                } else if (b > a && b > c) {
                    b = arr[i];
                } else if (c > a && c > b) {
                    c = arr[i];
                }
            }
            // else then sum must be less than 1
            // then replace MIN(a,b,c) to new number
            else {
                if (a < b && a < c) {
                    a = arr[i];
                } else if (b < a && b < c) {
                    b = arr[i];
                } else if (c < a && c < b) {
                    c = arr[i];
                }
            }
        }
        // check for last a, b, c  triplet
        if (a + b + c > 1 && a + b + c < 2) {
            return 1;
        } else {
            return 0;
        }
    }
}
