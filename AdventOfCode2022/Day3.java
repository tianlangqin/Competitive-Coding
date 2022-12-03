package AdventOfCode2022;
import java.util.*;


import javax.print.attribute.HashAttributeSet;

import java.io.File;
import java.io.FileNotFoundException;

public class Day3 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day3.txt");
        Scanner sc = new Scanner(file);
        int result = 0;

        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            // 0 1 2 3 4 5 6 7
            char[] first = temp.substring(0, temp.length() / 2).toCharArray();
            char[] last = temp.substring(temp.length() / 2).toCharArray();

            // for (char i : first ) {
            //     System.out.print(i);
            // }
            // System.out.println();
            // for (char i : last ) {
            //     System.out.print(i);
            // }
            char tempresult = '0';
            for (char i : first) {
                for (char j : last) {
                    // System.out.println(i + " " + j);
                    // System.out.println(i == j);
                    // System.out.println();
                    if (i == j) {
                        tempresult = i;
                            
                    }
                    
                }
            }
            if (Character.isUpperCase(tempresult)) {
                result += tempresult - 'A' + 27;
                //System.out.println(tempresult - 'A' + 27);
                
            }
            else {
                result += tempresult - 'a' + 1;
                //System.out.println(tempresult - 'a' + 1);
                
            }
            
        }

        System.out.println(result);

    }
}