import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {
    public static void main (String args[]) throws FileNotFoundException {
        //javac Day1.java
        //java Day1
        File file = new File("Day1.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        while(sc.hasNextLine()) {
            int first = -1;
            int last = -1;
            String input = sc.nextLine();
            char[] arr = input.toCharArray();
            for (char ch : arr) {
                if (Character.isDigit(ch)) {
                    if (first == -1) {
                        first = Character.getNumericValue(ch);
                    }
                    last = Character.getNumericValue(ch);

                }   
            }
            result += 10 * first + last;
        }
        System.out.println();
        System.out.println(result);
    }
}