package AdventOfCode2016;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2016/day2.txt");
        Scanner input = new Scanner(file);
        int yPos = 2;
        int xPos = 0;
        char[][] keypad = {{0,0,'1',0,0},{0,'2','3','4',0},{'5','6','7','8','9'},{0,'A','B','C',0},{0,0,'D',0,0}};
        while (input.hasNextLine()) {
            char[] arr = input.nextLine().toCharArray();
            for (char ch : arr) {
                if (ch == 'U' && yPos > 0) {
                    if (xPos == 0 || xPos == 4) {
                        continue;
                    }
                    if (xPos == 1 || xPos == 3) {
                        if (yPos > 1) 
                            yPos--;
                    }
                    else {
                        yPos--;
                    }
                }

                if (ch == 'D' && yPos < 4) {
                    if (xPos == 0 || xPos == 4) {
                       continue;
                    }
                    if (xPos == 1 || xPos == 3) {
                        if (yPos < 3) 
                            yPos++;
                    }
                    else {
                        yPos++;
                    }
                }
                
                if (ch == 'L' && xPos > 0) {
                    if (yPos == 0 || yPos == 4) {
                        continue;
                    }
                    if (yPos == 1 || yPos == 3) {
                        if (xPos > 1) 
                            xPos--;
                    }
                    else {
                        xPos--;
                    }
                }
                   
                if (ch == 'R' && xPos < 4) {
                    if (yPos == 0 || yPos == 4) {
                        continue;
                    }
                    if (yPos == 1 || yPos == 3) {
                        if (xPos < 3) 
                            xPos++;
                    }
                    else {
                        xPos++;
                    }
                }
                
                // System.out.println();
                // System.out.println(xPos);
                // System.out.println(yPos);
            }
            System.out.println(keypad[yPos][xPos]);
        }
    }
}