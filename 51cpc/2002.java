import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        String dateStr = new Scanner(System.in).next();
        Date date = new Date(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM--dd");
        System.out.println(sdf.format(date));
    }
}
