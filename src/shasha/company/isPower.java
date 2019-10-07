package shasha.company;

public class isPower {
    public static void main(String[] args) {
        System.out.println(calcultePower(55555555));
    }

    private static int calcultePower(int A) {
        if (A < 2)
            return 1;
        for (int i = 2; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                int temp = A;
                while (temp % i == 0 && temp != 1 && temp / i != 1) {
                    temp = temp / i;
                }
                if (temp % i == 0 && temp / i == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
