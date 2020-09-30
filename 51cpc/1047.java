import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m;
        List<Integer> integers = new ArrayList<>();
        for(int i=0;i<n;i++)
            integers.add(scanner.nextInt());
        m = scanner.nextInt();
        for(int i=0;i<m;i++)
            System.out.println(integers.get(i));
    }
}
