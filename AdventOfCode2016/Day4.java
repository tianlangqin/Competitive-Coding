package AdventOfCode2016;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day4 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2016/day4.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String s = input.nextLine();
            
            HashMap<Character, Integer> map = new HashMap<>();
        }
        

    }

    static int getID(String s) {
        return Integer.parseInt(s.substring(0,s.indexOf("[")));
    }

    static String getCheckSum(String s) {
        return s.substring(s.indexOf("[") + 1, s.length()-1);
    }

    static char rot(int rotation, char c) {
        return (char) ((((c - 'a') + rotation ) % 26) + 'a');
    }
}
