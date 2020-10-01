import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str =
                new Scanner(System.in).nextLine()
                        .replace(". ", ".")
                        .replace("? ","?")
                        .replace("! ","!")
                        .replace(", ", ",")
                        .replace(",", ", ")
                        .replace("'"," ");
        while (str.contains("  "))
            str = str.replace("  "," ");

        System.out.println(str.length() - str.replace(" ","").length() + 1);
    }
}
