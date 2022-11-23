package AdventOfCode2016;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2016/day1.txt");
        Scanner input = new Scanner(file);
        String[] instructions = input.nextLine().split(", ");
        int xDis = 0;
        int yDis = 0;
        // 0 is north, 1 is east, 2 is south, 3 is west;
        //int[] directions = {};
        int facing = 0;

        //for(String i : instructions) {
        //  System.out.println(i);
        //}

        for (int i = 0; i < instructions.length; i++) {
            if (instructions[i].charAt(0) == 'L') {
                facing --;
                facing = (facing + 4) % 4;
            }
            else {
                facing ++;
                facing %= 4;
            }

           // System.out.println("facing" + facing);
            
            int a = Integer.parseInt(instructions[i].substring(1));
            //System.out.println(a);
            if (facing == 0) 
                xDis += a;
            if (facing == 1)
                yDis += a;
            if (facing == 2)
                xDis -= a;
            if (facing == 3)
                yDis -= a;

            //System.out.println(xDis);
            //System.out.println(yDis);
        } 
        System.out.println((int)(Math.abs(xDis) + Math.abs(yDis)));
    }
}
