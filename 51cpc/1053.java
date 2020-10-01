import java.util.Scanner;

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

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                System.out.print(juZhen[a][b] + " ");
            }
            System.out.print("\n");
        }
    }
}
