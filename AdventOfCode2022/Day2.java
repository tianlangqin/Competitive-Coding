package AdventOfCode2022;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day2.txt");
        Scanner sc = new Scanner(file);
        int result = 0; 
        while (sc.hasNextLine()) {
            String[] temp = sc.nextLine().split(" ");

            //rock
            if (temp[1].equals("X")) {
                result += 1;
                if (temp[0].equals("A")) {
                    result += 3;
                }
                if (temp[0].equals("C")) {
                    result += 6;
                }
            }

            //paper 
            if (temp[1].equals("Y")) {
                result += 2;
                if (temp[0].equals("B")) {
                    result += 3;
                }
                if (temp[0].equals("A")) {
                    result += 6;
                }
            }

            //scissors
            if (temp[1].equals("Z")) {
                result += 3;
                if (temp[0].equals("C")) {
                    result += 3;
                }
                if (temp[0].equals("B")) {
                    result += 6;
                }
            }
        }
        System.out.println(result);
    }
}
