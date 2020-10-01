import java.util.Scanner;

/*
* 1054 is same as 1055
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int juZhen[][] = new int[105][105];

        int
                n = scanner.nextInt(),
                m = scanner.nextInt();

        //init
        for (int a = 0; a < n; a++)
            for (int b = 0; b < m; b++)
                juZhen[a][b] = scanner.nextInt();

        int q = scanner.nextInt();

        for (int a = 0; a < q; a++) {
            int i = scanner.nextInt() - 1;
            int j = scanner.nextInt() - 1;
            System.out.println(juZhen[i][j]);
        }
    }
}
