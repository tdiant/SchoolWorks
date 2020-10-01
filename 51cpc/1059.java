import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next(), find = scanner.next();
        System.out.println(str.indexOf(find) + 1);
    }
}
