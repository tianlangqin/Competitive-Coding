package AdventOfCode2022;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day1.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        int current = 0; 
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            
            //System.out.println(temp);
            if (temp.isEmpty()) {
                current = 0;
                continue;
            }
            current += Integer.parseInt(temp);
            
            System.out.println(current);
            result = Math.max(current, result);
        }
        System.out.println();
        System.out.println(result);
        
        


    }
}