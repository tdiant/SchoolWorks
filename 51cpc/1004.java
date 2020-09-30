import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        for (int i = 0; i < 3; i++) {
            str = scanner.next();
            int spaceNum = 8 - str.length();
            for (int j = 0; j < spaceNum; j++) {
                System.out.print(" ");
            }
            System.out.println(str);
        }
    }
}
