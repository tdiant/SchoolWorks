import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int target = new Scanner(System.in).nextInt();
        System.out.println(getFibonacci(target));
    }

    public static int getFibonacci(int target) {
        if (target == 1) return 0;
        if (target == 2) return 1;
        return getFibonacci(target, 3, 1, 0);
    }

    public static int getFibonacci(int target, int i, int a, int b) {
        if (i > target + 1)
            return a;
        return getFibonacci(target, i + 1, a + b, a);
    }
}
