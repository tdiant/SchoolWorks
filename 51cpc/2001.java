import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 2 integers:");
        int a = scanner.nextInt(), b = scanner.nextInt();
        System.out.printf("\n%d+%d=%d",a,b,a+b);
    }
}