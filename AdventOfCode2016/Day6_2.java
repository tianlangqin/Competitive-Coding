package AdventOfCode2016;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day6_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2016/day6.txt");
        Scanner sc = new Scanner(file);
        ArrayList<char[]> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            input.add(sc.nextLine().toCharArray());
        }

        for (int i = 0; i < 8; i++) {
            HashMap<Character,Integer> count = new HashMap<>();
            for (int j = 0; j < input.size(); j++) {
                char currChar = input.get(j)[i];
                if (count.containsKey(currChar))
                    count.put(currChar, count.get(currChar) + 1);
                else 
                    count.put(currChar, 1);
            }
            
            char resultchar = '0';
            int result = Integer.MAX_VALUE;
            for (char ch : count.keySet()) {
                if (count.get(ch) < result) {
                    resultchar = ch;
                    result = count.get(ch);
                }
            }
            System.out.println( resultchar + " " + result);
        }

    }
}
