package AdventOfCode2022;
import java.util.*;


import javax.print.attribute.HashAttributeSet;

import java.io.File;
import java.io.FileNotFoundException;

public class Day3_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day3.txt");
        Scanner sc = new Scanner(file);
        int result = 0;

        while (sc.hasNextLine()) {
            char[] one = sc.nextLine().toCharArray();
            char[]  two = sc.nextLine().toCharArray();
            char[]  three = sc.nextLine().toCharArray();
            char tempresult = 'A';
            for (char i : one) {
                for (char j : two) {
                    for (char k : three) {
                        if (i == j && i == k) {
                            tempresult = i;
                        }
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