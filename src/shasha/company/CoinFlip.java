package shasha.company;

public class CoinFlip {
    public static void main(String[] args) {
        CoinFlip coinFlip = new CoinFlip();
        System.out.println(coinFlip.findTurns(10));
    }

    private int findTurns(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            int c = 0;
            for (int i = 0; i < n; i++) {
                double rand = Math.random();
                if (rand > 0.5)
                    c++;
            }
            n = c;
        }
        return count;
    }

}
