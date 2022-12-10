package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day10 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day10.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        int size = 136;
        int cycle = 1;
        int x = 1;

        String[][] input = new String[size][];
        for (int i = 0; i < size; i++) {
            input[i] = sc.nextLine().split(" ");
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if ((cycle + 20) % 40 == 0) {
                list.add(x * cycle);
            }
            else {
                list.add(0);
            }
            if (input[i][0].equals("noop")) {
                cycle ++;
            }
            else if (input[i][0].equals("addx")) {
                int temp = Integer.parseInt(input[i][1]);
                cycle++;
                if ((cycle - 20) % 40 == 0) {
                    System.out.println(x);
                    list.add(x * cycle);
                }
                else {
                    list.add(0);
                }
                cycle++;
                x += temp;
            }
        }

        for (int i : list) {
            result += i;
        }
        System.out.println(result);
    }
}