import java.util.*;

public class T1062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine().replace(" ", "");
            Set<Character> charSet = new HashSet<>();
            for (char c : str.toCharArray())
                charSet.add(c);

            char maxChar = '\0';
            int maxCharNum = -1;

            for (char c : charSet) {
                int num = str.length() - str.replace(c + "", "").length();
                if (num > maxCharNum || (num == maxCharNum && c < maxChar)) {
                    maxChar = c;
                    maxCharNum = num;
                }
            }

            System.out.println(maxChar + " " + maxCharNum);
        }
    }
}
