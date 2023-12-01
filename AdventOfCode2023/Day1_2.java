import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Day1_2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Day1.txt");
        Scanner sc = new Scanner(file);
        String line;
        int sum = 0;
        while (sc.hasNextLine()) {
            sum += solve(sc.nextLine());
        }
        sc.close();
        System.out.println(sum);
    
    }

    private static int solve(String line) {
    String[] spelledNumbers = {"zero", "one", "two", "three", "four", 
                               "five", "six", "seven", "eight", "nine"};
    Pattern p = Pattern.compile("\\d|zero|one|two|three|four|five|six|seven|eight|nine");
    Matcher m = p.matcher(line);
    int firstDigit = -1, lastDigit = -1;

    while (m.find()) {
        int digit = -1;
        String match = m.group();

        if (Character.isDigit(match.charAt(0))) {
            digit = Integer.parseInt(match);
        } else {
            for (int i = 0; i < spelledNumbers.length; i++) {
                if (match.equals(spelledNumbers[i])) {
                    digit = i;
                    break;
                }
            }
        }

        if (firstDigit == -1) firstDigit = digit;
        lastDigit = digit;
    }

    return firstDigit != -1 ? firstDigit * 10 + lastDigit : 0;
}
}