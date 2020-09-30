import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[1005];
        int m;
        for(int i=0 ;i<n; i++)
            nums[i] = scanner.nextInt();
        m = scanner.nextInt();
        for (int a = 0; a < m; a++) {
            int index = scanner.nextInt();
            if (nums[index - 1] % 2 == 1) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
