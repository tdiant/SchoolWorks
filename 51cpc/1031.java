import java.util.Scanner;

/*
* 注意:
* 本源码基于C++代码处理而来，并没有通过评测机的评测
* 评测机由于无法正确处理中文字符，无法使得本源码编译通过
 */
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int
                a = scanner.nextInt(),
                b = scanner.nextInt(),
                c = scanner.nextInt();

        double cosA = getCos(b, c, a);
        double cosB = getCos(c, a, b);
        double cosC = getCos(a, b, c);

        double p = 0.5 * (a + b + c);
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c) * 1.0);

        boolean flag = false;

        if (a + b > c && a + c > b && b + c > a) {
            if (cosA == 0 || cosB == 0 || cosC == 0) {
                System.out.print("直角三角形");
                flag = true;
            } else if (cosA < 0 || cosB < 0 || cosC < 0) {
                System.out.print("钝角三角形");
                flag = true;
            } else if (cosA > 0 && cosB > 0 && cosC > 0) {
                System.out.print("锐角三角形");
                flag = true;
            } else {
                System.out.print("ERROR");
            }
        } else {
            System.out.print("ERROR");
        }

        if (flag)
            System.out.printf("\n%.2lf", s);
    }


    public static double getCos(int a, int b, int c) {
        return (a * a + b * b - c * c) * 1.0 / (2 * a * b);
    }
}
