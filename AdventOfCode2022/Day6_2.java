package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day6_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day6.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length - 13; i++) {
            boolean ok = true;
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < i + 14; j ++) {
                if (!set.contains(arr[j])) {
                    set.add(arr[j]);
                }
                else {
                    ok = false;
                }
            }
            if (ok) {
                System.out.println(i + 14);
                break;
            }
        }
    }
}