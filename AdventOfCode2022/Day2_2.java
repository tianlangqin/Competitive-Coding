package AdventOfCode2022;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day2.txt");
        Scanner sc = new Scanner(file);
        int result = 0; 
        while (sc.hasNextLine()) {
            String[] temp = sc.nextLine().split(" ");
            //lose
            if (temp[1].equals("X")) {

                if (temp[0].equals("A")) {
                    result += 3;
                }
                if (temp[0].equals("B")) {
                    result += 1;
                }
                if (temp[0].equals("C")) {
                    result += 2;
                }
            }

            //tie
            if (temp[1].equals("Y")) {
                result += 3;
                if (temp[0].equals("A")) {
                    result += 1;
                }
                if (temp[0].equals("B")) {
                    result += 2;
                }
                if (temp[0].equals("C")) {
                    result += 3;
                }
            }

            //win
            if (temp[1].equals("Z")) {
                result += 6;
                if (temp[0].equals("A")) {
                    result += 2;
                }
                if (temp[0].equals("B")) {
                    result += 3;
                }
                if (temp[0].equals("C")) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
