package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day4_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day4.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        
        while (sc.hasNextLine()) {

            String[] temp = sc.nextLine().split(",");
            String[] first;
            String[] last;
            
            first = temp[0].split("-");
            last = temp[1].split("-");

            //System.out.println(temp[0]);
            //System.out.println(temp[1]);

            if (Integer.parseInt(first[0])  >= Integer.parseInt(last[0]) && 
                Integer.parseInt(first[1]) <= Integer.parseInt(last[1])) {
                result++;
            }

            else if (Integer.parseInt(first[0])  <= Integer.parseInt(last[0]) && 
                Integer.parseInt(first[1]) >= Integer.parseInt(last[1])) {
                result++;
            }

            else if (Integer.parseInt(first[1]) >= Integer.parseInt(last[0]) && 
                    Integer.parseInt(last[1]) >= Integer.parseInt(first[0])                    
                    ) {
                result++;
            }

            else if (Integer.parseInt(last[1]) <= Integer.parseInt(first[0]) && 
                     Integer.parseInt(first[1]) <= Integer.parseInt(last[0])) {
                result++;
            }
        }
        System.out.println(result);
    }
}