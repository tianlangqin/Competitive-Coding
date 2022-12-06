package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day6 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day6.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length - 3; i++) {
            if (arr[i] != arr[i + 1] && arr[i +1 ] != arr[i + 2] && arr[i + 2] != arr[i + 3] 
            && arr[i] != arr[i + 2] && arr[i] != arr[i + 3] && arr[i + 1] != arr[i + 3]) {
                System.out.println(i + 4);
                break;
            }
        }
    }
}