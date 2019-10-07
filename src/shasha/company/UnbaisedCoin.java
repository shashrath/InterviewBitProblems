package shasha.company;

import java.util.Random;
import java.util.Scanner;

public class UnbaisedCoin {

    public static void main(String[] args) {
        System.out.println("do coin toss 5how many times?");
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(biasedCoin());
        }
    }

    private static String biasedCoin() {
        Random rand = new Random();
        int val = rand.nextInt(100);
        return (val <= 60) ? "HEAD" : "TAIL";
    }
}
