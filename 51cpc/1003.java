import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char c = new Scanner(System.in).next().charAt(0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(c);
            }
            System.out.print("\n");
        }
    }
}
