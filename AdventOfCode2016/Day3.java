package AdventOfCode2016;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2016/day3.txt");
        Scanner input = new Scanner(file);

        int result = 0;
        while(input.hasNextLine()) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();

            if(a + b > c && a + c > b && b + c > a) {
                result ++;
            }
        }
        System.out.println(result);
     
        
    }
}
