import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean qiPan[][] = new boolean[105][105];

        int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();

        // init
        for (int a = 0; a < 105; a++)
            for (int b = 0; b < 105; b++) qiPan[a][b] = false;

        for (int a = 0; a < q; a++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            qiPan[i - 1][j - 1] = true;
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                System.out.print((qiPan[a][b] ? "1" : "0") + " ");
            }
            System.out.print("\n");
        }
    }
}
