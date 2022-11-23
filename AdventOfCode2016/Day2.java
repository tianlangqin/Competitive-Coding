package AdventOfCode2016;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2016/day2.txt");
        Scanner input = new Scanner(file);
        int yPos = 1;
        int xPos = 1;
        int[][] keypad = {{1,2,3},{4,5,6},{7,8,9}};
        while (input.hasNextLine()) {
            char[] arr = input.nextLine().toCharArray();
            for (char ch : arr) {
                if (ch == 'U' && yPos > 0)
                    yPos--;
                if (ch == 'D' && yPos < 2)
                    yPos++;
                if (ch == 'L' && xPos > 0)
                    xPos--;
                if (ch == 'R' && xPos < 2)
                    xPos++;
                
                //System.out.println();
                //System.out.println(xPos);
                //System.out.println(yPos);
            }
            System.out.println(keypad[yPos][xPos]);
        }
    }
}
