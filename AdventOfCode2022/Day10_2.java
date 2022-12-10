package AdventOfCode2022;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day10_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day10.txt");
        Scanner sc = new Scanner(file);
        String result = "";
        int size = 136;
        int cycle = 1;
        int x = 1;

        String[][] input = new String[size][];
        for (int i = 0; i < size; i++) {
            input[i] = sc.nextLine().split(" ");
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int check = (cycle - 1) % 40;
            if (check == 0) {
                if (Math.abs(check - x) <= 1) {
                    list.add("\n#");
                }
                else {
                    list.add("\n.");
                }
            }
            else {
                if (Math.abs(check - x) <= 1) {
                    list.add("#");
                }
                else {
                    list.add(".");
                }
            }
            if (input[i][0].equals("noop")) {
                cycle ++;
            }
            else if (input[i][0].equals("addx")) {
                int temp = Integer.parseInt(input[i][1]);
                cycle++;
                check = (cycle - 1) % 40;
                if (check == 0) {
                    if (Math.abs(check - x) <= 1) {
                        list.add("\n#");
                    }
                    else {
                        list.add("\n.");
                    }
                }
                else {
                    if (Math.abs(check - x) <= 1) {
                        list.add("#");
                    }
                    else {
                        list.add(".");
                    }
                }
                cycle++;
                x += temp;
            }
        }

        for (String i : list) {
            result += i;
        }
        System.out.println(result);
    }
}